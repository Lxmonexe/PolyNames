package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.PolyNamesDatabase;
import models.Grille;
import models.Mot;
import models.Partie;

public class GrilleDAO {

    public GrilleDAO(){
        
    }

    public void create(Grille grille) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "INSERT INTO `grille` (`idPartie`, `idMot`, `couleur`) VALUES (?, ?, ?);";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, grille.get_idPartie().get_id());
            stmt.setInt(2, grille.get_idMot().get_id());
            stmt.setString(3, grille.get_couleur());
            stmt.execute();
        }
    }

    public Grille findById(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "SELECT * FROM `grille` WHERE `id` = ?;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PartieDAO partieDAO = new PartieDAO();
                    MotDAO motDAO = new MotDAO();

                    Partie partie = partieDAO.findById(rs.getInt("idPartie"));
                    Mot mot = motDAO.findById(rs.getInt("idMot"));

                    return new Grille(rs.getInt("id"), partie, mot, rs.getString("couleur"));
                }
            }
        }
        return null;
    }

    public List<Grille> findAll() throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        List<Grille> grilles = new ArrayList<>();
        String query = "SELECT * FROM `grille`;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            PartieDAO partieDAO = new PartieDAO();
            MotDAO motDAO = new MotDAO();

            while (rs.next()) {
                Partie partie = partieDAO.findById(rs.getInt("idPartie"));
                Mot mot = motDAO.findById(rs.getInt("idMot"));

                grilles.add(new Grille(rs.getInt("id"), partie, mot, rs.getString("couleur")));
            }
        }
        return grilles;
    }

    public void update(Grille grille) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "UPDATE `grille` SET `idPartie` = ?, `idMot` = ?, `couleur` = ? WHERE `id` = ?;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, grille.get_idPartie().get_id());
            stmt.setInt(2, grille.get_idMot().get_id());
            stmt.setString(3, grille.get_couleur());
            stmt.setInt(4, grille.get_id());
            stmt.execute();
        }
    }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
        String query = "DELETE FROM `grille` WHERE `id` = ?;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
