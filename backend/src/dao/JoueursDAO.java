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
            int id_role = result.getInt("id_role");
            
            Joueur joueur = new Joueur(id, id_role);
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
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM joueur WHERE carte.id = ?");
            test.setInt(1, idJoueur);
            ResultSet result = test.executeQuery();

            if(result.next()){
                int id = result.getInt("id");
                int id_role = result.getInt("id_role");
                
                joueur = new Joueur(id, id_role);
            }

        
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return joueur;
    }
}
