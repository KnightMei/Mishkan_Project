package da;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBUtil;

public class StudentDA implements StudentdaI {

		private Connection conn;
	
		public StudentDA(){
			conn=DBUtil.getConnection();
		}
	//להחזיר רשימת של כל הסטודנטים
	@Override
	public void addStudent(Student student) {
		try{
			String query="INSERT INTO public.students (stud_id, f_name, l_name) VALUES (?,?,?)";
			PreparedStatement 	preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		   }
		catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}

	

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=new ArrayList<Student>();
		//Student[] students=new Student[10];
	    try
	    {
	    	String query="SELECT * FROM public.students";
	        Statement statement=conn.createStatement();
	        
	        ResultSet reshimatStudentim=statement.executeQuery(query);
	        
	        while(reshimatStudentim.next())
	        {
	        	Student s=new Student();
	        	s.setStudentId(reshimatStudentim.getString("stud_id"));
	        	s.setFirstName(reshimatStudentim.getString("f_name"));
	        	s.setLastName(reshimatStudentim.getString("l_name"));
	        
	        	students.add(s);
	        
	        }
	        reshimatStudentim.close();
	        statement.close();
	      
	       }
		    catch(SQLException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	    
	    return students;
	    
	}

	@Override
	public Student getStudentByID(String StudentID) {
		Student student = new Student();
        try {
            String query = "select * from public.students where stud_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, StudentID);
            
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	student.setStudentId( resultSet.getString( "stud_id" ) );
                student.setFirstName( resultSet.getString( "f_name" ) );
                student.setLastName( resultSet.getString( "l_name" ) );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return student;

	}

	@Override
	public void updateStudent(Student student) {
		try {
            String query = "update public.students set  f_name=?, l_name=? where stud_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            
            preparedStatement.setString( 1, student.getFirstName() );
            preparedStatement.setString( 2, student.getLastName() );
            preparedStatement.setString( 3, student.getStudentId() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }


	}

	@Override
	public void deleteStudent(String StudentID) {
		 try {
	            String query = "delete from public.students where stud_id=?";
	            PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, StudentID);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	        	 System.out.println(e.getMessage());
	        }


	}

}
