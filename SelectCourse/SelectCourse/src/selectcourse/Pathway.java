/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcourse;

import java.util.Scanner;

/**
 *
 * @author pulup

*/

import java.util.Scanner;

public class Pathway {

    public String userID;
    public String pathwaySelection;

    Pathway(String userID, String pathwaySelection) {
        this.userID = userID;
        this.pathwaySelection = pathwaySelection;
    }

    public String getPathwaySelection() {
        return this.pathwaySelection;
    }

    public void setPathwaySelection(String pathwaySelection) {
        this.pathwaySelection = pathwaySelection;
    }

    
    public int Pathway(String userID) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Please pick a Pathway:");
            System.out.println("1. Double Major");
            System.out.println("2. Single Major, Two Minor");
            System.out.println("3. Single Major, One Minor, Four Elective");
            System.out.println("4. Exit the program");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer between 1 and 3.");
            }
        }

        return choice;
    }
    
    public void userPathway(int choice) {
        switch (choice) {
            case 1:
                setPathwaySelection("Double Major");
                break;
            case 2:
                setPathwaySelection("Single Major, Two Minor");
                break;
            case 3:
                setPathwaySelection("Single Major, One Minor, Four Elective");
                break;
            case 4:
                System.out.println("Exiting the program");
                System.exit(0);
                break;
        }
        
     
    }
    
   
    
    
       public static void main(String[] args) {
        
    }
       
}





