package controllers;

import java.sql.SQLException;
import dao.ParticiperDAO;
import webserver.WebServerContext;


public class ParticiperController {

     public static void createParticipant(WebServerContext context){
        ParticiperDAO participerDAO = new ParticiperDAO();
        try {
            participerDAO.createParticipant(context.getRequest().getParam("partieid"), context.getRequest().getParam("pseudo").toString(), context.getRequest().getParam("role").toString());
            context.getResponse().ok("Participant inséré dans la bdd");
        } catch (SQLException e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }

    public static void updateScore(WebServerContext context){
        try {
            ParticiperDAO participerDAO = new ParticiperDAO();
            participerDAO.updateScore(context.getRequest().getParam("partieid"), Integer.parseInt(context.getRequest().getParam("score")));
            context.getResponse().ok("Score mis à jour");
        } catch (Exception e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }

    public static int getScore(WebServerContext context){
        try {
            ParticiperDAO participerDAO = new ParticiperDAO();
            return participerDAO.getScore(context.getRequest().getParam("partieid"));
        } catch (Exception e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
        return 0;
    }

    public static void updateRole(WebServerContext context){
        try {
            ParticiperDAO participerDAO = new ParticiperDAO();
            participerDAO.updateRole(context.getRequest().getParam("partieid"), context.getRequest().getParam("pseudo").toString(), context.getRequest().getParam("role").toString());
            context.getResponse().ok("Role mis à jour");
        } catch (Exception e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }   
}
