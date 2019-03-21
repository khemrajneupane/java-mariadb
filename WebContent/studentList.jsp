<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing all activities related to student db</title>
<link type = "text/css" rel = "stylesheet" href = "bootstrap/css/bootstrap.min.css">
</head>
<body>
<div style="margin: 30px">
	<h3>List of Students</h3>
	
		<div class = "row jumbotron">
			<form class = "form-control-plaintext col-sm-3" action="studentList" method="GET">
				<button class="btn btn-primary" type="submit">ShowAllStudents</button> 
			</form>
			<form class = "form-control-plaintext col-sm-3" action="addStudentList.jsp" method="POST">
				<button class="btn btn-primary" type="submit">AddStudents</button>
			</form>
			<form class = "form-control-plaintext col-sm-3" action="deleteStudentById.jsp" method="GET">
				<button class="btn btn-danger" type="submit">DeleteById</button>
			</form>
			<form class = "form-control-plaintext col-sm-3" action="searchById.jsp" method="GET">
				<button class="btn btn-primary" type="submit">SearchById</button>
			</form>
		</div>
		
		 <div>
		<c:if test="${ studentList != null && studentList.size() > 0 }">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Street Address</th>
						<th>Post Code</th>
						<th>Post Office</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ studentList }" var="studentObject">
						<tr>
							<td><c:out value="${ studentObject.id}" /></td>
							<td><c:out value="${ studentObject.firstName }" /></td>
							<td><c:out value="${ studentObject.lastName }" /></td>
							<td><c:out value="${ studentObject.streetAddress }" /></td>
							<td><c:out value="${ studentObject.postCode }" /></td>
							<td><c:out value="${ studentObject.postOffice }" /></td>
							<td>
							<a href ="#">${studentObject.firstName }</a>
							</td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<%-- If the list is empty, then show an appropriate message --%>
		<c:if test="${ studentList != null && studentList.size() == 0 }">
			<h1>No students found!</h1>
		</c:if>
		</div>
	</div>	 
		<script type = "text/javascript" src = "bootstrap/js/bootstrap.min.js"></script>
</body>
</html>