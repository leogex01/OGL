<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<style>

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Edit Country</title>
</head>
<body>
<div>
<form  action= "editCountryServlet"method="post">
Country: <input type ="text"name = "country"value= "${itemToEdit.country}">
Capital: <input type = "text"name = "capital"value= "${itemToEdit.capital}">
Language: <input type = "text"name = "language"value= "${itemToEdit.language}">
<input type = "hidden"name = "id"value="${itemToEdit.id}">
<input type = "submit"value="Save Edited Item">
</form>
</div>

</body>
</html>