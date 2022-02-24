<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new Student List</title>
</head>
<body>
<form action = "createNewListServlet"method="post">
List Name: <input type ="text"name = "listName"><br />
Student Name: <input type = "text"name = "studentName"><br />
Available Countries: <br>
<select name="allCountriesToAdd">
 <c:forEach items="${requestScope.allItems}"var="currentcountry">
 <option value = "${currentitem.id}">${currentitem.country} | ${currentitem.capital} | ${currentitem.language}</option>
 </c:forEach></select><br />
 <input type = "submit"value="Create List and Add Items">
 </form>
 <a href = "index.html">Go add new items instead.</a>

</body>
</html>