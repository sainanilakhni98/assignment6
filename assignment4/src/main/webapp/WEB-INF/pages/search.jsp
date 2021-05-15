<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
   <h2>Suitable flights for you <c:out value="${name } "></c:out></h2>
	
  <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Flight number</th>
      <th scope="col">Departure location</th>
      <th scope="col">Arrival location</th>
      <th scope="col">Flight time</th>
      <th scope="col">Flight duration</th>
      <th scope="col">Flight fare</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach items="${rows}" var="t">
  	  <tr>
      <td><c:out value="${t.flight_no}"></c:out></td>
      <td><c:out value="${t.dep_loc}"></c:out></td>
      <td><c:out value="${t.arr_loc}"></c:out></td>
      <td><c:out value="${t.flight_time}"></c:out></td>
      <td><c:out value="${t.flight_dur}"></c:out></td>
      <td><c:out value="${t.fare}"></c:out></td>
    </tr>
  	</c:forEach>

  </tbody>
</table>

</div>

</body>
</html>