<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="card">
		<div class="card-header bg-primary text-white">
			<h3>WELCOME TO EMPLOYEES DATA</h3>
		</div>
		<div class="card-body">
			<table class="table table-hover">
				<tr class="bg-info text-white">
			        <th>EMPLOYEE ID</th>
			        <th>EMPLOYEE NAME</th>
			        <th>EMAIL</th>
			        <th>SALARY</th>
			        <th>DEPT</th>
			        <th>HRA</th>
			        <th>DA</th>
			        <th>LINK</th>
			    </tr>
			    <c:forEach items="${list}" var="ob">
			        <tr>
			            <td>${ob.eid}</td>
			            <td>${ob.ename}</td>
			            <td>${ob.email}</td>
			            <td>${ob.esal}</td>
			            <td>${ob.edept}</td>
			            <td>${ob.hra}</td>
			            <td>${ob.da}</td>
			            <td>
			            	<a class="btn btn-danger" href="delete?eid=${ob.eid}">DELETE</a> |
			            	<a class="btn btn-success" href="update?eid=${ob.eid}">UPDATE</a> 
			            </td>
			        </tr>
			    </c:forEach>
			</table>
		</div>
			
	</div>
	<nav aria-label="Page navigation example">
			  <ul class="pagination">
			  	<c:if test="${!page.isFirst()}">
					<li class="page-item"><a class="page-link" href="?page=0">FIRST</a></li>
				</c:if>
				<c:if test="${page.hasPrevious()}">
					 <li class="page-item"><a class="page-link" href="?page=${page.getNumber()-1}">PREVIOUS</a></li>
				</c:if>
			    <c:forEach var="i" begin="0" end="${page.getTotalPages()-1}">
					 <li class="page-item"><a class="page-link" href="?page=${i}">${i+1}</a></li>
				</c:forEach>
			    <c:if test="${page.hasNext()}">
			    	<li class="page-item"><a class="page-link" href="?page=${page.getNumber()+1}">NEXT</a></li>
				</c:if>
				<c:if test="${!page.isLast()}">
				 	<li class="page-item"><a class="page-link" href="?page=${page.getTotalPages()-1}">LAST</a></li>
				</c:if>
			    
			  </ul>
		</nav>
</div>
<p>${msg }</p>
</body>
</html>