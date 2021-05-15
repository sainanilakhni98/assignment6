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
  <h2>Search for your flight <c:out value="${name } "></c:out></h2>
  <form action="search">
    <div class="form-group">
      <label for="deploc">Departure location :</label>
      <input type="text" class="form-control" id="deploc" placeholder="Ex: DEL(Delhi)" name="deploc" required>
    </div>
    <div class="form-group">
      <label for="arrloc">Arrival location :</label>
      <input type="text" class="form-control" id="arrloc" placeholder="Ex: MUB(Mumbai)" name="arrloc" required>
    </div>
    <div class="form-group">
      <label for="date">Date :</label>
      <input type="text" class="form-control" id="date" placeholder="DD/MM/YY" name="date" required>
    </div>
    <div class="form-group">
      <label for="cls">Enter class preferred:</label>
      <input type="text" class="form-control" id="cls" placeholder="(E/B)" name="cls" required>
    </div>
    <div class="form-group">
      <label for="outpre">Enter output preferred:</label>
      <input type="text" class="form-control" id="outpre" placeholder="price/duration" name="outpre">
    </div>
    
    <button type="submit" class="btn btn-default">Search</button>
  </form>
</div>

</body>
</html>