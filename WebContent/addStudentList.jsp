<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<title>Adding Students</title>
<link type = "text/css" rel = "stylesheet" href = "bootstrap/css/bootstrap.min.css">
</head>

<body>

<div style="margin: 30px">
	<h1 class = "jumbotron">Add Student to MariaDB Database</h1>
	<div>
		<form class = "form-control-plaintext col-sm-4" action="studentList" method="GET">
			<button class="btn btn-primary" type="submit">ShowAllStudents</button>
		</form>
	</div>
	

	<div>
	
		<form class = "form-control" action="addStudentList" method="POST">
		
			<input class="col-md-4 mb-3" type="text" name="id" placeholder="id"/>
			<input class="col-md-4 mb-3" type="text" name=firstName placeholder="firstName"/>
			<input class="col-md-4 mb-3" type="text" name="lastName" placeholder="lastName"/>
			<input class="col-md-4 mb-3" type="text" name="streetAddress" placeholder="streetAddress"/>
			<input class="col-md-4 mb-3" type="text" name="postCode" placeholder="postCode"/>
			<input type="text" name="postOffice" placeholder="postOffice"/>
			
			<button class="btn btn-primary col-md-8 mb-3" type="submit">AddStudent</button>
		</form>
		
	</div>
	
</div>
<script type = "text/javascript" src = "bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

