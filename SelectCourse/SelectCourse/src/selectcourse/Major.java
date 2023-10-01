/**
 *
 * @author pulup

*/

package selectcourse;
import java.util.Scanner;
public class Major {
    
    String major;
    String userID;
    public Major(){
        //empty contructor
    }
    
    public Major(String userID,String major){
        this.userID = userID;
        this.major = major;
    }
    //get and set methods
    public String getMajor(){
        return this.major;
    }
    public void setMajor(String major){
        this.major = major;
    }
    
    public int userMajor(String userID){
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        while (true){
        System.out.println("Enter your First Major:");
        System.out.println("1. Digital Service");
        System.out.println("2. Networks and Cybersecurity");
        System.out.println("3. Software Development");
        System.out.println("4. Data Science");
        System.out.println("5. Computer Science");
        System.out.println("6. Exit");
        
         try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer between 1 and 6.");
            }
        }
        return choice;
    }
    public int userMajor(String userID, int userFirstMajor){
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        while (true){
        System.out.println("Enter your Second Major:");
        System.out.println("1. Digital Service");
        System.out.println("2. Networks and Cybersecurity");
        System.out.println("3. Software Development");
        System.out.println("4. Data Science");
        System.out.println("5. Computer Science");
        System.out.println("6. Exit");
        
         try {
                choice = Integer.parseInt(scanner.nextLine());
                if (userFirstMajor == choice){
                    System.out.println("This Major has already been selected: Please enter a number 1 and 6");
                }
                else if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer between 1 and 6.");
            }
        }
        return choice;
    }
    
    
    
    
    public String userMajorSelection(int userMajor) {
        
        switch (userMajor) {
            case 1:
                this.setMajor("Digital Service");
                break;
            case 2:
                this.setMajor("Networks and Cybersecurity");
                break;
            case 3:
                this.setMajor("Software Dvelopment");
                break;
            case 4:
                this.setMajor("Data Science");
                break;
            case 5:
                this.setMajor("Computer Science");
                break;
            case 6:
                System.out.println("Exiting the program");
                System.exit(0);
                
                break;
            }
        
        return getMajor();
        
        
        
    }
    
    public static void main(String[] args)
    {
        
    }
}