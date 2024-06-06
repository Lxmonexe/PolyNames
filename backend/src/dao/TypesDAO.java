package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Type;

public class TypesDAO {

    public TypesDAO(){
        
    }

    public ArrayList<Type> findAll(){
        ArrayList<Type> types = new ArrayList<>();
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("SELECT * FROM type;");
            ResultSet result = preparedStatement.executeQuery();
        
        while(result.next()){
            int id = result.getInt("id");
            String couleur = result.getString("couleur");
            int nombre = result.getInt("nombre");
            
            Type type = new Type(id, couleur, nombre);
            types.add(type);
        }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return types;
    }

    public Type findById(int idType){
        Type type = null;
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("SELECT * FROM type WHERE type.id = ?");
            preparedStatement.setInt(1, idType);
            ResultSet result = preparedStatement.executeQuery();

            int id = result.getInt("id");
            String couleur = result.getString("couleur");
            int nombre = result.getInt("nombre");
            
            type = new Type(id, couleur, nombre);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return type;
    }
}
