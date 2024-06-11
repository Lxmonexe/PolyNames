// package dao;

// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Random;

// import database.PolyNamesDatabase;
// import models.Grille;
// import models.Mot;
// import models.Partie;

// public class GrilleDAO {

//     public GrilleDAO(){
        
//     }

//     //coucou
//     public void create(String partieCode) throws SQLException {
//         PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
//         List<Mot> mots = new ArrayList<>();
//         ArrayList<String> couleurs = new ArrayList<>();
//         Partie partie = null;
//         String query = "INSERT INTO `grille` (`idPartie`, `idMot`, `couleur`) VALUES (?, ?, ?);";
        
//         String query2 = "SELECT `partie`.`id` FROM `grille` \r\n" + //
//                         "INNER JOIN `partie` ON `partie`.`id` = `grille`.`idPartie` \r\n" + //
//                         "WHERE `partie`.`code` = ?";

//         try (PreparedStatement stmt = pbd.prepareStatement(query2)) {
//             stmt.setString(1, partieCode);
//             try (ResultSet rs = stmt.executeQuery()) {
//                 if (rs.next()) {
//                     PartieDAO partieDAO = new PartieDAO();
//                     partie = partieDAO.findById(rs.getInt("idPartie"));
//                 }
//             }
//         }

//         MotDAO motDAO = new MotDAO();
//         mots = motDAO.findAll();

//         Collections.shuffle(mots, new Random());
//         mots.subList(0, 25);

//         for (int i = 0; i < 8; i++) couleurs.add("bleu");
//         for (int i = 0; i < 15; i++) couleurs.add("gris");
//         for (int i = 0; i < 2; i++) couleurs.add("noir");

//         Collections.shuffle(couleurs, new Random());
        
//         try (PreparedStatement stmt = pbd.prepareStatement(query)) {
//             for(int i = 0; i < 25; i++){
//                 stmt.setInt(1, partie.get_id());
//                 stmt.setInt(2, mots.get(i).get_id());
//                 stmt.setString(3, couleurs.get(i));
//                 stmt.execute();
//             }
            
//         }
//     }

//     public Grille findById(int id) throws SQLException {
//         PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
//         String query = "SELECT * FROM `grille` WHERE `id` = ?;";
        
//         try (PreparedStatement stmt = pbd.prepareStatement(query)) {    
//             stmt.setInt(1, id);
//             try (ResultSet rs = stmt.executeQuery()) {
//                 if (rs.next()) {
//                     PartieDAO partieDAO = new PartieDAO();
//                     MotDAO motDAO = new MotDAO();

//                     Partie partie = partieDAO.findById(rs.getInt("idPartie"));
//                     Mot mot = motDAO.findById(rs.getInt("idMot"));

//                     return new Grille(rs.getInt("id"), partie, mot, rs.getString("couleur"));
//                 }
//             }
//         }
//         return null;
//     }

//     public List<Grille> findAll() throws SQLException {
//         PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
//         List<Grille> grilles = new ArrayList<>();
//         String query = "SELECT * FROM `grille`;";
        
//         try (PreparedStatement stmt = pbd.prepareStatement(query);
//              ResultSet rs = stmt.executeQuery()) {
            
//             PartieDAO partieDAO = new PartieDAO();
//             MotDAO motDAO = new MotDAO();

//             while (rs.next()) {
//                 Partie partie = partieDAO.findById(rs.getInt("idPartie"));
//                 Mot mot = motDAO.findById(rs.getInt("idMot"));

//                 grilles.add(new Grille(rs.getInt("id"), partie, mot, rs.getString("couleur")));
//             }
//         }
//         return grilles;
//     }

//     public void update(Grille grille) throws SQLException {
//         PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
//         String query = "UPDATE `grille` SET `idPartie` = ?, `idMot` = ?, `couleur` = ? WHERE `id` = ?;";
        
//         try (PreparedStatement stmt = pbd.prepareStatement(query)) {
//             stmt.setInt(1, grille.get_idPartie().get_id());
//             stmt.setInt(2, grille.get_idMot().get_id());
//             stmt.setString(3, grille.get_couleur());
//             stmt.setInt(4, grille.get_id());
//             stmt.execute();
//         }
//     }

//     public void delete(int id) throws SQLException {
//         PolyNamesDatabase pbd = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
//         String query = "DELETE FROM `grille` WHERE `id` = ?;";
        
//         try (PreparedStatement stmt = pbd.prepareStatement(query)) {
//             stmt.setInt(1, id);
//             stmt.execute();
//         }
//     }
// }
