<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Informe os dados para login</h1>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>Nome</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Senha</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
</body>
</html>