<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Contatos</title>
</head>
<body>
    <h2>Listar Contatos</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Ações</th>
        </tr>
        <c:forEach var="contato" items="${contatos}">
            <tr>
                <td>${contato.id}</td>
                <td>${contato.nome}</td>
                <td>${contato.email}</td>
                <td>${contato.telefone}</td>
                <td>
                    <a href="AlterarContatoServlet?id=${contato.id}">Alterar</a>
                    |
                    <a href="RemoverContatoServlet?id=${contato.id}">Remover</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="AdicionarContato.jsp">Adicionar Contato</a>
</body>
</html>
