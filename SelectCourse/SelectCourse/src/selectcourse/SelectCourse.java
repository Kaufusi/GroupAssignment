/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectcourse;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johnny Lolo & Pulu p
 */
public class SelectCourse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to The AUT BCIS 1st Year Course Selector!");
        
        Studentlogin student = new Studentlogin("", "", "");
        student.studentlogin();
        String userID = student.getUserID();
    
    
        Pathway pathway = new Pathway(userID,""); 
        int choice = pathway.Pathway(userID);
   // p1.Pathways(userId);
   
        pathway.userPathway(choice);
   
        Major major = new Major(userID,"");
        choice = major.userMajor(userID);
   
   
   
        System.out.println("User ID: " + pathway.userID);
        String pathwaychoice = pathway.getPathwaySelection();

        System.out.println("Selected Pathway: " + pathway.getPathwaySelection());
   
        System.out.println("Major: "+ major.userMajorSelection(choice));
   
   
   
        if(pathway.getPathwaySelection().equals("Double Major")) //Check if user pathway is Double Major
            {
                int twoMajor = major.userMajor(userID,choice);
                System.out.println("\n");
                System.out.println("Major: "+major.userMajorSelection(choice));

                System.out.println("Second Major: "+major.userMajorSelection(twoMajor));
            }
        else if(pathway.getPathwaySelection().equals("Single Major, Two Minor"))
           {
                String majorChoice = major.userMajorSelection(choice);
               
                int firstMinor;
                int secondMinor;
                Minor minor = new Minor(userID,"");
                firstMinor = minor.userMinor(userID, majorChoice);
       
       
                secondMinor = minor.userMinor2(userID, majorChoice, firstMinor);
       
                String selectedMinor1 = minor.userMinorSelection(firstMinor);
                String selectedMinor2 = minor.userMinorSelection(secondMinor);
       
       
       
                System.out.println("Major: " + majorChoice);
                System.out.println("Minor: "+ selectedMinor1);
                System.out.println("Minor: " + selectedMinor2);
            }

    

        else {
    
                String majorChoice = major.userMajorSelection(choice);

                Minor minor = new Minor(userID, "");
    
                choice = minor.userMinor(userID, majorChoice);
                String selectedMinor = minor.userMinorSelection(choice);
    
                System.out.println("Major: " + majorChoice);
                System.out.println("Minor: " + selectedMinor);  

    
            }
       
        MySemester userPick = new MySemester(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        String schedule = userPick.finalDisplay();
        System.out.println("");
       UserTimeTable userData = new UserTimeTable(schedule);
        // userData.userSchedu
        userData.example();
    
}



   
    
   
  
   
   
        
   
     
   
   
   
   

   
   

   
   
   
   
   
        
        
   
   
    
    
}
