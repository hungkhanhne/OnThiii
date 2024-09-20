package v2;


import java.util.Date;

public class Student extends Person {
    private float gpa;
    private String major;
    private double tuition = 10000000;
    private boolean scholarship;

    public Student(String id, String fullName, Date dateOfBith, float gpa, String major) {
        super(id, fullName, dateOfBith);
        this.gpa = gpa;
        this.major = major;
        calculateScholarship();
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        calculateScholarship(); 
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    private void calculateScholarship() {
        if (gpa >= 9) {
            this.scholarship = true;
            this.tuition = 10000000 * 0.5; 
        } else {
            this.scholarship = false;
            this.tuition = 10000000; 
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + dayOfBith);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Scholarship: " + scholarship);
        System.out.println("Tuition Fee: " + tuition);
    }
}
