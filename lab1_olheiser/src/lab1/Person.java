package lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Owner
 */
public class Person {
    // initialize instance variables
    private String lastName;
    private String firstName;
    private char middleInit;
    private String birthDate;
    
    // default constructor
    public Person() {
        lastName = "";
        firstName = "";
        middleInit = ' ';
        birthDate = "";
    }
    
    // Define custom constructor
    public Person(String lastName, String firstName, char middleInit, String birthDate) {
        // set the properties
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleInit(middleInit);
        setBirthDate(birthDate);
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
    
    public String getBirthDate() {
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
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    // Custom methods
    public String getFullName() {
        String fullName = getLastName() + ", " + getFirstName() + " " + getMiddleInit() + ".";
        return fullName;
    }
    
}
