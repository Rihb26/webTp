package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO {
    private Connection connection;

    public AnnonceDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Annonce> getAllAnnonces() throws SQLException {
        List<Annonce> annonces = new ArrayList<>();
        String query = "SELECT * FROM annonces";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Annonce annonce = new Annonce();
            annonce.setId(rs.getInt("id"));
            annonce.setTitre(rs.getString("titre"));
            annonce.setDescription(rs.getString("description"));
            annonce.setPrix(rs.getDouble("prix"));
            annonces.add(annonce);
        }
        return annonces;
    }

    public Annonce getAnnonceById(int id) throws SQLException {
        String query = "SELECT * FROM annonces WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Annonce annonce = new Annonce();
            annonce.setId(rs.getInt("id"));
            annonce.setTitre(rs.getString("titre"));
            annonce.setDescription(rs.getString("description"));
            annonce.setPrix(rs.getDouble("prix"));
            return annonce;
        }
        return null;
    }
}

