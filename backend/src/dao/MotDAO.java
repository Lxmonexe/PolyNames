package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PolyNamesDatabase;
import models.Mot;

public class MotDAO {

    public MotDAO() {

    }

    /**
     * Surement à retirer
     * @param mot
     * @throws SQLException
     */
    public void create(Mot mot) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "INSERT INTO `mot` (`texte`) VALUES (?);";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, mot.get_texte());
            stmt.execute();
        }
    }

    public Mot findById(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "SELECT * FROM `mot` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Mot(rs.getInt("id"), rs.getString("texte"));
                }
            }
        }
        return null;
    }

    public List<Mot> findAll() throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        List<Mot> mots = new ArrayList<>();
        String query = "SELECT * FROM `mot`;";
        try (PreparedStatement stmt = pbd.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                mots.add(new Mot(rs.getInt("id"), rs.getString("texte")));
            }
        }
        return mots;
    }

    public void update(Mot mot) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "UPDATE `mot` SET `texte` = ? WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, mot.get_texte());
            stmt.setInt(2, mot.get_id());
            stmt.execute();
        }
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "DELETE FROM `mot` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
