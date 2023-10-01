/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcourse;

/**
 *
 * @author pulup
 */
public class UserTimeTable implements UserData {
    
//    private String day;
//    private String room;
//    private String location;
//    private String start;
//    private String end;
//    private String userclass;
//    private String description;
//
      
    //public UserTimeTable(){
        
   // }    
    public String userSchedule;
    public UserTimeTable(){
        //empty constructor
    }
    public UserTimeTable(String userSchedule){
        this.userSchedule = userSchedule;
        
    }
    
    @Override
    public void example() {
        String output = 
    //              "+-----------------------------------------------------------------------------------+\n";
    //    output += "|    YOUR TIMETABLE.                                                                |\n";
    //    output += "+----------+----------------+-------------+------------+-------------+------------+\n";
    //    output += "|CourseCode|  Description   |     Day     |    Stream  |     Paper   |     Time   |\n";
    //    output += "+----------+----------------------------+-------------+------------+-------------+------------+\n";
                  "+-----------------------------------------------------------------------------------------------------------------+\n";
        output += "|                            YOUR TIMETABLE                                                                       |\n";
        output += "+------------+----------------------------------------+-----------+-------------+-----------+---------------------+\n";
        output += "| CourseCode |             Description                |    Day    |   Stream    |   Paper   |         Time        |\n";
        output += "+------------+----------------------------------------+-----------+-------------+-----------+---------------------+\n";
        
        output += userSchedule;
        System.out.println(output);
    }
    
    public static void main(String[] args){
        
        UserTimeTable usertest = new UserTimeTable();
        usertest.example();
        
        
        
    }
    
    
    
}
