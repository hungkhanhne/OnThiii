
package v5;

import java.util.Scanner;
import java.util.Date;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by ID");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find student with highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Check book borrowing status");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter GPA:");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();  
                    System.out.println("Enter major:");
                    String major = scanner.nextLine();
                    Date borrowDate = new Date();
                    Date returnDate = new Date(borrowDate.getTime() + (31L * 24 * 60 * 60 * 1000)); 
                    Student student = new Student(studentId, studentName, new Date(), borrowDate, returnDate, gpa, major);
                    personList.addStudent(student);
                    break;

                case 2:
                    System.out.println("Enter teacher ID:");
                    String teacherId = scanner.nextLine();
                    System.out.println("Enter teacher name:");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter department:");
                    String department = scanner.nextLine();
                    System.out.println("Enter teaching subject:");
                    String subject = scanner.nextLine();
                    Teacher teacher = new Teacher(teacherId, teacherName, new Date(), new Date(), new Date(), department, subject);
                    personList.addTeacher(teacher);
                    break;

                case 3:
                    System.out.println("Enter person ID to update:");
                    String idToUpdate = scanner.nextLine();
                    Person personToUpdate = personList.findPersonById(idToUpdate);
                    if (personToUpdate != null) {
                 
                        System.out.println("Person found: " + personToUpdate.getFullName());
                    } else {
                        System.out.println("Person not found with ID: " + idToUpdate);
                    }
                    break;

                case 4:
                    System.out.println("Enter person ID to delete:");
                    String idToDelete = scanner.nextLine();
                    personList.deletePersonById(idToDelete);
                    break;

                case 5:
                    personList.displayEveryone();
                    break;

                case 6:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 7:
                    System.out.println("Enter department:");
                    String dep = scanner.nextLine();
                    Teacher teacherByDep = personList.findTeacherByDepartment(dep);
                    if (teacherByDep != null) {
                        teacherByDep.displayInfo();
                    } else {
                        System.out.println("No teacher found in department: " + dep);
                    }
                    break;

                case 8:
                    personList.checkBookBorrowing();
                    break;

                case 9:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

