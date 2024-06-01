import controllers.CartesController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        webServer.getRouter().get("/cartes", (WebServerContext context) -> { CartesController.findAll(context);});

    }
}
