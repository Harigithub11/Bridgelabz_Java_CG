package datastructures.linkedlist.singlylinkedlist;

import java.util.Scanner;

public class SocialMediaFriendConnections {

    private UserNode head;
    private int userCount;

    private static class FriendNode {
        int friendId;
        FriendNode next;

        FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    private static class UserNode {
        int userId;
        String name;
        int age;
        FriendNode friendsHead;
        int friendCount;
        UserNode next;

        UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendsHead = null;
            this.friendCount = 0;
            this.next = null;
        }
    }

    public SocialMediaFriendConnections() {
        this.head = null;
        this.userCount = 0;
    }

    public void addUser(int userId, String name, int age) {
        if (findUser(userId) != null) {
            System.out.println("User with ID " + userId + " already exists.");
            return;
        }
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
        userCount++;
        System.out.println("User added successfully.");
    }

    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (areFriends(user1, userId2)) {
            System.out.println("Users are already friends.");
            return;
        }

        addFriendToList(user1, userId2);
        addFriendToList(user2, userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name + ".");
    }

    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        removeFriendFromList(user1, userId2);
        removeFriendFromList(user2, userId1);
        System.out.println("Friend connection removed between User " + userId1 + " and User " + userId2 + ".");
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        boolean found = false;
        FriendNode friend1 = user1.friendsHead;
        while (friend1 != null) {
            if (areFriends(user2, friend1.friendId)) {
                UserNode mutualFriend = findUser(friend1.friendId);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name + " (ID: " + mutualFriend.userId + ")");
                    found = true;
                }
            }
            friend1 = friend1.next;
        }
        if (!found) {
            System.out.println("No mutual friends found.");
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + " (" + user.friendCount + " friends):");
        if (user.friendsHead == null) {
            System.out.println("No friends yet.");
            return;
        }

        FriendNode current = user.friendsHead;
        while (current != null) {
            UserNode friend = findUser(current.friendId);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
            current = current.next;
        }
    }

    public void searchByUserId(int userId) {
        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
        } else {
            displayUser(user);
        }
    }

    public void searchByName(String name) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                if (!found) {
                    System.out.println("Users found:");
                    found = true;
                }
                displayUser(current);
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("User with name '" + name + "' not found.");
        }
    }

    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system.");
            return;
        }
        System.out.println("\n--- All Users ---");
        UserNode current = head;
        while (current != null) {
            displayUser(current);
            System.out.println();
            current = current.next;
        }
        System.out.println("Total users: " + userCount);
    }

    private UserNode findUser(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean areFriends(UserNode user, int friendId) {
        FriendNode current = user.friendsHead;
        while (current != null) {
            if (current.friendId == friendId) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendsHead;
        user.friendsHead = newFriend;
        user.friendCount++;
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        if (user.friendsHead == null) return;

        if (user.friendsHead.friendId == friendId) {
            user.friendsHead = user.friendsHead.next;
            user.friendCount--;
            return;
        }

        FriendNode current = user.friendsHead;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            user.friendCount--;
        }
    }

    private void displayUser(UserNode user) {
        System.out.println("User ID: " + user.userId);
        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
        System.out.println("Number of Friends: " + user.friendCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMediaFriendConnections network = new SocialMediaFriendConnections();

        int choice;
        do {
            System.out.println("\n--- Social Media Friend Connections ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends of User");
            System.out.println("6. Search by User ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    network.addUser(userId, name, age);
                    break;
                case 2:
                    System.out.print("Enter First User ID: ");
                    int id1 = scanner.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int id2 = scanner.nextInt();
                    network.addFriendConnection(id1, id2);
                    break;
                case 3:
                    System.out.print("Enter First User ID: ");
                    int remId1 = scanner.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int remId2 = scanner.nextInt();
                    network.removeFriendConnection(remId1, remId2);
                    break;
                case 4:
                    System.out.print("Enter First User ID: ");
                    int mutId1 = scanner.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int mutId2 = scanner.nextInt();
                    network.findMutualFriends(mutId1, mutId2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int dispId = scanner.nextInt();
                    network.displayFriends(dispId);
                    break;
                case 6:
                    System.out.print("Enter User ID to search: ");
                    int searchId = scanner.nextInt();
                    network.searchByUserId(searchId);
                    break;
                case 7:
                    System.out.print("Enter Name to search: ");
                    String searchName = scanner.nextLine();
                    network.searchByName(searchName);
                    break;
                case 8:
                    network.displayAllUsers();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
