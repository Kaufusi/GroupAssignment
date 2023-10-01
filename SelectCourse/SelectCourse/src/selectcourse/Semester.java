/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcourse;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Johnny Lolo
 */
public abstract class Semester {
    
    List<String> courseClass = new ArrayList<String>() ;
    List<String>semester = new ArrayList<String>();
    List<String> days = new ArrayList<String>();
    List<String> streams = new ArrayList<String>();
    
    
    Semester(
            List<String> courseClass, 
            List<String> semester, 
            List<String> days, 
            List<String> streams)
    {
        this.courseClass = courseClass;
        this.semester = semester;
        this.days = days;
        this.streams = streams;
    }

    
    public abstract void courseClass();
   
    public abstract void semester();
    public abstract void days();
    public abstract void streams();
    
    
    
    
    
}
