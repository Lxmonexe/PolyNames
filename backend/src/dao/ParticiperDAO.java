package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Participer;

public class ParticiperDAO {

    public ParticiperDAO(){

    }

    public ArrayList<Participer> findAll(){
        ArrayList<Participer> participers = new ArrayList<>();
        
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM `participer`;");
            ResultSet result = test.executeQuery();
        
        while(result.next()){
            int id = result.getInt("id");
            String pseudo = result.getString("pseudo");
            int id_partie = result.getInt("id_partie");
            int id_role = result.getInt("id_role");
            
            Participer participer = new Participer(id, pseudo, id_partie,  id_role);
            participers.add(participer);
        }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

        return participers;
    }

    public Participer findById(int idParticiper){
        Participer participer = null;
        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement test = polyBayDatabase.prepareStatement("SELECT * FROM `participer` WHERE `participer`.`id`=?");
            test.setInt(1, idParticiper);
            ResultSet result = test.executeQuery();

            if(result.next()){
                int id = result.getInt("id");
                String pseudo = result.getString("pseudo");
                int id_partie = result.getInt("id_partie");
                int id_role = result.getInt("id_role");
            
                participer = new Participer(id, pseudo, id_partie, id_role);
            }
            
                
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return participer;
    }

    public void create(String pseudo, int id_partie, int id_role){
        try {
            PolyNamesDatabase polyNamesDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyNamesDatabase.prepareStatement("INSERT INTO `participer` (`pseudo`, `id_partie`, `id_role`) VALUES (? , ?, ?);");
            preparedStatement.setString(1, pseudo);
            preparedStatement.setInt(2, id_partie);
            preparedStatement.setInt(3, id_role);
            preparedStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void update(Participer participer, int id_role){
        try {
            PolyNamesDatabase polyNamesDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyNamesDatabase.prepareStatement("UPDATE `participer` SET `id_role`=? WHERE `id`=?;");
            preparedStatement.setInt(1, participer.get_id_role());
            preparedStatement.setInt(2, participer.get_id());
            preparedStatement.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
