package Controller;

import DAO.GameDAO;
import models.Game;

public class GameController {
    GameDAO gameDAO = new GameDAO();
    public GameController() {
        
    }
    public void createGame() {
        Game newGame = new Game(0, 0, 0, "Pseudo1", "Pseudo1");
        try {
            gameDAO.createGame(newGame);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de la partie");
            e.printStackTrace();
        }
    }

    public void updateScore() {
        
        try {
            gameDAO.updateScore(1, 0);
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du score");
            e.printStackTrace();
        }
    }

}
