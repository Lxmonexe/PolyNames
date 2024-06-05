package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Carte;
import models.Joueur;

public class PartiesDAO {

    public void create(Joueur joueur, ArrayList<Carte> cartes) {

        try {
            PolyNamesDatabase polyBayDatabase = new PolyNamesDatabase("localhost", 33006, "poly_names", "root", "");
            PreparedStatement preparedStatement = polyBayDatabase.prepareStatement("INSERT INTO partie (code, score, id_joueur , id_carte) values (111, 0, ?, ?);");
            preparedStatement.setInt(1, joueur.get_id());
            
            // à vérifier avec un prof
            for (Carte carte : cartes) {
                preparedStatement.setInt(2, carte.get_id());
                preparedStatement.execute();
            }
            

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }

}
