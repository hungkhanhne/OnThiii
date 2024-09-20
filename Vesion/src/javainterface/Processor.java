package javainterface;

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

            System.out.println("Chon:");
            System.out.println("1. Them hoc sinh moi");
            System.out.println("2. Cap nhat hoc sinh theo ID");
            System.out.println("3. Xoa hoc sinh theo ID");
            System.out.println("4. Hien thi tat ca hoc sinh");
            System.out.println("5. Tim hoc sinh co diem GPA cao nhat");
            System.out.println("6. THOAT");
            System.out.println(" ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

                case 1:

                    System.out.print("Nhap ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhap Full Name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Nhap Date of Birth (dd/MM/yyyy): ");
                    String dob = scanner.nextLine();
                    Date dateOfBirth = formatter.parse(dob);

                    System.out.print("Nhap GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Nhap Major: ");
                    String major = scanner.nextLine();
                    studentList.addStudent(new Student(id, fullName, dateOfBirth, gpa, major));
                    System.out.println(" ------------------");
                    break;

                case 2: 
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    Student studentToUpdate = studentList.findStudentById(updateId);
                    if (studentToUpdate != null) {
                        System.out.print("Enter new full name: ");
                        String updatedFullName = scanner.nextLine();
                        System.out.print("Enter new date of birth (dd/MM/yyyy): ");
                        String updatedDobString = scanner.nextLine();
                        Date updatedDob = formatter.parse(updatedDobString); 
                        
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
                    System.out.print("Nhap ID cua hoc sinh can xoa: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    System.out.println("XOA THANH CONG.");
                    System.out.println(" --");
                    break;

                case 4:
                    studentList.displayAllStudents();
                    break;
                          
                case 5: 
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Hoc sinh co diem GPA cao nhat:");
                        topStudent.displayInfo(); 
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 6:
                    exit = true; 
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
      
    }
}
