package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/annonce-detail")
public class DetailAnnonceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try (Connection connection = DBConnection.getConnection()) {
            AnnonceDAO dao = new AnnonceDAO(connection);
            Annonce annonce = dao.getAnnonceById(id);
            request.setAttribute("annonce", annonce);
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}