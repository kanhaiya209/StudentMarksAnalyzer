import java.util.*;

public class StudentMarksAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Input Size (with validation)
        int Size = 0;
        while (true) {
            try {
                System.out.print("Enter How many Students are: ");
                Size = sc.nextInt();
                if (Size <= 0) {
                    System.out.println("Size must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Number! Please enter a valid integer.");
                sc.nextLine(); // clear wrong input
            }
        }

        sc.nextLine(); // clear buffer

        // 2. Input Student Names
        String[] students = new String[Size];
        System.out.println("Enter The Students Names:");
        for (int i = 0; i < Size; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            students[i] = sc.nextLine();
        }

        // 3. Input Marks (with validation)
        int[] marks = new int[Size];
        int sum = 0;

        System.out.println("Enter The Students Marks:");
        for (int i = 0; i < Size; i++) {
            while (true) {
                try {
                    System.out.print("Marks of " + students[i] + ": ");
                    marks[i] = sc.nextInt();

                    if (marks[i] < 0 || marks[i] > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        continue;
                    }

                    sum += marks[i];
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Marks! Enter a valid number.");
                    sc.nextLine(); // clear invalid input
                }
            }
        }

        // 4. Processing (Min, Max, Average) WITHOUT breaking mapping
        int min = marks[0];
        int max = marks[0];

        for (int i = 1; i < Size; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
            if (marks[i] > max) {
                max = marks[i];
            }
        }

        double avg = (double) sum / Size;

        // 5. Output Statistics
        System.out.println("\n----- CLASS ANALYSIS -----");
        System.out.println("Highest Marks Obtained: " + max);
        System.out.println("Minimum Marks Obtained: " + min);
        System.out.println("Average Marks of the Students: " + avg);

        // 6. Grade Calculation (Correct Mapping: student ↔ marks)
        System.out.println("\n----- STUDENT GRADES -----");
        for (int i = 0; i < Size; i++) {
            if (marks[i] >= 90) {
                System.out.println(students[i] + " got Grade A");
            } else if (marks[i] >= 80) {
                System.out.println(students[i] + " got Grade B");
            } else if (marks[i] >= 70) {
                System.out.println(students[i] + " got Grade C");
            } else if (marks[i] >= 60) {
                System.out.println(students[i] + " got Grade D");
            } else {
                System.out.println(students[i] + " got Fail");
            }
        }

        sc.close();
    }
}
