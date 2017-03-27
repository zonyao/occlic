<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TCEQ Confirm Page</title>
</head>
<body>
<div class="container"> 
	<h2>Confirm</h2>
	<p>Please input you Confirm Code(${email_address})</p>
	<form action="./confirm" method="post">
	    <input type="text" name="email" value="${email_address}" style="display: none;">
	    <table>
	    <tr class="form-group">
		<td><input type="text" length="5" name="comfirmcode" id="comfirmcode" class="form-control"></td>
		<td><input type="submit" value="Go" class="btn btn-primary" style="margin-left: 10px"></td>
		</tr>
		</table>
	</form>
</div>
</body>
</html>