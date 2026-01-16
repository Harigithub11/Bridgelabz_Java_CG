package datastructures.linkedlist.circularlinkedlist;

import java.util.Scanner;

public class RoundRobinScheduler {

    private ProcessNode head;
    private int size;
    private int timeQuantum;

    private static class ProcessNode {
        int processId;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime;
        int turnaroundTime;
        ProcessNode next;

        ProcessNode(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
            this.next = null;
        }
    }

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.size = 0;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            ProcessNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
        size++;
        System.out.println("Process " + processId + " added to scheduler.");
    }

    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in scheduler.");
            return;
        }
        if (head.processId == processId && size == 1) {
            head = null;
            size = 0;
            System.out.println("Process " + processId + " removed.");
            return;
        }
        if (head.processId == processId) {
            ProcessNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
            size--;
            System.out.println("Process " + processId + " removed.");
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head && temp.next.processId != processId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Process " + processId + " not found.");
            return;
        }
        temp.next = temp.next.next;
        size--;
        System.out.println("Process " + processId + " removed.");
    }

    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = size;
        int[] originalBurstTimes = new int[totalProcesses];
        int[] processIds = new int[totalProcesses];
        int[] completionTimes = new int[totalProcesses];

        ProcessNode temp = head;
        for (int i = 0; i < totalProcesses; i++) {
            originalBurstTimes[i] = temp.burstTime;
            processIds[i] = temp.processId;
            temp = temp.next;
        }

        int currentTime = 0;
        int completed = 0;
        int round = 1;

        System.out.println("\n--- Round Robin Simulation (Time Quantum: " + timeQuantum + ") ---");

        while (completed < totalProcesses) {
            System.out.println("\n=== Round " + round + " ===");
            ProcessNode current = head;
            ProcessNode prev = null;

            temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            prev = temp;

            boolean anyExecuted = false;
            int processesInRound = size;

            for (int i = 0; i < processesInRound && size > 0; i++) {
                if (current.remainingTime > 0) {
                    anyExecuted = true;
                    int executionTime = Math.min(timeQuantum, current.remainingTime);
                    current.remainingTime -= executionTime;
                    currentTime += executionTime;

                    System.out.println("Process " + current.processId +
                                       " executed for " + executionTime + "ms. " +
                                       "Remaining: " + current.remainingTime + "ms");

                    if (current.remainingTime == 0) {
                        for (int j = 0; j < totalProcesses; j++) {
                            if (processIds[j] == current.processId) {
                                completionTimes[j] = currentTime;
                                break;
                            }
                        }
                        System.out.println("Process " + current.processId + " completed at time " + currentTime);
                        completed++;

                        if (size == 1) {
                            head = null;
                            size = 0;
                            break;
                        } else if (current == head) {
                            head = head.next;
                            prev.next = head;
                            current = head;
                            size--;
                            continue;
                        } else {
                            prev.next = current.next;
                            current = current.next;
                            size--;
                            continue;
                        }
                    }
                }
                prev = current;
                current = current.next;
            }

            if (!anyExecuted) break;
            round++;
        }

        System.out.println("\n--- Scheduling Results ---");
        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        System.out.printf("%-10s %-12s %-15s %-15s %-12s%n",
                          "Process", "Burst Time", "Completion", "Turnaround", "Waiting");

        for (int i = 0; i < totalProcesses; i++) {
            int turnaround = completionTimes[i];
            int waiting = turnaround - originalBurstTimes[i];
            totalTurnaroundTime += turnaround;
            totalWaitingTime += waiting;

            System.out.printf("P%-9d %-12d %-15d %-15d %-12d%n",
                              processIds[i], originalBurstTimes[i],
                              completionTimes[i], turnaround, waiting);
        }

        System.out.printf("%nAverage Waiting Time: %.2f ms%n", totalWaitingTime / totalProcesses);
        System.out.printf("Average Turnaround Time: %.2f ms%n", totalTurnaroundTime / totalProcesses);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in scheduler.");
            return;
        }
        System.out.println("\n--- Process Queue ---");
        ProcessNode temp = head;
        int position = 1;
        do {
            System.out.println("\nPosition " + position + ":");
            System.out.println("Process ID: " + temp.processId);
            System.out.println("Burst Time: " + temp.burstTime + "ms");
            System.out.println("Remaining Time: " + temp.remainingTime + "ms");
            System.out.println("Priority: " + temp.priority);
            temp = temp.next;
            position++;
        } while (temp != head);
        System.out.println("\nTotal processes: " + size);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Time Quantum (ms): ");
        int timeQuantum = scanner.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        int choice;
        do {
            System.out.println("\n--- Round Robin CPU Scheduler ---");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Display Processes");
            System.out.println("4. Simulate Scheduling");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processId = scanner.nextInt();
                    System.out.print("Enter Burst Time (ms): ");
                    int burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = scanner.nextInt();
                    scheduler.addProcess(processId, burstTime, priority);
                    break;
                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    int removeId = scanner.nextInt();
                    scheduler.removeProcess(removeId);
                    break;
                case 3:
                    scheduler.displayProcesses();
                    break;
                case 4:
                    scheduler.simulateScheduling();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
