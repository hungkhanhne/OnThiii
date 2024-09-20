
package v5;

import java.util.Date;

class Student extends Person {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, float gpa, String major) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.gpa = gpa;
        this.major = major;
    }

    // Getters và Setters
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
       
    }

    @Override
    public void updatePerson(String id) {
       
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + id + ", Name: " + fullName + ", GPA: " + gpa + ", Major: " + major);
        if (isBookOverdue()) {
            System.out.println("Book Status: Overdue");
        } else {
            System.out.println("Book Status: No overdue");
        }
    }
}

