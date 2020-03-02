package DataAccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity
//@Table(name = "employee")
public class Employee {
    //@Id
    //@GeneratedValue
    //@Column(name="id")
    private int id;

    public Employee( String firstName, String lastName, int salary) {

        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //@Column(name="salary")
    private int salary;
    //@Column(name="first_name")
    private String firstName;
    //@Column(name="last_name")
    private String lastName;
    public Employee(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }    
}