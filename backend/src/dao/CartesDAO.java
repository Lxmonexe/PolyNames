package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Carte;

public class CartesDAO {

    public CartesDAO(){

    }

    public ArrayList<Carte> findAll(){
        ArrayList<Carte> cartes = new ArrayList<>();

        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM carte;");
            ResultSet result = test.executeQuery();
        
        while(result.next()){
            int id = result.getInt("id");
            String mot = result.getString("mot");
            int id_type = result.getInt("id_type");
            
            Carte carte = new Carte(id, mot, id_type);
            cartes.add(carte);
        }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return cartes;
    }

    public Carte findById(int idCarte){
        Carte carte = null;
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM carte WHERE carte.id = ?");
            test.setInt(1, idCarte);
            ResultSet result = test.executeQuery();

            if(result.next()){
                int id = result.getInt("id");
                String mot = result.getString("mot");
                int id_type = result.getInt("id_type");
                
                carte = new Carte(id, mot, id_type);
            }

        
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return carte;
    }
}
