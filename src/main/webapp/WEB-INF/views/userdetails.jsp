<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados do usu�rio</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/userdetails" method="get">
	<table style="with: 80%">
	    <tr>
	     <td>Primeiro Nome: </td>
	     <td><input type="text" name="firstName" value="${employee.getFirstName()}"></td>
	    </tr>
	    <tr>
	     <td>Sobrenome: </td>
	     <td><input type="text" name="lastName" value="${employee.getLastName()}"></td>
	    </tr>
	    <tr>
	     <td>Usu�rio: </td>
	     <td><input type="text" name="username" value="${employee.getUsername()}"></td>
	    </tr>
	    <tr>
	     <td>Endere�o: </td>
	     <td><input type="text" name="address" value="${employee.getAddress()}"></td>
	    </tr>
	    <tr>
	     <td>Contato: </td>
	     <td><input type="text" name="contact" value="${employee.getContact()}"></td>
	    </tr>
	   </table>
  </form>
</body>
</html>