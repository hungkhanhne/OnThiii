
package v2;

import java.util.Date;


public abstract class Person implements IPerson {
    String id;
    String fullName;
    Date dayOfBith;
    
    public Person(String id, String fullName,Date dayOfBith){
       this.id=id;
       this.fullName=fullName;
       this.dayOfBith=dayOfBith;
       
 }
    public Person() {
        
    }   
    @Override
    public abstract void displayInfo();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDayOfBirth() {
        return dayOfBith;
    }

    public void setDayOfBith(Date dayOfBith) {
        this.dayOfBith = dayOfBith;
    }
    
}

