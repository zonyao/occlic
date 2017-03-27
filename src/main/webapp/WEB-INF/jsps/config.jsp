<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.container input {
	size: 300px;
}
</style>
<title>tceqola config</title>
</head>
<body>
	<div class="container" style="margin-left: auto; margin-right: auto;">
		<h2>Tceqola Config</h2>
		<form action="./configSubmit" method="post">
			<table data-toggle="table">
				<!-- Email conf -->

				<c:forEach items="${emails}" var="conf">
					<tr class="form-group">
						<td class="control-label">${conf.key}</td>
						<td width="300px"><input class="form-control" type="text"
							name="${conf.key}" value="${conf.value}"></td>
						<td>
							<p class="text-info"><small> ${explanations[conf.key]} </small></p>
						</td>
					</tr>
				</c:forEach>

				<!-- Files -->
				<c:forEach items="${files}" var="conf">
					<tr class="form-group">
						<td class="control-label">${conf.key}</td>
						<td width="300px"><input class="form-control" type="text"
							name="${conf.key}" value="${conf.value}"></td>
						<td>
							<p class="text-info"><small> ${explanations[conf.key]} </small></p>
						</td>
					</tr>
				</c:forEach>

				<c:forEach items="${license}" var="conf">
					<tr class="form-group">
						<td class="control-label">${conf.key}</td>
						<td width="300px"><input class="form-control" type="text"
							name="${conf.key}" value="${conf.value}"></td>
						<td>
							<p class="text-info"><small> ${explanations[conf.key]} </small></p>
						</td>
					</tr>
				</c:forEach>
				<tr align="center" height="60px">
					<td colspan="2"><input type="submit" value="Update"
						class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>