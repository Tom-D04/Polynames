package Controller;

import DAO.GameDAO;
import models.Game;
import webserver.WebServerContext;

public class GameController {
    GameDAO gameDAO = new GameDAO();
    public GameController() {
        
    }
    public void createGame(WebServerContext context) {
        Game newGame = new Game(0, 0, 0, "Pseudo1", "Pseudo2");
        try {
            gameDAO.createGame(context, newGame);
            context.getResponse().json("Partie créée");
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de la partie");
            e.printStackTrace();
        }
    }

    public void updateScore() {
        String word = "";
        try {
            gameDAO.updateScore(word, 1, 0);
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du score");
            e.printStackTrace();
        }
    }

    public void nextTurn() {
        try {
            gameDAO.nextTurn(0);
        } catch (Exception e) {
            System.err.println("Erreur lors du passage au tour suivant");
            e.printStackTrace();   
        }
    }

    public void getTurn(WebServerContext context) {
        int code = Integer.parseInt(context.getRequest().getParam("authentication_code")); 
        try {
            gameDAO.getTurn(context, code);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du tour");
            e.printStackTrace();    
        }
    }
}
