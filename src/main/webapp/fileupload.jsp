<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form > *{
		margin-top : 20px;
		font-size : 24px;
	}
</style>
</head>
<body>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<label>Select a image</label><br/>
		<input type="file" name="u-img"><br/>
		<input type="submit" value="Upload" name="btn-submit">
	</form>
</body>
</html>