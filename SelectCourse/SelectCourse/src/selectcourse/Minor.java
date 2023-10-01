/**
 *
 * @author pulup

*/

package selectcourse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Minor {

    String minor;
    String userID;
    int userMinor;
    
    // Define a list to store available minors
    private static List<String> availableMinors = new ArrayList<>();

    // Populate the list with available minors
    static {
        availableMinors.add("Digital Service");
        availableMinors.add("Networks and Cybersecurity");
        availableMinors.add("Software Development");
        availableMinors.add("Data Science");
        availableMinors.add("Computer Science");
    }

    public Minor(String userID, String minor) {
        this.userID = userID;
        this.minor = minor;
    }
    
    public Minor(String userID, String minor, int userMinor)
    {
        this.userID = userID;
        this.minor = minor;
        this.userMinor = userMinor;
    }

    public String getMinor() {
        return this.minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    
    
    
    
    public int userMinor(String userID, String majorChoice) {
        Scanner scanner = new Scanner(System.in);
        int minorChoice;

        while (true) {
            System.out.println("\nEnter your Minor:");
            int index = 1;
            for (String availableMinor : availableMinors) {
                System.out.println(index + ". " + availableMinor);
                index++;
            }
            System.out.println(index + ". Exit");

            try {
            minorChoice = Integer.parseInt(scanner.nextLine());
               //if(pathway.getPathwaySelection().equals("Double Major"))
            
            int majorCount =0;
            int minorCount =0;
            for (String availableMinor : availableMinors) {
                
                if (majorCount == minorChoice -1) {
                    this.setMinor(availableMinor);
                    break;
                }
                majorCount++;
            }
            //for(String av)
            //this.setMinor 
            for (String availableMinor : availableMinors) {
                
                if (minorCount == minorChoice -1) {
                    this.setMinor(availableMinor);
                    break;
                }
                minorCount++;
            }
                   
                   if(this.getMinor().equalsIgnoreCase(majorChoice)) {
                    System.out.println("Major and Minor cannot be the same. Please select a different Minor.");
                }
            else if (minorChoice >= 1 && minorChoice <= (availableMinors.size() + 1)) {
                   break;
            }else{
                    System.out.println("Invalid input. Please enter a number between 1 and " + (availableMinors.size() + 1) + ".\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer between 1 and " + (availableMinors.size() + 1) + ".");
            }
            
        }
        return minorChoice;
    }
    
     public int userMinor2(String userID, String majorChoice, int userMinor) {
        Scanner scanner = new Scanner(System.in);
        int minorChoice;

        while (true) {
            System.out.println("\nEnter your Second Minor:");
            int index = 1;
            for (String availableMinor : availableMinors) {
                System.out.println(index + ". " + availableMinor);
                index++;
            }
            System.out.println(index + ". Exit");

            try {
            minorChoice = Integer.parseInt(scanner.nextLine());
               //if(pathway.getPathwaySelection().equals("Double Major"))
            
            int minorCount =0;
          
            //for(String av)
            //this.setMinor 
            for (String availableMinor : availableMinors) {
                
                if (minorCount == minorChoice -1) {
                    this.setMinor(availableMinor);
                    break;
                }
                minorCount++;
            }
                   
            if(minorChoice == userMinor){
            System.out.println("Both Minors cannot be the same. Please select a different Minor.");
                   }
            
            else if(this.getMinor().equalsIgnoreCase(majorChoice)) {
            System.out.println("Major and Minor cannot be the same. Please select a different Minor.");
                }
            else if (minorChoice >= 1 && minorChoice <= (availableMinors.size() + 1)) {
                   break;
            }else{
                    System.out.println("Invalid input. Please enter a number between 1 and " + (availableMinors.size() + 1) + ".\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer between 1 and " + (availableMinors.size() + 1) + ".");
            }
            
        }
        return minorChoice;
    }


    

    public String userMinorSelection(int userMinor) {
        if (userMinor == availableMinors.size() + 1) {
            System.out.println("Exiting the program");
            System.exit(0);
        } else if (userMinor >= 1 && userMinor <= availableMinors.size()) {
            int index = 1;
            
            for (String availableMinor : availableMinors) {
                if (index == userMinor) {
                    this.setMinor(availableMinor);
                    break;
                }
                index++;
            }
        }

        return getMinor();
    }
    
    public static void main(String[] args)
    {
        
    }
}