package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.PolyNamesDatabase;

public class ParticiperDAO {

    public ParticiperDAO() {

    }

    public void createParticipant(String idPartie, String pseudoJoueur, String role) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "INSERT INTO `participer` (`idJoueur`, `idPartie`, `role`, `score`) VALUES (?, ?, ?, ?);";
        JoueurDAO joueurDAO = new JoueurDAO();
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, joueurDAO.getIdJoueurByPseudo(pseudoJoueur));
            stmt.setString(2, idPartie);
            stmt.setString(3, role);
            stmt.setInt(4, 0);
            stmt.execute();
        }
    }

    public void updateScore(String codePartie, int score) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "UPDATE `participer` JOIN `partie` ON `partie`.`id` = `participer`.`idPartie` SET `participer`.`score` = ? WHERE `partie`.`id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, score);
            stmt.setString(2, codePartie);
            stmt.execute();
        }
    }

    public void updateRole(String idPartie, String pseudo, String role) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "UPDATE `participer` JOIN `joueur` ON `participer`.`idJoueur` = `joueur`.`id` JOIN `partie` ON `participer`.`idPartie` = `partie`.`id` SET `participer`.`role` = ? WHERE `joueur`.`pseudo` = ? AND `partie`.`id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, role);
            stmt.setString(2, pseudo);
            stmt.setString(3, idPartie);
            stmt.execute();
        }
    }

    public String getRoleById(String codePartie, int idJoueur) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "SELECT `participer`.`role` FROM `participer` JOIN `joueur` ON `participer`.`idJoueur` = `joueur`.`id` JOIN `partie` ON `participer`.`idPartie` = `partie`.`id` WHERE `joueur`.`id` = ? AND `partie`.`code` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, idJoueur);
            stmt.setString(2, codePartie);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                return role;
            }
        }
        return null;
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "DELETE FROM `participer` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    public int getScore(String idPartie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "SELECT `score` FROM `participer` WHERE `idPartie` = ?;";
        int score = 0;
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, idPartie);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    score += rs.getInt("score");
                }
            }
        }
        score = score / 2;
        return score;
    }
}
