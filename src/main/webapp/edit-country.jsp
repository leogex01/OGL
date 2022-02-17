<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Country</title>
</head>
<body>
<form action= "editCountryServlet"method="post">
Country: <input type ="text"name = "country"value= "${itemToEdit.country}">
Capital: <input type = "text"name = "capital"value= "${itemToEdit.capital}">
Language: <input type = "text"name = "language"value= "${itemToEdit.language}">
<input type = "hidden"name = "id"value="${itemToEdit.id}">
<input type = "submit"value="Save Edited Item">
</form>

</body>
</html>