<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<h3>UPDATE EMPLOYEE DETAILS</h3>
		</div>
		<div class="card-body">
			<form:form action="update" method="post" modelAttribute="employee">
			<div class="row">
				<div class="col-2">
					ID
				</div>
				<div class="col-4">
					<form:input  path="eid" readOnly="true" class="form-control"/>
				</div>
			</div>
			<div class="row">
				<div class="col-2">
					NAME
				</div>
				<div class="col-4">
					<form:input  path="ename" class="form-control"/>
				</div>
			</div>
					 	
			<div class="row">
				<div class="col-2">
					EMAIL
				</div>
				<div class="col-4">
					<form:input  path="email" class="form-control"/>
				</div>
			</div>
						
			<div class="row">
				<div class="col-2">
					SALARY
				</div>
				<div class="col-4">
					<form:input  path="esal" class="form-control"/>
				</div>
			</div>
						
					
			<div class="row">
				<div class="col-2">
					DEPT
				</div>
				<div class="col-4">
					<form:select path="edept" class="form-control">
						<form:option value="">--Select--</form:option>
						<form:option value="DEV">DEV</form:option>
					  	<form:option value="QA">QA</form:option>
					  	<form:option value="BSA">BSA</form:option>
					</form:select>
				</div>
			</div>
			<input type="submit" value="Update" class="btn btn-success"/>	 	
			</form:form>
		</div>
	</div>
</div>
</body>
</html>