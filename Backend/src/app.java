import Controller.CardsController;
import Controller.GameController;
import Controller.HintController;
import webserver.WebServerContext;
import webserver.WebServer;

public class app {
    public static void main(String[] args) throws Exception {
        WebServer webserver = new WebServer();
        webserver.listen(8081);
        CardsController cardsController = new CardsController();
        GameController gameController = new GameController();
        HintController hintController = new HintController();

        cardsController.initializeCards();
        webserver.getRouter().get(
            "/getcards",
            (WebServerContext context) -> { cardsController.findAll(context); }
        );
        webserver.getRouter().get(
            "/cardColor/:cardWord",
            (WebServerContext context) -> { cardsController.findColorByWord(context); }
        );

        webserver.getRouter().post(
            "/flipcard/:cardWord",
            (WebServerContext context) -> { cardsController.flipCard(context); }
        );

        webserver.getRouter().post(
            "/updateHint/:authentication_code",
            (WebServerContext context) -> { hintController.updateHint(context); }
        );

        webserver.getRouter().get(
            "/gameRound/:authentication_code",
            (WebServerContext context) -> { gameController.getTurn(context); }
        );

        
    }
}