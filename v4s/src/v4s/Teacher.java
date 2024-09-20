package v4s;

import java.util.Date;

class Teacher extends Person {
    private String department;
    private String teachingSubject;
    public Teacher(String id, String fullName, Date dateOfBirth, String department, String teachingSubject) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getTeachingSubject() {
        return teachingSubject;
    }
    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }
    @Override
    public void addPerson() {
        System.out.println("Adding teacher: " + fullName);
    }
    @Override
    public void updatePerson(String id) {
        System.out.println("Updating teacher with ID: " + id);
    }
    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + id + ", Name: " + fullName + ", Department: " + department + ", Subject: " + teachingSubject);
    }
}