package controllers;

import webserver.WebServerContext;
import dao.CartesDAO;

public class CartesController {
    
    public static void findAll(WebServerContext context){
        CartesDAO cartesDAO = new CartesDAO();
        context.getResponse().json(cartesDAO.findAll());
    }
}
