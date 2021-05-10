<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.nagarro.site.model.User"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.nagarro.site.model.Image" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	width: inherit;
    border: 1px solid gray;
	padding: 10px;
	margin: 20px;
	
}

</style>
</head>
<body >
	<%
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("index.jsp");
		}
	%>
	<h2 style="color:solid gray;text-align:center; width: inherit; border: 1px solid gray;">Welcome <%out.println(session.getAttribute("username"));%> to Image Management Utility</h2>
	<div style="margin: 20px;">
	please select an image file to upload(Max. size 1MB)
	<br><br>
	<form action="imageservlet">
		Enter image link : <input type="text" name="imglink">
		<input type="submit" value="upload">    <input type="reset" value="cancel">
	
	</form>

	
	
</body>
</html>