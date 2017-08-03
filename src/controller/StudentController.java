package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.StudentDA;
import model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String LIST_STUDENT="/student.jsp";
	public static final String FORM_STUDENT="/form_student.jsp";
	
	
	
	//הפנייה ל
	// DA
	StudentDA myStudentDA;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
        
        myStudentDA=new StudentDA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action=request.getParameter("action");
		String forward="";
		
		if(action.equalsIgnoreCase("listStudent"))
		{
			forward=LIST_STUDENT;
			List<Student> list=myStudentDA.getAllStudents();
			request.setAttribute("studentim", list);
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			forward=LIST_STUDENT;
			String studentID=request.getParameter("id");
			
			myStudentDA.deleteStudent(studentID);
			 
			List<Student> list=myStudentDA.getAllStudents();
			request.setAttribute("studentim", list);
			
			
		}
		else if(action.equalsIgnoreCase("update"))
		{
		  forward=FORM_STUDENT;
		  String studentID=request.getParameter("id");
		  Student student= myStudentDA.getStudentByID(studentID);
		  request.setAttribute("haham", student);
		  
		}
		else if(action.equalsIgnoreCase("insert"))
		{
		  forward=FORM_STUDENT;
		 // String studentID=request.getParameter("id");
		  //Student student= myStudentDA.getStudentByID(studentID);
		 // request.setAttribute("peula", "hosafa");
		  
		}
				
	RequestDispatcher dispatcher=request.getRequestDispatcher(forward);
	dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		request.setCharacterEncoding("UTF-8");
		
		String f_name=request.getParameter("f_name_param");
		String l_name=request.getParameter("l_name_param");
		student.setFirstName(f_name);
		student.setLastName(l_name);
		
		
		String id=request.getParameter("id_param");
		String action_type=request.getParameter("action_type");
		
		if(id == null || id.isEmpty())
		{
			//להוסיף תגובה להזנת ID
		}
		
		else
		{
			student.setStudentId(id);
			
			if(action_type.equals("Update"))
			{
				myStudentDA.updateStudent(student);
			}
			else
			{
				myStudentDA.addStudent(student);
			
			}
			
			
		}
		
		
		
		
		
		
		//דומה למה שכבר עשינו ב דו גת
		
        List<Student> list=myStudentDA.getAllStudents();
		request.setAttribute("studentim", list);
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(LIST_STUDENT);
		dispatcher.forward(request, response);
		
		
		
		
		
	}

}
