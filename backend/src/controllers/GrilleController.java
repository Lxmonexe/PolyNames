package controllers;

import java.sql.SQLException;

import dao.GrilleDAO;
import webserver.WebServerContext;

public class GrilleController {

    public static void findAll(WebServerContext context){
        GrilleDAO grilleDAO = new GrilleDAO();
        try {
            context.getResponse().json(grilleDAO.findAll());
        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
