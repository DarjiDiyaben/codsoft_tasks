import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("==================================");

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        if (numberOfSubjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            scanner.close();
            return;
        }

        double totalMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {

            double marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (out of 100): ");
                marks = scanner.nextDouble();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }
            }

            totalMarks += marks;
        }

        double averagePercentage = totalMarks / numberOfSubjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else if (averagePercentage >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.println("\n==================================");
        System.out.println("           RESULT");
        System.out.println("==================================");

        System.out.println("Total Marks     : " + totalMarks);
        System.out.printf("Average         : %.2f%%%n", averagePercentage);
        System.out.println("Grade           : " + grade);

        // Display pass/fail status
        if (averagePercentage >= 40) {
            System.out.println("Result          : PASS");
        } else {
            System.out.println("Result          : FAIL");
        }

        scanner.close();
    }
}

