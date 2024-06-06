import controllers.CartesController;
import controllers.DictionnairesController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        webServer.getRouter().get("/carte/", (WebServerContext context) -> { CartesController.findAll(context);});
        webServer.getRouter().post("/carte/create", (WebServerContext context) -> { CartesController.create(context);});
        webServer.getRouter().get("/dictionnaire", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        webServer.getRouter().get("/partie", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        webServer.getRouter().get("/joueur", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        webServer.getRouter().get("/role", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        
        webServer.getRouter().get("/create-polynames-or-join-polynames", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        webServer.getRouter().get("/polynames/role", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        webServer.getRouter().get("/polynames/lord-of-words", (WebServerContext context) -> { DictionnairesController.findAll(context);});
        webServer.getRouter().get("/polynames/lord-of-intuitions", (WebServerContext context) -> { DictionnairesController.findAll(context);});
    }
}
