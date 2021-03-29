<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style type="text/css">
table, td, th, tr {
	border: 1px solid grey;
	border-collapse: collapse;
}

table {
	width: 50%;
	margin: auto;
}

tr:nth-child(odd){
	background: grey;
}
tr, th, td {
	padding: 8px;
}

td {
	text-align: center;
}
</style>
</head>
<body>

	<table>
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Salary</th>
		</tr>

		<c:forEach items="${emplist}" var="emp">
		<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
			</tr>
		
		</c:forEach>
	</table>

</body>
</html>