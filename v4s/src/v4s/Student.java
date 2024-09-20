
package v4s;

import java.util.*;


class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    // Getters and Setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        // Implement method to add a student
        System.out.println("Adding student: " + fullName);
    }

    @Override
    public void updatePerson(String id) {
        // Implement method to update a student
        System.out.println("Updating student with ID: " + id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + id + ", Name: " + fullName + ", GPA: " + gpa + ", Major: " + major);
    }
}

