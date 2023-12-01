<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Contato</title>
</head>
<body>
    <h2>Adicionar Contato</h2>
    <form action="AdicionarContatoServlet" method="post">
        Nome: <input type="text" name="nome" required><br>
        Email: <input type="email" name="email" required><br>
        Telefone: <input type="text" name="telefone"><br>
        <input type="submit" value="Adicionar Contato">
    </form>
</body>
</html>
