/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personprogram;

import java.util.Scanner;
import java.io.File; // to read the file
import java.io.FileNotFoundException; // to error check for file not found
import java.util.NoSuchElementException; // 
import static personprogram.PersonProgram.people;

// io = input/output

/**
 *
 * @author Owner
 */
public class EmployeeProgram {
    // initialize instance variables
    public static Scanner input; 
    public static Employee[] employees; 
    public Scanner fileReader; // scanner to read the file
    
    public EmployeeProgram() {
        // initialize the scanner
        input = new Scanner(System.in);
    }
    
    // Method to grab array data
    public void getData() {
        // Declare and populate a Person array
        employees = new Employee[5];
        
        employees[0] = new Employee("Smith", "John", 'T', new Date(9,30,1980), 
                100456, 3000, new Date(9,30,2018));
        employees[1] = new Employee("Olheiser", "Tanner", 'C', new Date(27,04,1993), 
                100691, 3200, new Date(27,04,2020));
        employees[2] = new Employee("Ketchum", "Ash", 'P', new Date(01,02,1994), 
                8991, 4000, new Date(3,2,2005));
        employees[3] = new Employee("Labowski", "Big", 'Y', new Date(03,04,1980), 
                10023, 3500, new Date(10,10, 2000));
        employees[4] = new Employee("Newman", "Paul", 'K', new Date(04,05,1989), 
                11009, 2800, new Date(1,1,2021));
    }
    
    // Overload method to get data from a file
    public void getData(String fileName) {
        // there's a possibility that the filename doesn't exist. so we'll 'try' to open it
        try {
            // fileReader refers to scanner
            fileReader = new Scanner(new File(fileName)); // pass fileName into the new File object
        // exception type followed by the name we're assigning to the exception 'fnfe' to reference later
        } catch (FileNotFoundException fnfe) { 
            System.out.println("File Not Found");
        } catch(Exception e) {
            System.out.println("An unknown error has occured");
        }
        
        try {
            // takes in the '7' in the text file.
            int size = fileReader.nextInt();
            people = new Person[size];
            
            int index = 0;
            
            // read line by line the text file
            while(fileReader.hasNext()) {
                people[index] = new Person(fileReader.next(), fileReader.next(), fileReader.next().charAt(0), 
                        new Date(fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt() ));
                // increment to get next person
                index++;
            }
        } catch (NoSuchElementException e) {
            // if the file is empty or we read passed the end of file
            System.out.println("File Format Error");
        } catch (IllegalStateException ise) {
            // if the file is deleted or clsoed before we have the chance to read from it
            System.out.println("Reading Error");
        }
    }
    
    public int showMenu() {
        int menuChoice;
        
        // Display the menu
        System.out.println("1. Display all employees");
        System.out.println("2. Display info for employee by list number");
        System.out.println("3. Display info for employee by employee number");
        System.out.println("4. Edit info for employee by employee number");
        System.out.println("5. Exit");
        System.out.print("Please select an option: ");
        
        // Using a do-while loop to ensure I get valid input.
        do {
            // Capture and store the input
            menuChoice = input.nextInt();
            
            // Display an error message if an unacceptable input is received.
            if (menuChoice < 1 || menuChoice > 5) {
                System.out.print("\nEntry must be between 1-5. Please try again: ");
            }
        } while (menuChoice < 1 || menuChoice > 5);
        
        return menuChoice;
    }
    
    public void executeChoices() {
        // use a switch statement to determine which menu option to execute
        System.out.println("\nMain Menu");
        switch(showMenu()) {
            case 1:
                menuOption1();
                break;
            case 2:
                menuOption2();
                break;
            case 3: 
                menuOption3();
                break;
            case 4: 
                menuOption4();
                break;
        }
    }
    
    public void menuOption1() {
        // loop over the employees array and display data
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].GetEmployeeNo() + " : " + employees[i].getFullName());
        }
    }
    
    public void menuOption2() {
        // initialize a variable to store the user's menu choice
        int userChoice;
        
        // Provide the user with a list of people for reference
        System.out.println("\nAll Records");
        menuOption1();
        
        // Prompt for data
        System.out.print("Please enter a number between 1 and " + employees.length + 
                    " corresponding to the person you wish to view: ");
        
        // Using a do-while loop to ensure I get valid input.
        do {
            // store user input
            userChoice = input.nextInt();
            
            // Prompt for another input if the first input was unacceptable
            if (userChoice < 1 || userChoice > employees.length) {
                System.out.print("Entry must be between 1 and " + employees.length + ". Please try again: ");
            }

        } while (userChoice < 1 || userChoice > employees.length);
        
        // display user info
        System.out.println("\nEmployee Data");
        System.out.println("Full Name: " + employees[userChoice - 1].getFullName());
        System.out.println("Birth Date: " + employees[userChoice - 1].getBirthDate());
        System.out.println("Employee Number: " + employees[userChoice - 1].GetEmployeeNo());
        System.out.printf("Monthly Salary: %.2f", employees[userChoice - 1].getMonthlySalary());
    }
    
    // Display info by Employee No.
    public void menuOption3() {
        int userInput; // Initialize a variable to store user input
        boolean employeeFound = false; // flag to track if an employee was found
        
        // Prompt for data
        System.out.print("Please enter an employee number: ");
        
        // Get user input
        userInput = input.nextInt();
        
        // Run a for loop to check if the employee number matches
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].GetEmployeeNo() == userInput) {
                // display employee info and break out of the loop
                System.out.println("\nEmployee Data");
                System.out.println("Full Name: " + employees[i].getFullName());
                System.out.println("Birth Date: " + employees[i].getBirthDate());
                System.out.println("Employee Number: " + employees[i].GetEmployeeNo());
                System.out.printf("Monthly Salary: %.2f", employees[i].getMonthlySalary());
                employeeFound = true;
                break;
            }
        }
        
        // If no employee was found, print a message to the screen.
        if (employeeFound == false) {
            System.out.println("record not found");
        }
        
    }
    
    // Edit info for employee by employee no.
    public void menuOption4() {
        // Set up variables
        int employeeChoice;
        int menuChoice;
        int employeeIndex = 0;
        boolean employeeFound = false; // flag to verify employee number
        
        // Provide the user with a list of people for reference
        System.out.println("\nAll Records");
        menuOption1();
        
        // Prompt for a user to edit
        System.out.print("\nPlease enter an employee number: ");
            
        // Use a do-while loop to ensure I get a proper input
        do {
            // capture the input
            employeeChoice = input.nextInt();
            
            // loop over the array and see if there is a match
            for (int i = 0; i < employees.length; i++) {
                // if there is, store the current index and toggle the flag
                if (employees[i].GetEmployeeNo() == employeeChoice) {
                    employeeIndex = i;
                    employeeFound = true;
                    break;
                }
            }
            
            // Display a message if an improper input was received
            if (employeeFound == false) {
                System.out.print("Record not found, please try again: ");
            }
        } while (employeeFound == false);
        
        // Display a submenu
        System.out.println("\nPlease select the data you want to edit: ");
        System.out.println("1. Employee Number");
        System.out.println("2. First Name");
        System.out.println("3. Last Name");
        System.out.println("4. Middle Initial");
        System.out.println("5. Monthly Salary");
        System.out.println("6. Birth Data");
        System.out.println("7. Hire Date");
        System.out.println("8. Exit\n");
        
        // Loop over the user input until they provide a satisfactory input
        do {
            // store the input
            menuChoice = input.nextInt();
            
            // display a message if the input was unacceptable
            if (menuChoice < 1 || menuChoice > 8) {
                System.out.print("Entry must be between 1 and 8. Please try again: ");
            }
        } while (menuChoice < 1 || menuChoice > 8);
        
        // Use a switch statement to edit data
        switch(menuChoice) {
            case 1:
                System.out.print("\nEnter the new employee number: ");
                employees[employeeIndex].setEmployeeNo(input.nextInt());
                break;
            case 2:
                System.out.print("\nEnter new first name: ");
                employees[employeeIndex].setFirstName(input.next());
                break;
            case 3:
                System.out.print("\n\nEnter new last name: ");
                employees[employeeIndex].setLastName(input.next());
                break;
            case 4: 
                System.out.print("\n\nEnter new middle initial: ");
                employees[employeeIndex].setMiddleInit(input.next().charAt(0));
                break;
            case 5: 
                System.out.print("\n\nEnter the new monthly salary: ");
                employees[employeeIndex].setMonthlySalary(input.nextFloat());
                break;
            case 6:
                // Declare some variables that I can pass into Date constructor
                int tempDay; int tempMonth; int tempYear;
                
                // Prompt and store date values
                System.out.print("\nEnter the birth day: ");
                tempDay = input.nextInt();
                System.out.print("\nEnter the birth month: ");
                tempMonth = input.nextInt();
                System.out.print("\nEnter the birth year: ");
                tempYear = input.nextInt();
                
                // Set a new birthDate
                employees[employeeIndex].setBirthDate(new Date(tempMonth, tempDay, tempYear));
                break;
            case 7:
                // Declare some variables that I can pass into Date constructor
                int tempD; int tempM; int tempY;
                
                // Prompt and store date values
                System.out.print("\nEnter the day: ");
                tempD = input.nextInt();
                System.out.print("\nEnter the month: ");
                tempM = input.nextInt();
                System.out.print("\nEnter the year: ");
                tempY = input.nextInt();
                
                // Set a new birthDate
                employees[employeeIndex].setBirthDate(new Date(tempM, tempD, tempY));
                break;
            case 8:
                break;
        }
        
        // Display the updated data if the user chose to edit data
        if (menuChoice > 0 && menuChoice < 8) {
            System.out.println("\nUpdated Data");
            System.out.println("Employee Number: " + employees[employeeIndex].GetEmployeeNo());
            System.out.println("Full Name: " + employees[employeeIndex].getFullName());
            System.out.printf("Monthly Salary: %.2f", employees[employeeIndex].getMonthlySalary());
            System.out.println("\nBirth Date: " + employees[employeeIndex].getBirthDate());
            System.out.println("Hire Date: " + employees[employeeIndex].getHireDate());
        } else {
            System.out.println("\nYou have exit the program.");
        }
    }
    
    public static void main(String[] args) {
        // Create an instance of the PersonProgram
        EmployeeProgram TheEmployee = new EmployeeProgram();
        // load the data then display the menu
        TheEmployee.getData();
        TheEmployee.executeChoices();
    }
    
}
