package com.example.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seuapp.util.DBUtil;

@WebServlet(name = "AlterarContatoServlet", urlPatterns = { "/AlterarContatoServlet" })
public class AlterarContatoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String novoNome = request.getParameter("novoNome");
        String novoEmail = request.getParameter("novoEmail");
        String novoTelefone = request.getParameter("novoTelefone");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "UPDATE Contatos SET nome=?, email=?, telefone=? WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, novoEmail);
            preparedStatement.setString(3, novoTelefone);
            preparedStatement.setInt(4, Integer.parseInt(id));

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Atualização bem-sucedida
                System.out.println("Contato alterado com sucesso!");
            } else {
                // Falha na atualização
                System.out.println("Falha ao alterar o contato.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirecionar de volta para a página de listagem de contatos
        response.sendRedirect(request.getContextPath() + "/ListarContatosServlet");
    }
}

	
