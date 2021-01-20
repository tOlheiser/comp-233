package lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner; // import scanner
/**
 *
 * @author Owner
 */
public class PersonProgram {
    public static Scanner input;// = new Scanner(System.in);
    public static Person[] people; 
    
    public void PersonProgram() {
        // initialize the scanner
        input = new Scanner(System.in); 
    }
    
    public void getData() {
        // Declare and populate a Person array
        people = new Person[5];
        people[0] = new Person("Smith", "John", 'T', "08/09/12");
        people[1] = new Person("Olheiser", "Tanner", 'C', "27/04/93");
        people[2] = new Person("Ketchum", "Ash", 'P', "01/02/94");
        people[3] = new Person("Labowski", "Big", 'Y', "03/04/80");
        people[4] = new Person("Newman", "Paul", 'K', "04/05/89");
    }
    
    public int showMenu() {
        // Write out the menu
        System.out.println("1. Display all names");
        System.out.println("2. Display all info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Exit");
        System.out.println("Choice:");
        
        // Receive and return an input
        return input.nextInt();
    }
    
    public void executeChoices() {
        // use a switch statement to determine which menu option to execute
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
        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + ". " + people[i].getFullName());
        }
    }
    
    public void menuOption2() {
        // Prompt and store user input
        System.out.print("Please enter a number between 1 and " + people.length);
        int userChoice = input.nextInt() - 1;
        
        // display user info
        System.out.println("\nPerson Data");
        System.out.println("Full Name: " + people[userChoice].getFullName());
        System.out.println("Birth Date: " + people[userChoice].getBirthDate());
    }
    
    public void menuOption3() {
        // Prompt for a user to edit
        System.out.print("Please enter a number between 1 and " + people.length);
        int userChoice = input.nextInt() - 1;
        
        // Display a submenu
        System.out.println("Please select the data you want to edit: ");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Middle Initial");
        System.out.println("4. Birth Date");
        System.out.println("5. Cancel");
        userChoice = input.nextInt();
        
        // Use a switch statement to edit data
        switch(userChoice) {
            case 1:
                System.out.print("\n\nEnter new first name: ");
                people[userChoice].setFirstName(input.next());
                break;
            case 2:
                System.out.print("\n\nEnter new last name: ");
                people[userChoice].setLastName(input.next());
                break;
            case 3: 
                System.out.print("\n\nEnter new middle initial: ");
                people[userChoice].setMiddleInit(input.next().charAt(0));
                break;
            case 4:
                System.out.print("\n\nEnter new birth date: ");
                people[userChoice].setBirthDate(input.next());
                break;
            case 5:
                break;
        }
    }
    
    public void main(String[] args) {
        /*
        I think in the main method, you should create an instance of class PersonProgram, then get access to method getData()
        */
        
        /*PersonProgram ThePerson = new PersonProgram();
        ThePerson.getData();
        ThePerson.executeChoices();*/
        //getData();
        //executeChoices();
    }
    
}
