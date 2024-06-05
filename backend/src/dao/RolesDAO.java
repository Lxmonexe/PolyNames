package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Role;

public class RolesDAO {

    public RolesDAO(){

    }

    /**
     * FindAll
     * @return all words in dictionnary
     */
    public ArrayList<Role> findAll(){
        ArrayList<Role> roles = new ArrayList<>();

        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("SELECT * FROM role;");
            ResultSet resultSet = preparedStatement.executeQuery();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            
            Role role = new Role(id, nom);
            roles.add(role);
        }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return roles;
    }

}
