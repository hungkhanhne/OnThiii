package javainterface;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void updateStudentById(String id, Student newStudentData) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.set(i, newStudentData);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("--------------------");
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGPA() > topStudent.getGPA()) {
                topStudent = student;
            }
            System.out.println("Hoc sinh co diem gpa cao nhat");
            topStudent.displayInfo();
        }
        return topStudent;
    }
}