package Controller;

import webserver.WebServerContext;

import DAO.HintDAO;

import java.util.ArrayList;

import DAO.GameDAO;
import models.Hint;

public class HintController {

    HintDAO dao = new HintDAO();
    GameDAO gameDAO = new GameDAO();

    public HintController() {
        
    }
    public void updateHint(WebServerContext context) {
        int code = 1;
        String hint = context.getRequest().getParam("hint");
        int cards_number = Integer.parseInt(context.getRequest().getParam("cards_number"));
        try {      
            dao.updateHint(hint, cards_number);
            gameDAO.nextTurn(code);
            context.getResponse().json("Carte mise à jour");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de l'indice");
            e.printStackTrace();
        }
    }

    public ArrayList<Hint> getHint(WebServerContext context) {
        
        ArrayList<Hint> hint = new ArrayList<Hint>();
        try {        
            hint = dao.getHint();
            context.getResponse().json(hint);
            
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de l'indice");
            e.printStackTrace();
        }
        return hint;  
    }

}
