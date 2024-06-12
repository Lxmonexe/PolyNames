package controllers;

import java.sql.SQLException;

import dao.GrilleDAO;
// import dao.GrilleDAO;
import webserver.WebServerContext;

public class GrilleController {


    public static void create(WebServerContext context){
        GrilleDAO grilleDAO = new GrilleDAO();
        try {
            grilleDAO.create(context.getRequest().getParam("partieid"));
            context.getResponse().ok("Grille créée");
        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }

    public static void getGrille(WebServerContext context){
        GrilleDAO grilleDAO = new GrilleDAO();
        try {
            context.getResponse().json(grilleDAO.findAll(context.getRequest().getParam("partieid")));

        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
