
package v3;

import java.util.Date;


public class Teacher extends Person {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, Date dayOfBirth, String department, String teachingSubject) {
        super(id, fullName, dayOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public Teacher(String department, String teachingSubject, String tDoB, String department1, String subject) {
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: "+ id );
        System.out.println("fullname:"+fullName);
        System.out.println("Date:"+dayOfBith);
        System.out.println("Department: "+department);
        System.out.println("Subject: "+ teachingSubject);
    }

}
