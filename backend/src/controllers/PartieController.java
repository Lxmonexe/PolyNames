package controllers;

import java.security.SecureRandom;
import java.sql.SQLException;

import dao.PartieDAO;
import webserver.WebServerContext;

public class PartieController {

    private static final String HEX_CHARACTERS = "0123456789ABCDEF";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void createPartie(WebServerContext context){
        PartieDAO partieDAO = new PartieDAO();
        try {
            partieDAO.create(context.getRequest().getParam("partieid"));
            context.getResponse().ok("partie créée");
        } catch (Exception e) {
            // TODO: handle exception
            context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
        }
        
    }

    private static String generateHexCode(int length) {
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(HEX_CHARACTERS.charAt(RANDOM.nextInt(HEX_CHARACTERS.length())));
        }
        return "#" + code.toString();
    }
}
