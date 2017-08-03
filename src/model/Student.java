package model;
//מטרה של המחלקה  - להיות המקבילה לטבלת סטודנטים בעולם מונחה עצמים
public class Student {
	//רשימת המשתנים כרשימת שדות בטבלה המקבילה
         //טיפוסים של המשתנים כטיפוסים של השדות בטבלאות המקבילות
	      private String studentId;
          private String firstName;
          private String lastName;
    
 //מ
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }

}


