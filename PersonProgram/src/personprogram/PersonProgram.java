/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personprogram;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class PersonProgram {
    // initialize instance variables
    public static Scanner input; 
    public static Person[] people; 
    
    public PersonProgram() {
        // initialize the scanner
        input = new Scanner(System.in);
    }
    
    public void getData() {
        // Declare and populate a Person array
        people = new Person[5];
        people[0] = new Person("Smith", "John", 'T', new Date(9,30,1980));
        people[1] = new Person("Olheiser", "Tanner", 'C', new Date(27,04,1993));
        people[2] = new Person("Ketchum", "Ash", 'P', new Date(01,02,1994));
        people[3] = new Person("Labowski", "Big", 'Y', new Date(03,04,1980));
        people[4] = new Person("Newman", "Paul", 'K', new Date(04,05,1989));
    }
    
    public int showMenu() {
        int menuChoice;
        
        // Display the menu
        System.out.println("1. Display all names");
        System.out.println("2. Display all info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
        
        // Using a do-while loop to ensure I get valid input.
        do {
            // Capture and store the input
            menuChoice = input.nextInt();
            
            // Display an error message if an unacceptable input is received.
            if (menuChoice < 1 || menuChoice > 4) {
                System.out.print("\nEntry must be between 1-4. Please try again: ");
            }
        } while (menuChoice < 1 || menuChoice > 4);
        
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
        }
    }
    
    public void menuOption1() {
        // loop over the arrays and display data
        System.out.println("");
        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + ". " + people[i].getFullName());
        }
    }
    
    public void menuOption2() {
        // initialize a variable to store the user's menu choice
        int userChoice;
        
        // Provide the user with a list of people for reference
        System.out.println("\nAll Records");
        menuOption1();
        
        // Prompt for data
        System.out.print("Please enter a number between 1 and " + people.length + 
                    " corresponding to the person you wish to view: ");
        
        // Using a do-while loop to ensure I get valid input.
        do {
            // store user input
            userChoice = input.nextInt();
            
            // Prompt for another input if the first input was unacceptable
            if (userChoice < 1 || userChoice > people.length) {
                System.out.print("Entry must be between 1 and " + people.length + ". Please try again: ");
            }

        } while (userChoice < 1 || userChoice > people.length);
        
        // display user info
        System.out.println("\nPerson Data");
        System.out.println("Full Name: " + people[userChoice].getFullName());
        System.out.println("Birth Date: " + people[userChoice].getBirthDate());
    }
    
    public void menuOption3() {
        // Set up variables
        int personChoice;
        int menuChoice;
        
        // Provide the user with a list of people for reference
        System.out.println("\nAll Records");
        menuOption1();
        
        // Prompt for a user to edit
            System.out.print("\nPlease enter a number between 1 and " + people.length 
                    + " corresponding to the person you wish to edit: ");
            
        // Use a do-while loop to ensure I get a proper input
        do {
            personChoice = input.nextInt() - 1;
            
            // Display a message if an improper input was received
            if (personChoice < 0 || personChoice > people.length - 1) {
                System.out.print("Entry must be between 1 and " + people.length + ". Please try again: ");
            }
        } while (personChoice < 0 || personChoice > people.length - 1);
        
        // Display a submenu
        System.out.print("\nPlease select the data you want to edit: ");
        System.out.println("\n1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Middle Initial");
        System.out.println("4. Birth Date");
        System.out.println("5. Cancel");
        
        // Loop over the user input until they provide a satisfactory input
        do {
            // store the input
            menuChoice = input.nextInt();
            
            // display a message if the input was unacceptable
            if (menuChoice < 1 || menuChoice > 5) {
                System.out.print("Entry must be between 1 and 5. Please try again: ");
            }
        } while (menuChoice < 1 || menuChoice > 5);
        
        // Use a switch statement to edit data
        switch(menuChoice) {
            case 1:
                System.out.print("\nEnter new first name: ");
                people[personChoice].setFirstName(input.next());
                break;
            case 2:
                System.out.print("\n\nEnter new last name: ");
                people[personChoice].setLastName(input.next());
                break;
            case 3: 
                System.out.print("\n\nEnter new middle initial: ");
                people[personChoice].setMiddleInit(input.next().charAt(0));
                break;
            case 4:
                // Declare some variables that I can pass into Date constructor
                int tempDay; int tempMonth; int tempYear;
                
                // Prompt and store date values
                System.out.print("\nEnter new birth day: ");
                tempDay = input.nextInt();
                System.out.print("\nEnter new birth month: ");
                tempMonth = input.nextInt();
                System.out.print("\nEnter new birth year: ");
                tempYear = input.nextInt();
                
                // Set a new birthDate
                people[personChoice].setBirthDate(new Date(tempMonth, tempDay, tempYear));
                break;
            case 5:
                break;
        }
        
        // Display the updated data if the user chose to edit data
        if (menuChoice < 5) {
            System.out.println("\nUpdated Data");
            System.out.println("Full Name: " + people[personChoice].getFullName());
            System.out.println("Birth Date: " + people[personChoice].getBirthDate());
        } else {
            System.out.println("\nYou have exit the program.");
        }
    }
    
    public static void main(String[] args) {
        // Create an instance of the PersonProgram
        PersonProgram ThePerson = new PersonProgram();
        // load the data then display the menu
        ThePerson.getData();
        ThePerson.executeChoices();
    }
    
}
