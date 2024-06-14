package Controller;

import webserver.WebServerContext;

import DAO.HintDAO;
import DAO.GameDAO;

public class HintController {

    HintDAO dao = new HintDAO();
    GameDAO gameDAO = new GameDAO();

    public HintController() {
        
    }
    public void updateHint(WebServerContext context) {
        int code = Integer.parseInt(context.getRequest().getParam("authentication_code"));

        try {      
            dao.updateHint(context);
            gameDAO.nextTurn(code);
            int round = gameDAO.getTurn(context, code);
            context.getResponse().json(round);
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de l'indice");
            e.printStackTrace();
        }
    }
}
