<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style type="text/css">
		table,td,th,tr{
			border:1px solid grey;
			border-collapse: collapse;
		}
		table{
			width: 50%;
			margin: auto;
			background: lightgreen;
			
		}
		tr,th,td{
			padding: 8px;
		}
		td{
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
	<tr>
		<td>${emp.id}</td>
		<td>${emp.name}</td>
		<td>${emp.sal}</td>
	</tr>
</table>

</body>
</html>