/**
 *
 * @author Johnny Lolo
 */
package selectcourse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateUser {
    
    String fileName = "UserDatabase.txt";
    
    public boolean updateUser(String userID, String newPassword, String newName) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userName_Pass = line.split(",");
                if (userName_Pass.length == 3 && userName_Pass[0].equals(userID)) {
                    updatedLines.add(userID + "," + newPassword + "," + newName);
                } else {
                    updatedLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addUser(String userID, String password, String userName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userID + "," + password + "," + userName);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // You can add code to test your methods here if needed.
    }
}
