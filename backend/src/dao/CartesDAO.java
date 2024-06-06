package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import database.PolyNamesDatabase;
import models.Carte;
import models.Dictionnaire;
import models.Type;

public class CartesDAO {

    public CartesDAO() {

    }

    public ArrayList<Carte> findAll() {
        ArrayList<Carte> cartes = new ArrayList<>();
        DictionnairesDAO dictionnairesDAO = new DictionnairesDAO();
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM carte;");
            ResultSet result = test.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int id_dictionaire = result.getInt("id_dictionaire");
                int id_type = result.getInt("id_type");

                Dictionnaire dictionnaire = dictionnairesDAO.findById(id_dictionaire);

                Carte carte = new Carte(id, dictionnaire, id_type);
                cartes.add(carte);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return cartes;
    }

    public Carte findById(int idCarte) {
        Carte carte = null;
        DictionnairesDAO dictionnairesDAO = new DictionnairesDAO();
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM carte WHERE carte.id = ?");
            test.setInt(1, idCarte);
            ResultSet result = test.executeQuery();

            int id = result.getInt("id");
            int id_dictionnaire = result.getInt("id_dictionnaire");
            int id_type = result.getInt("id_type");

            Dictionnaire dictionnaire = dictionnairesDAO.findById(id_dictionnaire);
            carte = new Carte(id, dictionnaire, id_type);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return carte;
    }

    public void create(){
        DictionnairesDAO dictionnairesDAO = new DictionnairesDAO();
        TypesDAO typesDAO = new TypesDAO();
        ArrayList<Type> types = new ArrayList<>();
        ArrayList<Integer> ids_type = new ArrayList<>();
        Integer rand_id_type;
        ArrayList<Dictionnaire> mots = new ArrayList<>();
        ArrayList<Integer> ids_dictionnaire = new ArrayList<>();
        Integer rand_id_dictionnaire;
        
        try {
            mots = dictionnairesDAO.findAll();
            types = typesDAO.findAll();

            for (Dictionnaire mot : mots) {
                ids_dictionnaire.add(mot.get_id());
            }

            for (Type type : types) {
                ids_type.add(type.get_id());
            }

            Random rand = new Random();
            
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("INSERT INTO carte (id_type, id_dictionnaire) VALUES (?, ?);");
            
            for(int i = 0; i < 25; i++){
                rand_id_dictionnaire = ids_dictionnaire.get(rand.nextInt(ids_dictionnaire.size()));
                rand_id_type = ids_type.get(rand.nextInt(ids_type.size()));
                
                preparedStatement.setInt(1, rand_id_type);
                preparedStatement.setInt(2, rand_id_dictionnaire);
                preparedStatement.addBatch();
            }

            preparedStatement.execute();    
        
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }

    public void delete() {
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("DELETE * FROM carte");
            preparedStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
}
