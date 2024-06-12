package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PolyNamesDatabase;
import models.Joueur;

public class JoueurDAO {
    public JoueurDAO() {

    }

    public void create(String pseudo) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "INSERT INTO `joueur` (`pseudo`) VALUES (?);";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, pseudo);
            stmt.execute();
        }
    }

    public int getIdJoueurByPseudo(String pseudo) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        int idJoueur = 0;
        String query = "SELECT `id` FROM `joueur`WHERE `pseudo`= ?";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, pseudo);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    idJoueur = rs.getInt("id");
                    return idJoueur;
                }
            }
        }
        return idJoueur;
    }

    public Joueur findById(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "SELECT * FROM `joueur` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Joueur(rs.getInt("id"), rs.getString("pseudo"));
                }
            }
        }
        return null;
    }

    public List<Joueur> findAll() throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        List<Joueur> joueurs = new ArrayList<>();
        String query = "SELECT * FROM `joueur`;";
        try (PreparedStatement stmt = pbd.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                joueurs.add(new Joueur(rs.getInt("id"), rs.getString("pseudo")));
            }
        }
        return joueurs;
    }

    public void update(Joueur joueur) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "UPDATE `joueur` SET `pseudo` = ? WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, joueur.get_pseudo());
            stmt.setInt(2, joueur.get_id());
            stmt.execute();
        }
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "DELETE FROM `joueur` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
