package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/annonces")
public class ListeAnnonceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DBConnection.getConnection()) {
            AnnonceDAO dao = new AnnonceDAO(connection);
            List<Annonce> annonces = dao.getAllAnnonces();
            request.setAttribute("annonces", annonces);
            request.getRequestDispatcher("liste.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

