package da;

import java.util.List;

import model.Student;

public interface StudentdaI 
{
	//CRUD-Create 
	public void addStudent(Student student);
	
	//CRUD-Read
	public List<Student> getAllStudents();
	public Student getStudentByID(String StudentID);
	
	//CRUD-Update
	public void updateStudent(Student student);
	
	//CRUD-Delete
	public void deleteStudent(String StudentID);
	
}
