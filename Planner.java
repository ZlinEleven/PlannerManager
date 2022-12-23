public class Planner {
  final int MAX_COURSES = 50;
  Course[] courses;
  int courseCount = 0;

  public Planner() {
    courses = new Course[50];
  }

  /**
   * Prints out the courses containing a specific department in a neatly formatted
   * table
   * 
   * @param planner    The planner that will be searched through for the courses
   * @param department The specific department that is being filtered for.
   */
  public static void filter(Planner planner, String department) {
    planner.toString(department);
  }

  /**
   * Gives the array that contains all the course in the planner
   * 
   * @return courses The array that contains the courses in the planner
   */
  public Course[] getCourses() {
    return courses;
  }

  /**
   * Add a course to the planner
   * 
   * @param newCourse An initialized course that will be added to the planner
   * @param position  The position in the planner the new course will be
   *                  added into. All the courses at and after the indicated
   *                  position
   *                  will be moved back one index (ex. the course in index 5 will
   *                  be * moved to index 6)
   */
  public void addCourse(Course newCourse, int position) {
    if (position <= 0 || position > 50) {
      System.out.println("The position entered is not within the valid range.");
      return;
    }
    if (this.size() >= 50) {
      System.out.println("There is no more room in the planner to record an additional course.");
      return;
    }

    courseCount += 1;
    int pointer = position - 1;
    Course temp = courses[pointer];
    courses[pointer] = newCourse;
    Course tempCourse = temp;

    while (pointer <= MAX_COURSES && pointer < this.size()) {
      pointer++;
      temp = courses[pointer];
      courses[pointer] = tempCourse;
      tempCourse = temp;
    }
  }

  /**
   * Overloaded constructor for the planner class. Automatically adds a course at
   * the end of the list instead of a specified position
   * 
   * @param newCourse An initialized course that will be added to the planner
   */
  public void addCourse(Course newCourse) {
    this.addCourse(newCourse, this.size() + 1);
  }

  /**
   * Will remove the course at the indicated position
   * 
   * @param position The position in the planner that a course will be removed
   *                 from. All the courses after the position will be moved
   *                 forward one position
   */
  public void removeCourse(int position) {
    if (position <= 0 || position >= 50) {
      System.out.println("The position entered is not within the valid range.");
      return;
    }

    position -= 1;
    while (position <= this.size()) {
      courses[position] = courses[position + 1];
      position++;
    }
    courseCount -= 1;
  }

  /**
   * Gives the course that is in the indicated position
   * 
   * @param position The position of the course in the planner that will
   *                 be returned
   * @return The course in the indicated position
   */
  public Course getCourse(int position) {
    return courses[position];
  }

  /**
   * Creates a copy of the planner with all the courses in the same order. The
   * changes made in the copy will not affect the original and vice versa
   * 
   * @return The newly intialized copy of the original planner
   */
  public Planner clone() {
    Planner newPlanner = new Planner();
    int position = 0;
    while (position < this.size()) {
      newPlanner.addCourse(this.getCourse(position).clone());
      position++;
    }
    return newPlanner;
  }

  /**
   * Determines whether a course is contained within the planner.
   * 
   * @param course An intitlaized course that is compared to the
   *               courses in the planner to determine whether it is in the
   *               planner or not
   * @return A true or false value determining whether the course parameter is
   *         within the planner
   */
  public boolean exists(Course course) {
    int position = 0;
    while (position < this.size()) {
      if (this.courses[position].equals(course)) {
        return true;
      }
      position++;
    }
    return false;
  }

  /**
   * Gives the amount of courses currently in the planner
   * 
   * @return A member variable that holds the amount of courses in the planenr
   */
  public int size() {
    return courseCount;
  }

  /**
   * Determines whether this planner and another planner has the same courses.
   * Compares the courses of both planners at all positions. If all the
   * courses has the same attributes, the planners are equal.
   * 
   * @param obj The other planner that is being compared to this planner
   * @return A boolean value showing whether the two planners are equal
   */
  public boolean equals(Planner obj) {
    int position = 0;
    if (obj instanceof Planner) {
      if (this.size() != obj.size()) {
        return false;
      }
      while (position < this.size() || position < obj.size()) {
        if (!this.getCourse(position).equals(obj.getCourse(position))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public void printAllCourses() {
    System.out.println(this);
  }

  // Default toString
  /**
   * Prints out a string representation of the planner class. The
   * planner is printed in a neatly formatted table with each individual
   * course on its own row.
   */
  public String toString() {
    System.out.println(String.format("%-4s%-25s%-11s%4s%9s%-10s", "No.", "Course Name", "Department", "Code",
        "Section ", "Instructor"));
    System.out.println("--------------------------------------------------------------------");

    int pointer = 0;
    while (pointer < this.size()) {
      Course thisCourse = courses[pointer];
      System.out.format("%-4s%-25s%-11s%4s%9s%-10s", pointer + 1, thisCourse.getName(), thisCourse.getDepartment(),
          thisCourse.getCode(), String.format("%02d", thisCourse.getSection()) + " ", thisCourse.getInstructor());
      System.out.println();
      pointer += 1;
    }
    return "";
  }

  // toString by department code
  /**
   * An overloaded toString method that only prints out the courses in
   * the planner with a specific department
   * 
   * @param department The 3-letter code that is used to filter through
   *                   which course to print out
   */
  public String toString(String department) {
    System.out.println(String.format("%-4s%-25s%-11s%4s%9s%-10s", "No.", "Course Name", "Department", "Code",
        "Section ", "Instructor"));
    System.out.println("--------------------------------------------------------------------");

    int pointer = 0;
    while (pointer < this.size()) {
      Course thisCourse = courses[pointer];
      if (thisCourse.getDepartment().equals(department)) {
        System.out.format("%-4s%-25s%-11s%4s%9s%-10s", pointer + 1, thisCourse.getName(), thisCourse.getDepartment(),
            thisCourse.getCode(), String.format("%02d", thisCourse.getSection()) + " ", thisCourse.getInstructor());
        System.out.println();
      }
      pointer += 1;
    }
    return "";
  }

  // toString by position
  /**
   * An overloaded toString method that only prints out the course in a specific
   * position in the planner
   * 
   * @param position The position in the planner that is going to be printed out
   */
  public String toString(int position) {
    System.out.println(String.format("%-4s%-25s%-11s%4s%9s%-10s", "No.", "Course Name", "Department", "Code",
        "Section ", "Instructor"));
    System.out.println("--------------------------------------------------------------------");

    Course thisCourse = courses[position - 1];
    System.out.format("%-4s%-25s%-11s%4s%9s%-10s", position, thisCourse.getName(), thisCourse.getDepartment(),
        thisCourse.getCode(), String.format("%02d", thisCourse.getSection()) + " ", thisCourse.getInstructor());

    return "";
  }
}