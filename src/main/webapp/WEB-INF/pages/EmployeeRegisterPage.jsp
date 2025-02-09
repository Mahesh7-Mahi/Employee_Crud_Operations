<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<h3>WELCOME TO EMPLOYEE REGISTER PAGE</h3>
		</div>
		<div class="card-body">
			<form action="save" method="post">
			<div class="row">
				<div class="col-2">
					NAME
				</div>
				<div class="col-4">
					<input type="text" name="ename" class="form-control">
				</div>
			</div>
					 	
			<div class="row">
				<div class="col-2">
					EMAIL
				</div>
				<div class="col-4">
					<input type="text" name="email" class="form-control">
				</div>
			</div>
						
			<div class="row">
				<div class="col-2">
					SALARY
				</div>
				<div class="col-4">
					<input type="text" name="esal" class="form-control">
				</div>
			</div>
						
					
			<div class="row">
				<div class="col-2">
					DEPT
				</div>
				<div class="col-4">
					<select name="edept" class="form-control">
						<option>--Select--</option>
						<option value="DEV">DEV</option>
				  		<option value="QA">QA</option>
				  		<option value="BSA">BSA</option>
					</select>
				</div>
			</div>
					 	
			<input type="submit" value="Add Employee" class="btn btn-success">
			
			</form>
		</div>
	</div>
</div>


<p>
${msg }
</p>
</body>
</html>