<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alterar Contato</title>
</head>
<body>
    <h2>Alterar Contato</h2>
    <form action="AlterarContatoServlet" method="post">
        ID: <input type="text" name="id" readonly value="${contato.id}"><br>
        Novo Nome: <input type="text" name="novoNome" value="${contato.nome}" required><br>
        Novo Email: <input type="email" name="novoEmail" value="${contato.email}" required><br>
        Novo Telefone: <input type="text" name="novoTelefone" value="${contato.telefone}"><br>
        <input type="submit" value="Alterar Contato">
    </form>
    <br>
    <a href="ListarContatosServlet">Listar Contatos</a>
</body>
</html>
