<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<br>
		<div class="row">
			<div class="col md-6">
				<form action="existing-user" method="post">
					<div class="form-group">
						<h5>Login (Existing Users)</h5>
						<label for="loginEmail">Email address</label> <input type="email"
							class="form-control" id="loginEmail" aria-describedby="emailHelp"
							placeholder="Enter email" name="email">
					</div>
					<div class="alert alert-warning" role="alert" id="emailAlert"
						style="display: none">${badEmailCredential}</div>
					<div class="form-group">
						<label for="loginPassword">Password</label> <input type="password"
							class="form-control" id="loginPassword" placeholder="Password"
							name="password">
					</div>
					<div class="alert alert-warning" role="alert" id="passAlert"
						style="display: none">${badPassCredential}</div>
					<button type="submit" class="btn btn-primary">Log In</button>
				</form>
			</div>
			<div class="col md-6">
				<form action="new-user" method="post">
					<div class="form-group">
						<h5>Register (New Users)</h5>
						<label for="registerEmail">Email address</label> <input
							type="email" class="form-control" id="registerEmail"
							aria-describedby="emailHelp" placeholder="Enter email"
							name="email"> <small id="emailHelp"
							class="form-text text-muted">We'll never share your email
							with anyone else.</small>
							<div class="alert alert-warning" role="alert" id="emailInUse"
						style="display: none">${emailInUse}</div>
					</div>
					<div class="form-group">
						<label for="registerPassword">Password</label> <input
							type="password" class="form-control" id="registerPassword"
							placeholder="Password" name="password">
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
				</form>
			</div>
		</div>
	</div>
	<script src="indexscript.js"></script>
</body>
</html>