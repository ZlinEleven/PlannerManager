/* Zhenbin Lin, 114866923, Recitation section 04 */

import java.util.Scanner;

/**
* This class represents a course with attributes: course name, department, code, section, and instructor
*
* @author Zhenbin Lin
*/
public class Course{
  private String name;
  private String department;
  private int code;
  private byte section;
  private String instructor;

  /**
  * Initialized a Course object
  * @param name The name of the course
  * @param department The 3-letter code representing the departmentof the course
  * @param code The 3-digit code of the course
  * @param section The number representing the recitation section of the course
  * @param instructor The instructor of the course
  */
  public Course(String name, String department, int code, byte section, String instructor){
    this.name = name;
    this.department = department;
    this.code = code;
    this.section = section;
    this.instructor = instructor;
  }

  /**
  * Gives the name of the course
  * @return The name of the course
  */
  public String getName(){
    return this.name;
  }

  /**
  * Gives the department of the course
  * @return The department of the course
  */
  public String getDepartment(){
    return this.department;
  }

  /**
  * Gives the code of the course
  * @return The code of the course
  */
  public int getCode(){
    return this.code;
  }

  /**
  * Gives the section of the course
  * @return The section of the course
  */
  public byte getSection(){
    return this.section;
  }

  /**
  * Gives the instructor of the course
  * @return The instructor of the course
  */
  public String getInstructor(){
    return this.instructor;
  }

  /**
  * Sets the name of the course
  * @param name The name of the course to be set to
  */
  public void setName(String name){
    this.name = name;
  }

  /**
  * Sets the department of the course
  * @param department The department of the course to be set to
  */
  public void setDepartment(String department){
    this.department = department;
  }

  /**
  * Sets the code of the course
  * @param code The code of the course to be set to
  */
  public void setCode(int code){
    this.code = code;
  }

  /**
  * Sets the section of the course
  * @param section The section of the course to be set to
  */
  public void setSection(byte section){
    this.section = section;
  }

  /**
  * Sets the instructor of the course
  * @param instructor The instructor of the course to be set to
  */
  public void setInstructor(String instructor){
    this.instructor = instructor;
  }

  /**
  * Created a copy of the course with all the courses within it
  * Note the changed made to the clone will not affect the original and vice versa
  * @return the copy of the course
  */
  public Course clone(){
    Course clone = new Course(this.name, this.department, this.code, this.section, this.instructor);
    return clone;
  }

  /**
  * Determines whether the course has the same attribute as another course
  * @param obj Another course that is used to compare to this course
  * @return True if the course has the same attributes as the other course, false otherwise
  */
  public boolean equals(Course obj){
    if(obj instanceof Course){   
      return this.name.equals(obj.name) && this.department.equals(obj.department) && this.code == obj.code && this.section == obj.section && this.instructor.equals(obj.instructor);
    }
    return false;
  }
}