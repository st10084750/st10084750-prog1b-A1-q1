package prog1b_studentapp;

import java.util.Scanner;

public class Prog1b_studentapp {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Student Management Application");
        System.out.println("******************************");
        System.out.println("Enter (1) to launch menu or any other key to exit the application");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            displayMenu();
        } else {
            System.out.println("Exiting the application.");
        }
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print student report");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: \n");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("\nExiting the application.");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void captureStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("\nMaximum number of students reached.");
            return;
        }

        System.out.print("\nEnter student ID: ");
        String studentID = scanner.nextLine();

        // Check if the student already exists
        if (findStudent(studentID) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Enter student age (must be 16 or above): ");
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age < 16);

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        Student student = new Student(studentID, name, age, email, course);
        students[studentCount] = student;
        studentCount++;
        System.out.println("Student details successfully saved.");
    }

    private static void searchStudent() {
        System.out.print("\nEnter student ID to search: ");
        String studentID = scanner.nextLine();

        Student student = findStudent(studentID);
        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent not found.");
        }
    }

    private static Student findStudent(String studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equals(studentID)) {
                return students[i];
            }
        }
        return null;
    }

    private static void deleteStudent() {
        System.out.print("\nEnter student ID to delete: ");
        String studentID = scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID().equals(studentID)) {
                students[i].displayDetails();
                System.out.print("\nDo you want to delete this student? (y/n): ");
                String confirm = scanner.nextLine().trim().toLowerCase();

                if (confirm.equals("y")) {
                   
                    for (int j = i; j < studentCount - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    students[studentCount - 1] = null;
                    studentCount--;
                    System.out.println("\nStudent successfully deleted.");
                    return;
                }
            }
        }
        System.out.println("\nStudent not found.");
    }

    private static void printStudentReport() {
        System.out.print("\nEnter student ID to print report: ");
        String studentID = scanner.nextLine();

        Student student = findStudent(studentID);
        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("S\ntudent not found.");
        }
    }
}

