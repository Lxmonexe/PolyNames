package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import database.PolyNamesDatabase;
import models.Joueur;
import models.Participer;
import models.Partie;

public class ParticiperDAO {

    public ParticiperDAO() {

    }

    public void createParticipant(int idPartie, String pseudoJoueur) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "INSERT INTO `participer` (`idJoueur`, `idPartie`, `role`, `score`) VALUES (?, ?, ?, ?);";
        ArrayList<String> roles = new ArrayList<>();
        JoueurDAO joueurDAO = new JoueurDAO();

        roles.add("MDM");
        roles.add("MDI");

        Collections.shuffle(roles, new Random());

        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, joueurDAO.getIdJoueurByPseudo(pseudoJoueur));
            stmt.setInt(2, idPartie);
            stmt.setString(3, roles.get(1));
            stmt.setInt(4, 0);
            stmt.execute();
        }
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
    private String getAvailableRole(int idPartie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "SELECT COUNT(*) AS count FROM `participer` WHERE `idPartie` = ? AND (`role` = 'MDM' OR `role` = 'MDI');";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, idPartie);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int mdmCount = rs.getInt("count");
                    if (mdmCount == 0) {
                        return "MDM";
                    } else {
                        return "MDI";
                    }
                }
            }
        }
        return null;
    }
    
        // public List<Participer> findAll() throws SQLException {
    //     PolyNamesDatabase pbd = new PolyNamesDatabase();
    //     List<Participer> participations = new ArrayList<>();
    //     String query = "SELECT * FROM `participer`;";

    //     try (PreparedStatement stmt = pbd.prepareStatement(query);
    //             ResultSet rs = stmt.executeQuery()) {

    //         JoueurDAO joueurDAO = new JoueurDAO();
    //         PartieDAO partieDAO = new PartieDAO();

    //         while (rs.next()) {
    //             Joueur joueur = joueurDAO.findById(rs.getInt("idJoueur"));
    //             Partie partie = partieDAO.findById(rs.getInt("idPartie"));

    //             participations.add(new Participer(rs.getInt("id"), joueur, partie, rs.getString("role"), rs.getInt("score")));
    //         }
    //     }
    //     return participations;
    // }

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
