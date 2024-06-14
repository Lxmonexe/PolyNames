import controllers.GrilleController;
import controllers.JoueurController;
import controllers.ParticiperController;
import controllers.PartieController;
// import dao.GrilleDAO;
import webserver.WebServer;
import webserver.WebServerContext;
import webserver.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        // CartesDAO cartesDAO = new CartesDAO();
        // cartesDAO.create();

        // GrilleDAO grilleDAO = new GrilleDAO();
        // grilleDAO.create("#2c5b");


        webServer.getRouter().post("/partie/code/:partieid", (WebServerContext context) -> { PartieController.createPartie(context); });
        webServer.getRouter().post("/partie/creer/joueur/:partieid/:pseudo/:role", (WebServerContext context) -> { JoueurController.createJoueur(context); ParticiperController.createParticipant(context); });
        webServer.getRouter().post("/partie/code/creer/grille/:partieid", (WebServerContext context) -> { GrilleController.create(context); });
        webServer.getRouter().put("/partie/code/grille/:partieid", (WebServerContext context) -> { GrilleController.getGrille(context); });
        webServer.getRouter().post("/partie/creer/nouvelle-partie/:partieid/:pseudo/:role", (WebServerContext context) -> {ParticiperController.createParticipant(context); });

        webServer.getRouter().post("/partie/code/score/:partieid/:score", (WebServerContext context) -> { 
            ParticiperController.updateScore(context); 
            int score = ParticiperController.getScore(context);
            webServer.getSSE().emit("score", "{ \"scorePartie\": \"" + score + "\" }");
        });

        webServer.getRouter().post("/partie/indice/:mot/:nbcarte", (WebServerContext context) -> { 
            WebServerResponse response = context.getResponse();
            String mot = context.getRequest().getParam("mot");
            String nbcarte = context.getRequest().getParam("nbcarte");
            webServer.getSSE().emit("indice", "{ \"mot\": \"" + mot + "\", \"nbcarte\": \"" + nbcarte + "\" }");
            response.ok("Indice envoyé");
         });

         webServer.getRouter().post("/partie/tour-suivant", (WebServerContext context) -> { 
            WebServerResponse response = context.getResponse();
            webServer.getSSE().emit("tourSuivant", "{}");
            response.ok("Tour suivant");
         });

         webServer.getRouter().post("/partie/fin-partie/:idpartie/:statut", (WebServerContext context) -> { 
            WebServerResponse response = context.getResponse();
            String statutFin = context.getRequest().getParam("statut");
            int score = ParticiperController.getScore(context);
            webServer.getSSE().emit("finPartie", "{ \"statutFin\": \"" + statutFin + "\",\"scorePartie\": \"" + score + "\"}");
            response.ok("Fin de la partie");
         });

         webServer.getRouter().post("/partie/role/:partieid/:pseudo/:role/:numeroJoueur", (WebServerContext context) -> { 
            ParticiperController.updateRole(context);
            String role = context.getRequest().getParam("role");
            String pseudo = context.getRequest().getParam("pseudo");
            String numeroJoueur = context.getRequest().getParam("numeroJoueur"); 
            webServer.getSSE().emit("role", "{ \"role\": \"" + role + "\", \"pseudo\": \"" + pseudo + "\", \"numeroJoueur\": \"" + numeroJoueur + "\" }");
         });
        // webServer.getRouter().get("/partie/:code", (WebServerContext context) -> { ParticiperController.getRoleById(context);}); //fonctionne
        // webServer.getRouter().get("/partie/:code:/:joueurid/", (WebServerContext context) -> { ParticiperController.getRoleById(context);}); //fonctionne
        // webServer.getRouter().get("/partie/:code/:joueurid/:role", (WebServerContext context) -> { GrilleController.findAll(context);}); //fonctionne
        
        // webServer.getRouter().get("/mots", (WebServerContext context) -> { MotController.findAll(context);}); //fonctionne
    }
}
