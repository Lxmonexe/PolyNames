package controllers;

import webserver.WebServerContext;
import dao.CartesDAO;

public class CartesController {
    
    public static void findAll(WebServerContext context){
        CartesDAO cartesDAO = new CartesDAO();
        context.getResponse().json(cartesDAO.findAll());
    }

    public static void create(WebServerContext context){
        CartesDAO cartesDAO = new CartesDAO();
        cartesDAO.create();
        context.getResponse().ok("Carte created");
    }
}
