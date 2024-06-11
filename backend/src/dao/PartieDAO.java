package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PolyNamesDatabase;
import models.Partie;

public class PartieDAO {

    public PartieDAO(){

    }

    public void create(String idPartie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "INSERT INTO `partie` (`id`) VALUES (?);";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, idPartie);
            stmt.execute();
        }
    }

    public Partie findById(String idPartie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "SELECT * FROM `partie` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, idPartie);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Partie(rs.getString("id"));
                }
            }
        }
        return null;
    }

    // public List<Partie> findAll() throws SQLException {
    //     PolyNamesDatabase pbd = new PolyNamesDatabase();
    //     List<Partie> parties = new ArrayList<>();
    //     String query = "SELECT * FROM `partie`;";
    //     try (PreparedStatement stmt = pbd.prepareStatement(query);
    //          ResultSet rs = stmt.executeQuery()) {
    //         while (rs.next()) {
    //             parties.add(new Partie(rs.getString("id")));
    //         }
    //     }
    //     return parties;
    // }


    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "DELETE FROM `partie` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

}
