/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personprogram;

/**
 *
 * @author Owner
 */
public class Person {
    // initialize instance variables
    private String lastName;
    private String firstName;
    private char middleInit;
    private Date birthDate;
    
    // default constructor
    public Person() {};
    
    // Define custom constructor
    public Person(String lastName, String firstName, char middleInit, Date birthDate) {
        // set the properties
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleInit = middleInit;
        this.birthDate = birthDate;
    }
    
    // Getter methods
    public String getLastName() {
        return this.lastName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public char getMiddleInit() {
        return this.middleInit;
    }
    
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    // Setter methods
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setMiddleInit(char middleInit) {
        this.middleInit = middleInit;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    // Custom methods
    public String getFullName() {
        String fullName = getLastName() + ", " + getFirstName() + " " + getMiddleInit() + ".";
        return fullName;
    }
    
    public String toString() {
        return getFullName();
    }
    
    public String displayFormattedDate() {
        return String.format("%d/%d/%d", birthDate.getMonth(), birthDate.getDay(), birthDate.getYear());
    }
    
}