package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PolyNamesDatabase;
import models.Joueur;
import models.Participer;
import models.Partie;

public class ParticipersDAO {

    public ParticipersDAO(){

    }

    public void create(Participer participer) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "INSERT INTO `participer` (`idJoueur`, `idPartie`, `role`, `score`) VALUES (?, ?, ?, ?);";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, participer.get_idJoueur().get_id());
            stmt.setInt(2, participer.get_idPartie().get_id());
            stmt.setString(3, participer.get_role());
            stmt.setInt(4, participer.get_score());
            stmt.execute();
        }
    }

    public Participer findById(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "SELECT * FROM `participer` WHERE `id` = ?;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    JoueurDAO joueurDAO = new JoueurDAO();
                    PartieDAO partieDAO = new PartieDAO();

                    Joueur joueur = joueurDAO.findById(rs.getInt("idJoueur"));
                    Partie partie = partieDAO.findById(rs.getInt("idPartie"));

                    return new Participer(rs.getInt("id"), joueur, partie, rs.getString("role"), rs.getInt("score"));                
                }
            }
        }
        return null;
    }

    public List<Participer> findAll() throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        List<Participer> participations = new ArrayList<>();
        String query = "SELECT * FROM `participer`;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            JoueurDAO joueurDAO = new JoueurDAO();
            PartieDAO partieDAO = new PartieDAO();

            while (rs.next()) {
                Joueur joueur = joueurDAO.findById(rs.getInt("idJoueur"));
                Partie partie = partieDAO.findById(rs.getInt("idPartie"));
                
                participations.add(new Participer(rs.getInt("id"), joueur, partie, rs.getString("role"), rs.getInt("score")));
            }
        }
        return participations;
    }

    public void update(Participer participer) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "UPDATE `participer` SET `idJoueur` = ?, `idPartie` = ?, `role` = ?, `score` = ? WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, participer.get_idJoueur().get_id());
            stmt.setInt(2, participer.get_idPartie().get_id());
            stmt.setString(3, participer.get_role());
            stmt.setInt(4, participer.get_score());
            stmt.setInt(5, participer.get_id());
            stmt.execute();
        }
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "DELETE FROM `participer` WHERE `id` = ?;";
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
