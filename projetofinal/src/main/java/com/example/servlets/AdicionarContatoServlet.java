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

@WebServlet(name = "AdicionarContatoServlet", urlPatterns = {"/AdicionarContatoServlet"})
public class AdicionarContatoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT INTO Contatos (nome, email, telefone) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, telefone);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Inserção bem-sucedida
                System.out.println("Contato adicionado com sucesso!");
            } else {
                // Falha na inserção
                System.out.println("Falha ao adicionar o contato.");
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
