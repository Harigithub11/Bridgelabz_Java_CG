package datastructures.linkedlist.circularlinkedlist;

import java.util.Scanner;

public class TaskScheduler {

    private TaskNode head;
    private TaskNode current;
    private int size;

    private static class TaskNode {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        TaskNode next;

        TaskNode(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    public TaskScheduler() {
        this.head = null;
        this.current = null;
        this.size = 0;
    }

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            TaskNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Task added at beginning.");
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            TaskNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
        size++;
        System.out.println("Task added at end.");
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        if (position == size + 1) {
            addAtEnd(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        System.out.println("Task added at position " + position + ".");
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        if (head.taskId == taskId && size == 1) {
            head = null;
            current = null;
            size = 0;
            System.out.println("Task " + taskId + " removed.");
            return;
        }
        if (head.taskId == taskId) {
            TaskNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            if (current == head) {
                current = head.next;
            }
            head = head.next;
            tail.next = head;
            size--;
            System.out.println("Task " + taskId + " removed.");
            return;
        }
        TaskNode temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Task " + taskId + " not found.");
            return;
        }
        if (current == temp.next) {
            current = temp.next.next;
        }
        temp.next = temp.next.next;
        size--;
        System.out.println("Task " + taskId + " removed.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No current task.");
            return;
        }
        System.out.println("\n--- Current Task ---");
        displayTask(current);
    }

    public void moveToNextTask() {
        if (current == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        current = current.next;
        System.out.println("Moved to next task.");
        viewCurrentTask();
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        System.out.println("\n--- All Tasks ---");
        TaskNode temp = head;
        int position = 1;
        do {
            String marker = (temp == current) ? " <-- Current" : "";
            System.out.println("\nPosition " + position + ":" + marker);
            displayTask(temp);
            temp = temp.next;
            position++;
        } while (temp != head);
        System.out.println("\nTotal tasks: " + size);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        System.out.println("Tasks with priority " + priority + ":");
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                if (!found) found = true;
                displayTask(temp);
                System.out.println();
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }

    private void displayTask(TaskNode node) {
        System.out.println("Task ID: " + node.taskId);
        System.out.println("Task Name: " + node.taskName);
        System.out.println("Priority: " + node.priority);
        System.out.println("Due Date: " + node.dueDate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        int choice;
        do {
            System.out.println("\n--- Task Scheduler (Circular Linked List) ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Task ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Due Date: ");
                    String dueDate = scanner.nextLine();
                    if (choice == 1) {
                        scheduler.addAtBeginning(taskId, taskName, priority, dueDate);
                    } else if (choice == 2) {
                        scheduler.addAtEnd(taskId, taskName, priority, dueDate);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = scanner.nextInt();
                        scheduler.addAtPosition(taskId, taskName, priority, dueDate, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int removeId = scanner.nextInt();
                    scheduler.removeByTaskId(removeId);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority to search: ");
                    int searchPriority = scanner.nextInt();
                    scheduler.searchByPriority(searchPriority);
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
