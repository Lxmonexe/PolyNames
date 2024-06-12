import controllers.GrilleController;
import controllers.JoueurController;
import controllers.ParticiperController;
import controllers.PartieController;
// import dao.GrilleDAO;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        // CartesDAO cartesDAO = new CartesDAO();
        // cartesDAO.create();

        // GrilleDAO grilleDAO = new GrilleDAO();
        // grilleDAO.create("#2c5b");


        webServer.getRouter().post("/partie/code/:partieid/", (WebServerContext context) -> { PartieController.createPartie(context); });
        webServer.getRouter().post("/partie/creer/joueur/:partieid/:pseudo/:role", (WebServerContext context) -> { JoueurController.createJoueur(context); ParticiperController.createParticipant(context); });
        webServer.getRouter().put("/partie/code/grille/:partieid/", (WebServerContext context) -> { GrilleController.create(context); });
        // webServer.getRouter().get("/partie/:code", (WebServerContext context) -> { ParticiperController.getRoleById(context);}); //fonctionne
        // webServer.getRouter().get("/partie/:code:/:joueurid/", (WebServerContext context) -> { ParticiperController.getRoleById(context);}); //fonctionne
        // webServer.getRouter().get("/partie/:code/:joueurid/:role", (WebServerContext context) -> { GrilleController.findAll(context);}); //fonctionne
        
        // webServer.getRouter().get("/mots", (WebServerContext context) -> { MotController.findAll(context);}); //fonctionne
    }
}
