package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import database.PolyNamesDatabase;
import models.Grille;
import models.Mot;
import models.Partie;

public class GrilleDAO {

    public GrilleDAO(){
        
    }

    //coucou
    public void create(String idPartie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        List<Mot> mots = new ArrayList<>();
        ArrayList<String> couleurs = new ArrayList<>();

        String query = "INSERT INTO `grille` (`idPartie`, `idMot`, `couleur`, `decouvert`) VALUES (?, ?, ?, ?);";

        MotDAO motDAO = new MotDAO();
        mots = motDAO.findAll();

        Collections.shuffle(mots, new Random());
        mots.subList(0, 25);

        for (int i = 0; i < 8; i++) couleurs.add("bleu");
        for (int i = 0; i < 15; i++) couleurs.add("gris");
        for (int i = 0; i < 2; i++) couleurs.add("noir");

        Collections.shuffle(couleurs, new Random());
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            for(int i = 0; i < 25; i++){
                stmt.setString(1, idPartie);
                stmt.setInt(2, mots.get(i).get_id());
                stmt.setString(3, couleurs.get(i));
                stmt.setBoolean(4, false);
                stmt.execute();
            }
            
        }
    }

    // public Grille findById(int id) throws SQLException {
    //     PolyNamesDatabase pbd = new PolyNamesDatabase();
    //     String query = "SELECT * FROM `grille` WHERE `id` = ?;";
        
    //     try (PreparedStatement stmt = pbd.prepareStatement(query)) {    
    //         stmt.setInt(1, id);
    //         try (ResultSet rs = stmt.executeQuery()) {
    //             if (rs.next()) {
    //                 PartieDAO partieDAO = new PartieDAO();
    //                 MotDAO motDAO = new MotDAO();

    //                 Partie partie = partieDAO.findById(rs.getInt("idPartie"));
    //                 Mot mot = motDAO.findById(rs.getInt("idMot"));

    //                 return new Grille(rs.getInt("id"), partie, mot, rs.getString("couleur"));
    //             }
    //         }
    //     }
    //     return null;
    // }

    public ArrayList<String> findAll(String idPartie) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        ArrayList<String> mots = new ArrayList<>();
        String query = "SELECT `mot`.`texte` AS m FROM `grille` INNER JOIN `mot` ON `mot`.`id` = `grille`.`idMot` WHERE `idPartie` = ?;";


        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setString(1, idPartie);
            try (ResultSet rs = stmt.executeQuery()) {
                
                while (rs.next()) {
                    mots.add(rs.getString("m"));
                }
            }
        }
        return mots;
    }

    // public List<Grille> findAll(String idPartie) throws SQLException {
    //     PolyNamesDatabase pbd = new PolyNamesDatabase();
    //     List<Grille> grilles = new ArrayList<>();
    //     String query = "SELECT `mot`.`texte` FROM `grille` INNER JOIN `partie` ON WHERE `idPartie` = ?;";
    //     String query = "SELECT `mot`.`texte` FROM `grille` INNER JOIN `mot` ON `mot`.`id` = `grille`.`idMot` WHERE `idPartie` = ?;"

    //     try (PreparedStatement stmt = pbd.prepareStatement(query)) {
    //         stmt.setString(1, idPartie);
    //         try (ResultSet rs = stmt.executeQuery()) {
    //             MotDAO motDAO = new MotDAO();
                
    //             while (rs.next()) {
    //                 Mot mot = motDAO.findById(rs.getInt("idMot"));

    //                 grilles.add(new Grille(rs.getInt("id"),idPartie, mot.get_id(), rs.getString("couleur"), rs.getBoolean("decouvert")));
    //             }
    //         }
    //     }
    //     return grilles;
    // }

    public void delete(int id) throws SQLException {
        PolyNamesDatabase pbd = new PolyNamesDatabase();
        String query = "DELETE FROM `grille` WHERE `id` = ?;";
        
        try (PreparedStatement stmt = pbd.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
