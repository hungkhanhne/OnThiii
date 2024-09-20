
package v2;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudentById(String id) {
        Student student = findStudentById(id);
        if (student != null) {
            studentList.remove(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudentById(String id, Student updatedStudent) {
        Student student = findStudentById(id);
        if (student != null) {
            int index = studentList.indexOf(student);
            studentList.set(index, updatedStudent);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("------------------");
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public double calculateTuitionOfAllStudents() {
        double total = 0;
        for (Student student : studentList) {
            total += student.getTuition();
        }
        return total;
    }
}

