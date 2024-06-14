import Controller.CardsController;
import webserver.WebServerContext;
import webserver.WebServer;

public class app {
    public static void main(String[] args) throws Exception {
        WebServer webserver = new WebServer();
        webserver.listen(8081);
        CardsController controller = new CardsController();

        controller.initializeCards();
        webserver.getRouter().get(
            "/getcards",
            (WebServerContext context) -> { controller.findAll(context); }
        );
        webserver.getRouter().get(
            "/cardColor/:cardWord",
            (WebServerContext context) -> { controller.findColorByWord(context); }
        );

        webserver.getRouter().post(
            "/flipcard",
            (WebServerContext context) -> { controller.flipCard(context); }
        );

        webserver.getRouter().get(
            "/getcards",
            (WebServerContext context) -> { controller.findAll(context); }
        );
        
    }
}