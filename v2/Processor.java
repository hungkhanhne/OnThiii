
package v2;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Processor {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find student with highest GPA");
            System.out.println("6. Calculate total tuition of all students");
            System.out.println("7. EXIT");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String dob = scanner.nextLine();
                    Date dateOfBirth = formatter.parse(dob);
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    studentList.addStudent(new Student(id, fullName, dateOfBirth, gpa, major));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    String updateId = scanner.nextLine();
                    Student studentToUpdate = studentList.findStudentById(updateId);
                    if (studentToUpdate != null) {
                        System.out.print("Enter new full name: ");
                        String updatedFullName = scanner.nextLine();
                        System.out.print("Enter new date of birth (dd/MM/yyyy): ");
                        Date updatedDob = formatter.parse(scanner.nextLine());
                        System.out.print("Enter new GPA: ");
                        float updatedGpa = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Enter new major: ");
                        String updatedMajor = scanner.nextLine();
                        Student updatedStudent = new Student(updateId, updatedFullName, updatedDob, updatedGpa, updatedMajor);
                        studentList.updateStudentById(updateId, updatedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of the student to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 6:
                    double totalTuition = studentList.calculateTuitionOfAllStudents();
                    System.out.println("Total tuition of all students: " + totalTuition);
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
