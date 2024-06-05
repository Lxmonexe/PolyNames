package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Carte;
import models.Dictionnaire;

public class DictionnairesDAO {

    public DictionnairesDAO(){

    }

    public ArrayList<Dictionnaire> findAll(){
        ArrayList<Dictionnaire> mots = new ArrayList<>();

        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("SELECT * FROM dictionnaire;");
            ResultSet resultSet = preparedStatement.executeQuery();
        
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String mot = resultSet.getString("mot");
                
                Dictionnaire dict = new Dictionnaire(id, mot);
                mots.add(dict);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return mots;
    }
}
