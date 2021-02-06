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
public class Employee extends Person {
    // extends is the keyword you use to say "this class is derived from class Person
    private int employeeNo;
    private float monthlySalary;
    private Date hireDate;
    
    public Employee() {
        
    }
    
    public Employee(String firstName, String lastName, char middleInit, 
            Date birthDate, int employeeNo, float monthlySalary, Date hireDate) {
        // super targets the class that comes after the extends keyword
        super(firstName, lastName, middleInit, birthDate);
        setEmployeeNo(employeeNo);
        setMonthlySalary(monthlySalary);
        setHireDate(hireDate);
    }
    
    public int GetEmployeeNo() {
        return employeeNo;
    }
    
    public float getMonthlySalary() {
        return monthlySalary;
    }
    
    public Date getHireDate() {
        return hireDate;
    }
    
    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
    
    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    public String toString() {
        String result =     "Employee No.: " + employeeNo + 
                            "\nName: " + getFullName() + 
                            "\nBirth Date: " + getBirthDate().toString() + 
                            "\nMonthly Salary: $" + monthlySalary + 
                            "\nHire Date: " + getHireDate().toString();
        return result;
    }
    
}
