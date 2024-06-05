package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Joueur;

public class JoueursDAO {

    public JoueursDAO(){

    }

    public ArrayList<Joueur> findAll(){
        ArrayList<Joueur> joueurs = new ArrayList<>();

        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM joueur;");
            ResultSet result = test.executeQuery();
        
        while(result.next()){
            int id = result.getInt("id");
            String pseudo = result.getString("pseudo");
            int id_role = result.getInt("id_role");
            
            Joueur joueur = new Joueur(id, pseudo, id_role);
            joueurs.add(joueur);
        }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return joueurs;
    }

    public Joueur findById(int idJoueur){
        Joueur joueur = null;
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM `joueur` WHERE `joueur`.`id`=?");
            test.setInt(1, idJoueur);
            ResultSet result = test.executeQuery();

            int id = result.getInt("id");
            String pseudo = result.getString("pseudo");
            int id_role = result.getInt("id_role");

            return new Joueur(id, pseudo, id_role);
                
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return joueur;
    }

    public void create(String pseudo, int id_role){
        try {
            PolyNamesDatabase polyNamesDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyNamesDatabase.prepareStatement("INSERT INTO `joueur` (`pseudo`, `id_role`) VALUES (? , ?);");
            preparedStatement.setString(1, pseudo);
            preparedStatement.setInt(1, id_role);
            preparedStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void update(Joueur joueur, int id_role){
        try {
            PolyNamesDatabase polyNamesDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyNamesDatabase.prepareStatement("UPDATE `joueur` SET `id_role`=? WHERE `id`=?;");
            preparedStatement.setInt(1, joueur.get_id_role());
            preparedStatement.setInt(2, joueur.get_id());
            preparedStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
