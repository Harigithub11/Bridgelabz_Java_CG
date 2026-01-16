package datastructures.linkedlist.doublylinkedlist;

import java.util.Scanner;

public class TextEditorUndoRedo {

    private static final int MAX_HISTORY_SIZE = 10;
    private StateNode current;
    private StateNode head;
    private int size;

    private static class StateNode {
        String textContent;
        StateNode next;
        StateNode prev;

        StateNode(String textContent) {
            this.textContent = textContent;
            this.next = null;
            this.prev = null;
        }
    }

    public TextEditorUndoRedo() {
        StateNode initialState = new StateNode("");
        this.head = initialState;
        this.current = initialState;
        this.size = 1;
    }

    public void addState(String newContent) {
        StateNode newState = new StateNode(newContent);

        if (current.next != null) {
            current.next = null;
            trimSize();
        }

        newState.prev = current;
        current.next = newState;
        current = newState;
        size++;

        if (size > MAX_HISTORY_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text state saved.");
    }

    public void undo() {
        if (current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed.");
    }

    public void redo() {
        if (current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed.");
    }

    public void displayCurrentState() {
        System.out.println("\n--- Current Text State ---");
        if (current.textContent.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            System.out.println(current.textContent);
        }
    }

    public void displayHistory() {
        System.out.println("\n--- Text History ---");
        StateNode temp = head;
        int index = 1;
        while (temp != null) {
            String marker = (temp == current) ? " <-- Current" : "";
            String content = temp.textContent.isEmpty() ? "[Empty]" :
                            (temp.textContent.length() > 50 ? temp.textContent.substring(0, 50) + "..." : temp.textContent);
            System.out.println(index + ". " + content + marker);
            temp = temp.next;
            index++;
        }
        System.out.println("\nHistory size: " + size + "/" + MAX_HISTORY_SIZE);
    }

    public String getCurrentText() {
        return current.textContent;
    }

    private void trimSize() {
        StateNode temp = current;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.prev;
        }
        size = count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        int choice;
        do {
            System.out.println("\n--- Text Editor with Undo/Redo ---");
            System.out.println("1. Type/Edit Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Display History");
            System.out.println("6. Append Text");
            System.out.println("7. Clear Text");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Current text: " +
                        (editor.getCurrentText().isEmpty() ? "[Empty]" : editor.getCurrentText()));
                    System.out.print("Enter new text: ");
                    String newText = scanner.nextLine();
                    editor.addState(newText);
                    break;
                case 2:
                    editor.undo();
                    editor.displayCurrentState();
                    break;
                case 3:
                    editor.redo();
                    editor.displayCurrentState();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    editor.displayHistory();
                    break;
                case 6:
                    System.out.print("Enter text to append: ");
                    String appendText = scanner.nextLine();
                    editor.addState(editor.getCurrentText() + appendText);
                    editor.displayCurrentState();
                    break;
                case 7:
                    editor.addState("");
                    System.out.println("Text cleared.");
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
