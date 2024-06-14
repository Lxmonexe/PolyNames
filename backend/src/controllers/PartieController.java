package controllers;

import dao.PartieDAO;
import webserver.WebServerContext;


public class PartieController {

    public static void createPartie(WebServerContext context){
        PartieDAO partieDAO = new PartieDAO();
        try {
            partieDAO.create(context.getRequest().getParam("partieid"));
            context.getResponse().ok("partie créée");
        } catch (Exception e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }

    public static void getPartie(WebServerContext context){
        PartieDAO partieDAO = new PartieDAO();
        try {
            partieDAO.findById(context.getRequest().getParam("partieid"));
            context.getResponse().ok("Cette partie existe bien");
        } catch (Exception e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }

    public static void existePartie(WebServerContext context){
        PartieDAO partieDAO = new PartieDAO();
        Boolean existePartie = false;
        try {
            existePartie = partieDAO.existPartie(context.getRequest().getParam("partieid"));
            if(existePartie){
                context.getResponse().ok("Cette partie existe");
            }
            else{
                context.getResponse().notFound("Cette partie n'existe pas");;
            }
        } catch (Exception e) {
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
    }
}
