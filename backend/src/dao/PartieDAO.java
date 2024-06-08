package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PolyNamesDatabase;
import models.Posseder;
import models.Participer;
import models.Partie;

public class PartieDAO {

    public PartieDAO(){

    }

    public void create(Partie partie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "INSERT INTO `partie` (`code`) VALUES (?);";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, partie.get_code());
            stmt.execute();
        }
    }

    public Partie findById(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "SELECT * FROM `partie` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Partie(rs.getInt("id"), rs.getString("code"));
                }
            }
        }
        return null;
    }

    public List<Partie> findAll() throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        List<Partie> parties = new ArrayList<>();
        String query = "SELECT * FROM `partie`;";
        try (PreparedStatement stmt = pbd.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                parties.add(new Partie(rs.getInt("id"), rs.getString("code")));
            }
        }
        return parties;
    }

    public void update(Partie partie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "UPDATE `partie` SET `code` = ? WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, partie.get_code());
            stmt.setInt(2, partie.get_id());
            stmt.execute();
        }
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "DELETE FROM `partie` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

}
