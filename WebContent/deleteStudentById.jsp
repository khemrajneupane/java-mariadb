<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type = "text/css" rel = "stylesheet" href = "bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div style="margin: 30px">
			<h1>Enter student id to delete</h1>
		<div class = "row">
			
				<form class = "form-control-plaintext col-md-6" action="studentList" method="GET">
					<button class="btn btn-primary" type="submit">ShowAllStudents</button>
				</form>
			
		
			
				<form class = "form-control-plaintext col-md-6" action="deleteStudentById" method="POST">
				<button class="btn btn-primary" type="submit">Delete</button> 
					<input type="text" name="id" placeholder = "enter id to delete"/>
					
				</form>
			
		</div>
	
	</div>
</body>
</html>