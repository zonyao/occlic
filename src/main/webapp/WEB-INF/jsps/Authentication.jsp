<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Authentication</title>
<style type="text/css">
.reminder_message {
	font-size: small;
	color: red;
}
</style>
</head>
<body>
	<div id="container" style="margin-left:400px ">
		<h2>Authentication</h2>
		<p>
			If you are administrator ,Fill your administrator email address. <br>A
			confirm email will be send to you.
		<p>
		<h3 class="reminder_message">${message}</h3>
		<form action="./configEmail" method="post">
			<table>
				<tr class="form-group">
					<td><input type="email" name="email" class="form-control" size="30"></td>
					<td><input type="submit" value="Send" class="btn btn-primary" style="margin-left: 10px"></td>					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>