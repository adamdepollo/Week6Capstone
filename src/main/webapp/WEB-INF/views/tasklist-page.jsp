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
	<link rel = "stylesheet" href="main.css">
</head>
<body>
	<div class="container">
		<br>
		<div class="row">
			<div class="col-lg-5">
				<a class="btn btn-dark" data-toggle="collapse"
					href="#addCollapse" role="button" aria-expanded="false"
					aria-controls="addCollpase">Add Task</a>
			</div>
			<div class="col-lg-5">
				<a class="btn btn-dark" data-toggle="collapse"
					href="#searchCollapse" role="button" aria-expanded="false"
					aria-controls="searchCollapse">Search For Tasks</a>
			</div>
			<div class="col-lg-2">
				<a href="/?loginAttempt=0" class="btn btn-dark">Log Out</a>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form action="add-task" class="collapse" id="addCollapse"
					method="post">
					<br> <input type="hidden" name="userid" value="${user.userid}">
					<input type="hidden" name="complete" value="false">
					<div class="form-group">
						<label for="taskDescription">Task Description</label>
						<textarea class="form-control" id="taskDescription" rows="3"
							name="description"></textarea>
					</div>
					<div class="form-group">
						<label for="dueDate">Due Date</label> <input type="date"
							class="form-control" id="dueDate" name="dueDate">
					</div>
					<button type="submit" class="btn btn-dark">Submit</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form action="search-task" class="collapse" id="searchCollapse"
					method="post">
					<br> <input type="hidden" name="userid" value="${user.userid}">
					<div class="form-group">
						<label for="taskDescription">Task Description</label>
						<textarea class="form-control" id="taskDescription" rows="3"
							name="description"></textarea>
					</div>
					<button type="submit" class="btn btn-dark">Submit</button>
				</form>
			</div>
		</div>
		<br>
		<div class="alert alert-warning" role="alert" id="emptySearchAlert"
						style="display: none">${emptySearchAlert}</div>
		<br> <span id="length" style="display: none">${taskList.size()}</span>
		<div class="row">
			<table class="table" id="dtOrder">
				<thead>
					<tr>
						<th>No.</th>
						<th>Description</th>
						<th><a href="/${sortDateUrl}?userid=${user.userid}&sortCompleteUrl=${sortCompleteUrl}" class="sort-by">Due Date</a></th>
						<th><a href="/${sortCompleteUrl}?userid=${user.userid}&sortDateUrl=${sortDateUrl}" class="sort-by">Complete?</a></th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${taskList}" varStatus="i">
						<tr>
							<th>${i.count}</th>
							<td>${t.description}</td>
							<td>${t.dueDate}</td>
							<td><form action="mark-complete" method="post">
									<input type="hidden" name="taskid" value="${t.taskid}">
									<div id="comp${i.count}">${t.complete}</div>
								</form></td>
							<td><a class="btn btn-dark" data-toggle="collapse"
								href="#collapseUpdate${i.count}" role="button"
								aria-expanded="false" aria-controls="collapseUpdate${i.count}">Update
									Task</a>
								<form action="update-task" class="collapse"
									id="collapseUpdate${i.count}" method="post">
									<br> <input type="hidden" name="userid"
										value="${user.userid}"> <input type="hidden"
										name="taskid" value="${t.taskid}"> <input
										type="hidden" name="complete" value="false">
									<div class="form-group">
										<label for="taskDescription">Task Description</label>
										<textarea class="form-control" id="taskDescription" rows="3"
											name="description" placeholder="${t.description}"></textarea>
									</div>
									<div class="form-group">
										<label for="dueDate">Due Date</label> <input type="date"
											class="form-control" id="dueDate" name="dueDate"
											value="${t.dueDate}">
									</div>
									<button type="submit" class="btn btn-dark">Submit</button>
								</form></td>
							<td><a href="/delete-task?taskid=${t.taskid}"
								class="btn btn-dark">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="/existing-user?userid=${user.userid}" class="btn btn-dark">Clear Search Criteria</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="script.js"></script>
</body>
</html>