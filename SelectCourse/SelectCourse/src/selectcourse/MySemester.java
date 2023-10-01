package selectcourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MySemester extends Semester {
    private int currentSemester;
    private Scanner scan = new Scanner(System.in);
    private Map<String, String> selectedClassesWithTime = new HashMap<>();
    private Set<Integer> selectedChoices = new HashSet<>();

    public MySemester(
        List<String> courseClass,
        List<String> semester,
        List<String> days,
        List<String> streams
    ) {
        super(courseClass, semester, days, streams); //inherit classes from the Semester class
    }

    @Override
    public void courseClass() {
        courseClass.clear();

        if (currentSemester == 1) {
            courseClass.add("COMP500:      Programming Concepts and Techniques      (Monday)     Stream: /50 (core paper)");
            courseClass.add("COMP501:      Computing Technology in Society          (Tuesday)    Stream: /51 (core paper)");
            courseClass.add("MATH502:      Algebra and Discrete Mathematics         (Wednesday)  Stream: /52 (core paper)");
            courseClass.add("COMP507:      IT Project Management                    (Thursday)   Stream: /50 (core paper)");
            courseClass.add("COMP508:      Database System Design                   (Monday)     Stream: /50 (core paper)");

        } else if (currentSemester == 2) {
            courseClass.add("COMP508:   Database System Design                (Monday)      Stream: /50 (core paper)");
            courseClass.add("INFS502:   Digital Services in IT                (Tuesday)     Stream: /51 (Digital Service ONLY)");
            courseClass.add("COMP504:   Networks and Internet                 (Wednesday)   Stream: /52 (Networks & Cybersecurity ONLY)");
            courseClass.add("COMP517:   Data Analysis                         (Thursday)    Stream: /50 (Data Science ONLY)");
            courseClass.add("COMP500:   Programming Concepts and Techniques   (Monday)      Stream: /50 (core paper)");
            courseClass.add("COMP501:   Computing Technology in Society       (Tuesday)     Stream: /51 (core paper)");
            courseClass.add("MATH502:   Algebra and Discrete Mathematics      (Wednesday)   Stream: /52 (core paper)");
            courseClass.add("COMP507:   IT Project Management                 (Thursday)    Stream: /50 (core paper)");
            courseClass.add("COMP503:   Programming 2                         (Friday)      Stream: /51 (Software development or Computer science ONLY)");

        }
    }

    @Override
    public void streams() {
        streams.add("/50");
        streams.add("/51");
        streams.add("/52");
    }

    @Override
    public void days() {
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
    }

    @Override
    public void semester() {
        semester.add("Semester 1");
        semester.add("Semester 2");
    }

 public String finalDisplay() {
    Studentlogin login = new Studentlogin("", "", "");  //Create a Studentlogin object login
    String userID = login.getUserID();
    Pathway pathway = new Pathway(userID, ""); //Create a Pathway object pathway
    String line = "";

    int semesterPick;

    do {
        System.out.println("Select a Semester:");
        System.out.println("1. Semester 1");
        System.out.println("2. Semester 2");
        System.out.println("0. Exit");

        // Check if the input is an integer
        if (scan.hasNextInt()) {
            semesterPick = scan.nextInt();
            scan.nextLine(); // Consume the newline character
            if (semesterPick >= 1 && semesterPick <= 2) {
                break; // Valid input, exit the loop
            } else if (semesterPick == 0) {
                System.out.println("Exiting the program.");
                return line;
            } else {
                System.out.println("Invalid semester choice. Please enter 1, 2, or 0 to exit.");
            }
        } else {
            // Input is not an integer, consume the invalid input
            scan.nextLine();
            System.out.println("Invalid input. Please enter a valid integer (1, 2, or 0).");
        }
    } while (true);

    if (semesterPick == 1) {
        System.out.println("Semester 1 chosen");
        currentSemester = 1;
    } else if (semesterPick == 2) {
        System.out.println("Semester 2 chosen");
        currentSemester = 2;
    }

    courseClass(); //call the subjects that corresponds with the user's semester choice

    int maxCourseSelections = 4; //set max course selection of 4
    
    
    System.out.println("Please choose " + maxCourseSelections + " classes by entering the corresponding numbers:");
    System.out.println("Enter 0 to exit at any time.");

    for (int i = 0; i < maxCourseSelections; i++) {
    displayCourseOptions();
    int choice;

    do {
        try {
            choice = scan.nextInt();
            if (choice < 0 || choice > courseClass.size() || selectedChoices.contains(choice)) {
                if (selectedChoices.contains(choice)) {
                    System.out.println("You already selected this choice. Please enter a different one.");
                } else {
                    System.out.println("Invalid choice. Please enter a valid course number.");
                }
                scan.nextLine();
            }
        } catch (java.util.InputMismatchException e) {
            // Handle the exception (e.g., print an error message)
            System.out.println("Invalid input. Please enter a valid course number.");
            scan.nextLine(); // Consume the invalid input
            choice = -1; // Set choice to -1 to re-enter the selection
        }
    } while (choice < 0 || choice > courseClass.size() || selectedChoices.contains(choice));

    if (choice == 0) {
        System.out.println("Exiting the program.");
        return line;
    }

    String selectedCourse = courseClass.get(choice - 1);
    selectedClassesWithTime.put(selectedCourse, generateRandomTime());
    selectedChoices.add(choice);
    System.out.println("You selected: " + selectedCourse);
}


    System.out.println("You have selected the following classes:");
    for (Map.Entry<String, String> entry : selectedClassesWithTime.entrySet()) {
        System.out.println(entry.getKey() + "" + entry.getValue());
        line+= entry.getKey() + "" + entry.getValue()+"\n";
    }

    return line;
}

 


    private void displayCourseOptions() {
        System.out.println("Available Courses:");
        List<String> availableCourses = filterCoursesByDay(courseClass);
        for (int i = 0; i < availableCourses.size(); i++) {
            System.out.println((i + 1) + ". " + availableCourses.get(i));
        }
    }

    private List<String> filterCoursesByDay(List<String> courses) {
        List<String> availableCourses = new ArrayList<>();
        List<String> remainingDays = new ArrayList<>(List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));

        Random random = new Random();

        for (String course : courses) {
            if (!remainingDays.isEmpty()) {
                int randomIndex = random.nextInt(remainingDays.size());
                String selectedDay = remainingDays.get(randomIndex);
                remainingDays.remove(randomIndex);

                availableCourses.add(course.replace("(Day)", "(" + selectedDay + ")"));
            } else {
                availableCourses.add(course);
            }
        }

        return availableCourses;
    }

    private String generateRandomTime() {
        String[] times = {
            "9:00 AM - 10:30 AM",
            "10:00 AM - 11:30 AM",
            "1:00 PM - 2:30 PM",
            "3:00 PM - 4:30 PM"
        };
        Random random = new Random();
        return times[random.nextInt(times.length)];
    }

    private void generateSchedule(Map<String, String> selectedCourses) {
        
        // Your schedule generation code here
    }

    public static void main(String[] args) {
        MySemester userPick = new MySemester(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        userPick.finalDisplay();
    }
}