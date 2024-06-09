import controllers.MotController;
import dao.GrilleDAO;
import dao.MotDAO;
import models.Mot;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        // CartesDAO cartesDAO = new CartesDAO();
        // cartesDAO.create();

        GrilleDAO grilleDAO = new GrilleDAO();
        grilleDAO.create(1);


        webServer.getRouter().get("/mots", (WebServerContext context) -> { MotController.findAll(context);}); //fonctionne
        // webServer.getRouter().get("/grille", (WebServerContext context) -> { MotController.findAll(context);}); //fonctionne

        
        // webServer.getRouter().get("/create-polynames-or-join-polynames", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        // webServer.getRouter().get("/polynames/role", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        // webServer.getRouter().get("/polynames/lord-of-words", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        // webServer.getRouter().get("/polynames/lord-of-intuitions", (WebServerContext context) -> { DictionnairesController.findAll(context);});
    }
}
