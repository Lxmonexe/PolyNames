package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import database.PolyNamesDatabase;
import models.Posseder;
import models.Dictionnaire;
import models.Type;

public class PossedersDAO {

    public PossedersDAO() {

    }

    public ArrayList<Posseder> findAll() {
        ArrayList<Posseder> posseders = new ArrayList<>();
        DictionnairesDAO dictionnairesDAO = new DictionnairesDAO();
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("SELECT * FROM `posseder`;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_dictionnaire = resultSet.getInt("id_dictionnaire");
                int id_type = resultSet.getInt("id_type");

                Dictionnaire dictionnaire = dictionnairesDAO.findById(id_dictionnaire);

                Posseder posseder = new Posseder(id, dictionnaire, id_type);
                posseders.add(posseder);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return posseders;
    }

    public Posseder findById(int idPosseder) {
        Posseder posseder = null;
        DictionnairesDAO dictionnairesDAO = new DictionnairesDAO();
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("SELECT * FROM `posseder` WHERE `posseder`.`id` = ?");
            preparedStatement.setInt(1, idPosseder);
            ResultSet resultSet = preparedStatement.executeQuery();

            int id = resultSet.getInt("id");
            int id_dictionnaire = resultSet.getInt("id_dictionnaire");
            int id_type = resultSet.getInt("id_type");

            Dictionnaire dictionnaire = dictionnairesDAO.findById(id_dictionnaire);
            posseder = new Posseder(id, dictionnaire, id_type);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return posseder;
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
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("INSERT INTO Posseder (id_type, id_dictionnaire) VALUES (?, ?);");
            
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
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("DELETE * FROM Posseder");
            preparedStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
}
