import java.util.Scanner;

/**
* This class contains the main method which is a menu driven application. The program prompts the user for an input which is then used to execute an event.
*/
public class PlannerManager{
  public static void main(String[] args) {
    Planner planner = new Planner();
    Planner backupPlanner = new Planner();

    Scanner scan = new Scanner(System.in);
    String menu = "(A) Add Course\n(G) Get Course\n(R) Remove Course\n(P) Print Courses in Planner\n(F) Filter by Department Code\n(L) Look For Course\n(S) Size\n(B) Backup\n(PB) Print Courses in Backup\n(RB) Revert to Backup\n(Q) Quit\n\nEnter a selection: ";
    System.out.print(menu);
    String selection = scan.nextLine().toUpperCase();
    System.out.println();
    while (!selection.equals("Q")) {

      // Add courses
      if (selection.equals("A")) {
        System.out.print("Enter course name: ");
        String name = scan.nextLine();

        System.out.print("Enter department: ");
        String department = scan.nextLine();

        System.out.print("Enter course code: ");
        int code = scan.nextInt();

        System.out.print("Enter course section: ");
        byte section = scan.nextByte();
        scan.nextLine();

        System.out.print("Enter instructor: ");
        String instructor = scan.nextLine();

        Course newCourse = new Course(name, department, code, section, instructor);

        System.out.print("Enter position: ");
        int position = scan.nextInt();

        System.out.println();
        planner.addCourse(newCourse, position);

        if(position >= 1 && position <= 50 && planner.size() < 50){
        System.out.println(department + " " + code + "." + String.format("%02d", section) + " successfully added to planner.");
        }
      }

      // Displays information of a course in a certain position
      else if (selection.equals("G")) {
        System.out.print("Enter position: ");
        int position = scan.nextInt();
        System.out.println();
        planner.toString(position);
        System.out.println();
      }

      // Remove a course from planner
      else if (selection.equals("R")) {
        System.out.print("Enter position: ");
        int position = scan.nextInt();

        Course temp = planner.getCourse(position - 1);

        planner.removeCourse(position);

        System.out.println("\n" + temp.getDepartment() + " " + temp.getCode() + "."
            + String.format("%02d", temp.getSection()) + " has been successfully removed from the planner.");
      }

      // Print courses in planner
      else if (selection.equals("P")) {
        System.out.println("Planner:");
        System.out.println(planner);
      }

      // Display courses with department code
      else if (selection.equals("F")) {
        System.out.print("Enter department code: ");
        String department = scan.nextLine();
        Planner.filter(planner, department);
        System.out.println();
      }

      // Look for course with given attribute
      else if (selection.equals("L")) {
        System.out.print("Enter course name: ");
        String name = scan.nextLine();

        System.out.print("Enter department: ");
        String department = scan.nextLine();

        System.out.print("Enter course code: ");
        int code = scan.nextInt();

        System.out.print("Enter course section: ");
        byte section = scan.nextByte();
        scan.nextLine();

        System.out.print("Enter instructor: ");
        String instructor = scan.nextLine();

        Course searchCourse = new Course(name, department, code, section, instructor);

        int pointer = 0;
        boolean isFound = false;
        while (pointer < planner.size()) {
          if (planner.getCourse(pointer).equals(searchCourse)) {
            System.out.println();
            System.out.println(department + " " + code + "." + String.format("%02d", section)
                + " is found in the planner at position " + (pointer + 1) + ".");
            pointer++;
            isFound = true;
            break;
          }
          pointer++;
        }
        if (!isFound) {
          System.out.println(
              department + " " + code + "." + String.format("%02d", section) + " was not found in the planner.");
        }
      }

      // Display amount of courses in planner
      else if (selection.equals("S")) {
        if (planner.size() == 0) {
          System.out.println("There are no courses in the planner.");
        } else if (planner.size() == 1) {
          System.out.println("There is one course in the planner.");
        } else {
          System.out.println("There are " + planner.size() + " courses in the planner.");
        }
      }

      // Creates a copy of the planner
      else if (selection.equals("B")) {
        backupPlanner = planner.clone();
        System.out.println("Created a backup of the current planner.");
      }

      // Print courses in backup
      else if (selection.equals("PB")) {
        System.out.println("Planner (Backup): ");
        System.out.println(backupPlanner);
      }

      // Revert to backup
      else if (selection.equals("RB")) {
        planner = backupPlanner.clone();
        System.out.println("Planner succesfully reverted to the backup copy.");
      }

      System.out.println();
      System.out.println(menu);
      System.out.println();
      System.out.print("Enter a selection: ");
      selection = scan.nextLine().toUpperCase();
      System.out.println();
    }
  System.out.println("Program terminating successfully...");
  }
}