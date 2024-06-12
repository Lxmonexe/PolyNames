package controllers;

import java.sql.SQLException;

import dao.JoueurDAO;
import dao.ParticiperDAO;
import webserver.WebServerContext;

public class JoueurController {

    public static void createJoueur(WebServerContext context){
        JoueurDAO joueurDAO = new JoueurDAO();
        try {
            joueurDAO.create(context.getRequest().getParam("pseudo"));
            context.getResponse().ok("Joueur inséré dans la bdd");
        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
