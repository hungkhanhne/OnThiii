package v3;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Processor {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        PersonList personList = new PersonList();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person by ID");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Find person by ID");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. EXIT");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student Full Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student Date of Birth (dd/MM/yyyy): ");
                    String studentDob = scanner.nextLine();
                    Date studentDateOfBirth = formatter.parse(studentDob);
                    System.out.print("Enter student GPA: ");
                    float studentGpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Enter student Major: ");
                    String studentMajor = scanner.nextLine();
                    personList.addStudent(new Student(studentId, studentName, studentDateOfBirth, studentGpa, studentMajor));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter teacher ID: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter teacher Full Name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter teacher Date of Birth (dd/MM/yyyy): ");
                    String teacherDob = scanner.nextLine();
                    Date teacherDateOfBirth = formatter.parse(teacherDob);
                    System.out.print("Enter teacher Department: ");
                    String teacherDepartment = scanner.nextLine();
                    System.out.print("Enter teacher Teaching Subject: ");
                    String teachingSubject = scanner.nextLine();
                    personList.addTeacher(new Teacher(teacherId, teacherName, teacherDateOfBirth, teacherDepartment, teachingSubject));
                    System.out.println("Teacher added successfully.");
                    break;

                case 3:
                    System.out.print("Enter ID of the person to update: ");
                    String updateId = scanner.nextLine();
                    Person personToUpdate = personList.findPersonById(updateId);
                    if (personToUpdate != null) {
                        System.out.print("Enter new Full Name: ");
                        String newFullName = scanner.nextLine();
                        System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
                        Date newDob = formatter.parse(scanner.nextLine());

                        if (personToUpdate instanceof Student) {
                            System.out.print("Enter new GPA: ");
                            float newGpa = scanner.nextFloat();
                            scanner.nextLine();
                            System.out.print("Enter new Major: ");
                            String newMajor = scanner.nextLine();
                            Student updatedStudent = new Student(updateId, newFullName, newDob, newGpa, newMajor);
                            personList.updatePerson(updateId, updatedStudent);
                        } else if (personToUpdate instanceof Teacher) {
                            System.out.print("Enter new Department: ");
                            String newDepartment = scanner.nextLine();
                            System.out.print("Enter new Teaching Subject: ");
                            String newTeachingSubject = scanner.nextLine();
                            Teacher updatedTeacher = new Teacher(updateId, newFullName, newDob, newDepartment, newTeachingSubject);
                            personList.updatePerson(updateId, updatedTeacher);
                        }
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID of the person to delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;

                case 5:
                    System.out.print("Enter ID to find person: ");
                    String findId = scanner.nextLine();
                    Person foundPerson = personList.findPersonById(findId);
                    if (foundPerson != null) {
                        foundPerson.displayInfo();
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case 6:
                    personList.displayEveryone();
                    break;

                case 7:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("The student with the highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 8:
                    System.out.print("Enter department to find teacher: ");
                    String department = scanner.nextLine();
                    Teacher foundTeacher = personList.findTeacherByDepartment(department);
                    if (foundTeacher != null) {
                        foundTeacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in this department.");
                    }
                    break;

                case 9:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
