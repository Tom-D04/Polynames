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

        //cardsController.initializeCards();
        webserver.getRouter().post(
            "/creategame",
            (WebServerContext context) -> { gameController.createGame(context); }
        );
        webserver.getRouter().get(
            "/getcards",
            (WebServerContext context) -> { cardsController.findAll(context); }
        );
        webserver.getRouter().get(
            "/cardColor/:cardWord",
            (WebServerContext context) -> { cardsController.findColorByWord(context); }
        );

        webserver.getRouter().get(
            "/hint",
            (WebServerContext context) -> { hintController.getHint(context); }
        );

        webserver.getRouter().post(
            "/flipcard",
            (WebServerContext context) -> { cardsController.flipCard(context); }
        );

        webserver.getRouter().post(
            "/updatehint",
            (WebServerContext context) -> { hintController.updateHint(context); }
        );

        webserver.getRouter().get(
            "/gameRound/:authentication_code",
            (WebServerContext context) -> { gameController.getTurn(context); }
        );




        
    }
}