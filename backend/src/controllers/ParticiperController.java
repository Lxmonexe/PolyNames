package controllers;

import java.util.concurrent.ExecutionException;

import dao.ParticiperDAO;
// import dao.ParticiperDAO;
import webserver.WebServerContext;

public class ParticiperController {


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

    // public static void updateRole(WebServerContext context){
    //     try {
    //         ParticiperDAO participerDAO = new ParticiperDAO();
    //         participerDAO.updateRole(context.getRequest().getParam("code").toString(), Integer.parseInt(context.getRequest().getParam("joueurid")), context.getRequest().getParam("role").toString());
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         context.getResponse().send(500, "Internal Server Error: " + e.getMessage());
    //     }
    // }
}
