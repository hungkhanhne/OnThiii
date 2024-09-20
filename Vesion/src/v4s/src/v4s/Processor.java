
package v4s;


import v4s.Teacher;
import java.util.*;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter student GPA:");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Enter student major:");
                    String major = scanner.nextLine();
                    Student student = new Student(studentId, studentName, new Date(), gpa, major);
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
                    Teacher teacher = new Teacher(teacherId, teacherName, new Date(), department, subject);
                    personList.addTeacher(teacher);
                    break;
                case 3:
                    System.out.println("Enter person ID to update:");
                    String idToUpdate = scanner.nextLine();
                    personList.updatePerson(idToUpdate);
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
                        System.out.println("Top student is:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 7:
                    System.out.println("Enter department to find teachers:");
                    String dept = scanner.nextLine();
                    Teacher foundTeacher = personList.findTeacherByDepartment(dept);
                    if (foundTeacher != null) {
                        foundTeacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in department: " + dept);
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

