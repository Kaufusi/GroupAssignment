package selectcourse;

/**
 *
 * @author Johnny Lolo
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Studentlogin {
    
    private String userID;
    private String password;
    private String userName;
    private String fileName = "UserDatabase.txt";
    
    Studentlogin(String userID, String password, String userName) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
    }
    
    private boolean checkLogin(String userID, String password, String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userName_Pass = line.split(",");
                if (userName_Pass.length == 3 && userName_Pass[0].equals(userID) && userName_Pass[1].equals(password) && userName_Pass[2].equals(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

     public String studentlogin() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your Student ID:");
        userID = scan.nextLine();

        System.out.println("Enter your Password:");
        password = scan.nextLine();

        System.out.println("Enter your Name:");
        String enterName = scan.nextLine();

        userName = enterName;
        if (checkLogin(getUserID(), getPassword(), getUserName())) {
            System.out.println("Login Success! Welcome " + getUserName());
            return getUserID();
        } 
        else{
            System.out.println("Wrong login, Would you like to try again, please enter the correct credentials or create a new account");
            System.out.println("Press 1 to try again or Press 2 to create a new account");

            int choice = scan.nextInt();
            scan.nextLine(); // Consume the newline character

            while (choice == 1) {
                System.out.println("Enter your Student ID:");
                userID = scan.nextLine();

                System.out.println("Enter your Password:");
                password = scan.nextLine();

                System.out.println("Enter your Name:");
                enterName = scan.nextLine();

                if (checkLogin(getUserID(), getPassword(), enterName)) {
                    System.out.println("Login Success! Welcome back " + enterName);
                    return getUserID(); // Exit the loop
                } else {
                    System.out.println("Wrong login, Would you like to try again, please enter the correct credentials or create a new account");
                    System.out.println("Press 1 to try again or Press 2 to create a new account");
                    choice = scan.nextInt();
                    scan.nextLine(); // Consume the newline character
                }
            }

            if (choice == 2) {
                CreateUser user = new CreateUser();
                 System.out.println("Enter your Student ID:");
                userID = scan.nextLine();

                System.out.println("Enter your Password:");
                password = scan.nextLine();

                System.out.println("Enter your Name:");
                userName = scan.nextLine();
                
                if (user.addUser(getUserID(), getPassword(), getUserName())) {
                    System.out.println("User now successfully created. Please try logging in again.");
                    user.updateUser(getUserID(), getPassword(), getUserName());
                    studentlogin();
                    
                    
                } else {
                    System.out.println("Failed to create user.");
                }
            }
        }   
        return getUserID();
    }

    public static void main(String[] args) {
       
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
}
