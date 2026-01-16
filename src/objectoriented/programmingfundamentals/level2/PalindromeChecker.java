package objectoriented.programmingfundamentals.level2;

import java.util.Scanner;

public class PalindromeChecker {
    private int number;

    public PalindromeChecker() {
    }

    public PalindromeChecker(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int reverseNumber() {
        int temp = Math.abs(number);
        int reversed = 0;
        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return reversed;
    }

    public boolean isPalindrome() {
        if (number < 0) {
            return false;
        }
        return number == reverseNumber();
    }

    public void displayResult() {
        System.out.println("Number: " + number);
        System.out.println("Reversed: " + reverseNumber());
        if (isPalindrome()) {
            System.out.println(number + " is a Palindrome.");
        } else {
            System.out.println(number + " is NOT a Palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it's a palindrome: ");
        int number = scanner.nextInt();

        PalindromeChecker checker = new PalindromeChecker(number);
        checker.displayResult();

        scanner.close();
    }
}
