package controllers;

import java.sql.SQLException;

import dao.GrilleDAO;
// import dao.GrilleDAO;
import webserver.WebServerContext;

public class GrilleController {


    public static void create(WebServerContext context){
        GrilleDAO grilleDAO = new GrilleDAO();
        try {
            grilleDAO.create(context.getRequest().getParam("id"));
            context.getResponse().json(grilleDAO.findAll(context.getRequest().getParam("id")));
            context.getResponse().ok("Grille ok");
        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
