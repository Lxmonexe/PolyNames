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

    public void create(Joueur joueur) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "INSERT INTO `joueur` (`pseudo`) VALUES (?);";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, joueur.get_pseudo());
            stmt.execute();
        }
    }

    public Joueur findById(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
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
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
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
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "UPDATE `joueur` SET `pseudo` = ? WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, joueur.get_pseudo());
            stmt.setInt(2, joueur.get_id());
            stmt.execute();
        }
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "DELETE FROM `joueur` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
