package Controller;

import webserver.WebServerContext;

import DAO.HintDAO;
import DAO.GameDAO;
import models.Hint;

public class HintController {

    HintDAO dao = new HintDAO();
    GameDAO gameDAO = new GameDAO();

    public HintController() {
        
    }
    public void updateHint(WebServerContext context) {
        int code = Integer.parseInt(context.getRequest().getParam("authentication_code"));
        code = 1;
        try {      
            dao.updateHint(context);
            gameDAO.nextTurn(code);
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de l'indice");
            e.printStackTrace();
        }
    }

    public Hint getHint() {
        try {
            Hint hint = dao.getHint();
            return hint;
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de l'indice");
            e.printStackTrace();
        }
        return null;   
    }

}
