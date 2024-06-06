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

    public Dictionnaire findById(int idDictionnaire){
        Dictionnaire dictionnaire = null;
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM dictionnaire WHERE dictionnaire.id = ?");
            test.setInt(1, idDictionnaire);
            ResultSet result = test.executeQuery();

            if(result.next()){
                int id = result.getInt("id");
                String mot = result.getString("mot");
                
                dictionnaire = new Dictionnaire(id, mot);
            }

        
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return dictionnaire;
    }
}
