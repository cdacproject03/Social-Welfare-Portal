<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Form example with Java, Spring Boot, FreeMarker</title>
<link href="/css/login1.css" rel="stylesheet">
</head>
<body>
	<h2>Handling Form Submission example with Java, Spring Boot,
		FreeMarker</h2>
	<form action="/form" method="post">
		Name:<br> <input type="text" name="name"> <br>
		<br> Password:<br> <input type="text" name="password">
		<br>
		<br> 
		Type:<br> <select name="type">
			<option value="NGO">NGO</option>
			<option value="NEEDY">NEEDY</option>
			<option value="Volunteer">Volunteer</option>
			<option value="Admin">Admin</option>
		</select> <br>
		<br> <input type="submit" value="Submit">
	</form>
	<script src="/js/main.js"></script>
</body>
</html>