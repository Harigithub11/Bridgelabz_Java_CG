package objectoriented.programmingfundamentals.level2;

import java.util.Scanner;

public class Student {
    private int rollNumber;
    private String name;
    private double[] marks;
    private int numberOfSubjects;

    public Student() {
    }

    public Student(int rollNumber, String name, int numberOfSubjects) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.numberOfSubjects = numberOfSubjects;
        this.marks = new double[numberOfSubjects];
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }

    public void setMark(int subjectIndex, double mark) {
        if (subjectIndex >= 0 && subjectIndex < numberOfSubjects) {
            marks[subjectIndex] = mark;
        }
    }

    public double calculateTotalMarks() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculatePercentage() {
        double maxMarks = numberOfSubjects * 100;
        return (calculateTotalMarks() / maxMarks) * 100;
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayReport() {
        System.out.println("\n--- Student Report Card ---");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("  Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + calculateTotalMarks() + "/" + (numberOfSubjects * 100));
        System.out.printf("Percentage: %.2f%%\n", calculatePercentage());
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int numberOfSubjects = scanner.nextInt();

        Student student = new Student(rollNumber, name, numberOfSubjects);

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            double mark = scanner.nextDouble();
            student.setMark(i, mark);
        }

        student.displayReport();

        scanner.close();
    }
}
