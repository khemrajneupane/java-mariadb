<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Search By Id </title>
<link type = "text/css" rel = "stylesheet" href = "bootstrap/css/bootstrap.min.css">
</head>
<body>
<div style="margin: 30px">
	<h1>Searching By Id</h1>
	
		<%-- If the list is empty, then show an appropriate message --%>
		
				<c:if test="${ studentList != null && studentList.size() > 0 }">
					<c:forEach items="${ studentList }" var="studentObject">
							<c:if test="${studentObject.id != undefined}">

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
				
						<tr>
							<td><c:out value="${ studentObject.id}" /></td>
							<td><c:out value="${ studentObject.firstName }" /></td>
							<td><c:out value="${ studentObject.lastName }" /></td>
							<td><c:out value="${ studentObject.streetAddress }" /></td>
							<td><c:out value="${ studentObject.postCode }" /></td>
							<td><c:out value="${ studentObject.postOffice }" /></td>
							<td>
								<a href="addStudentList/studentObject?id=${studentObject.id}">${studentObject.firstName}</a>
							</td>
							
						</tr>
							
				</tbody>
			</table>
			</c:if>
							<c:if test="${studentObject.id == undefined}">
							<h1>Id does not exist in the database</h1>
							</c:if>
					</c:forEach>
			
			</c:if>
			<c:if test="${ studentList != null && studentList.size() == 0 }">
				<h1>Id is required!</h1>
			</c:if>
	
	
			<form class = "form-control plaintext" action="searchById" method="GET">
				<button class="btn btn-primary col-md-3 mb-3" type="submit">searchById</button>
					<input type="text" name="id" placeholder= "enter id to search record"/>
			</form>
					
			<form class = "form-control plaintext" action="studentList" method="GET">
					<button class="btn btn-primary col-md-3 mb-3" type="submit">ShowAllStudents</button>
			</form>
		
		</div>
</body>
</html>
		
	
	
	
	
