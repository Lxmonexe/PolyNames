package controllers;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import dao.JoueurDAO;
import dao.ParticiperDAO;
// import dao.ParticiperDAO;
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

    // public static void updateRole(WebServerContext context) {
    //     try {
    //         ParticiperDAO participerDAO = new ParticiperDAO();
    //         participerDAO.updateRole(Integer.parseInt(context.getRequest().getParam("idPartie")), (context.getRequest().getParam("pseudo")));
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }

    // public static void getRoleById(WebServerContext context){
    //     try {
    //         ParticiperDAO participerDAO = new ParticiperDAO();
    //         context.getResponse().json(participerDAO.getRoleById(context.getRequest().getParam("code").toString(), Integer.parseInt(context.getRequest().getParam("joueurid"))));
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
    //     }
    // }

    
}
