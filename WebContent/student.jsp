<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>רשימת סטודנטים</H1>
<table border=3>
   <thead>
	  <tr><TH>ID</TH><TH>שם פרטי</TH><TH>שם משפחה</TH><TH colspan=2>פעולה</TH></tr>
	</thead>
	<tbody>
	<c:forEach items="${studentim}" var="talmid">
	  <tr>
		  <td><c:out  value="${talmid.studentId}"/></td>
		  <td><c:out  value="${talmid.firstName}"/></td>
		  <td><c:out  value="${talmid.lastName}"/></td>
		  <td>
		  <a href="   StudentController?action=delete&id=<c:out  value="${talmid.studentId}"/>">מחיקה</a>
		  <a href="   StudentController?action=update&id=<c:out  value="${talmid.studentId}"/>">עדכן</a>
		  
		  </td>
	  </tr>
	  </c:forEach>
	</tbody>
</table>

<p>
<a href="StudentController?action=insert">Add Student</a>
</p>

</body>
</html>