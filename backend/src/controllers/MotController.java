package controllers;

import java.sql.SQLException;

import dao.MotDAO;
import webserver.WebServerContext;

public class MotController {

    public static void findAll(WebServerContext context){
        MotDAO motsDAO = new MotDAO();
        try {
            context.getResponse().json(motsDAO.findAll());
        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
