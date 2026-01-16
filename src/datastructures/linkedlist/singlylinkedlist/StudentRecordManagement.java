package datastructures.linkedlist.singlylinkedlist;

import java.util.Scanner;

public class StudentRecordManagement {

    private StudentNode head;
    private int size;

    private static class StudentNode {
        int rollNumber;
        String name;
        int age;
        String grade;
        StudentNode next;

        StudentNode(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    public StudentRecordManagement() {
        this.head = null;
        this.size = 0;
    }

    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Student added at beginning.");
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Student added at end.");
    }

    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Student added at position " + position + ".");
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            size--;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println("Student with Roll Number " + rollNumber + " deleted.");
        }
    }

    public void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        int position = 1;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student found at position " + position + ":");
                displayStudent(current);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        StudentNode current = head;
        int position = 1;
        while (current != null) {
            System.out.println("\nPosition " + position + ":");
            displayStudent(current);
            current = current.next;
            position++;
        }
        System.out.println("\nTotal students: " + size);
    }

    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    private void displayStudent(StudentNode node) {
        System.out.println("Roll Number: " + node.rollNumber);
        System.out.println("Name: " + node.name);
        System.out.println("Age: " + node.age);
        System.out.println("Grade: " + node.grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRecordManagement list = new StudentRecordManagement();

        int choice;
        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Display All");
            System.out.println("7. Update Grade");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll Number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    if (choice == 1) {
                        list.addAtBeginning(roll, name, age, grade);
                    } else if (choice == 2) {
                        list.addAtEnd(roll, name, age, grade);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = scanner.nextInt();
                        list.addAtPosition(roll, name, age, grade, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int delRoll = scanner.nextInt();
                    list.deleteByRollNumber(delRoll);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = scanner.nextInt();
                    list.searchByRollNumber(searchRoll);
                    break;
                case 6:
                    list.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Roll Number: ");
                    int updateRoll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Grade: ");
                    String newGrade = scanner.nextLine();
                    list.updateGrade(updateRoll, newGrade);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
