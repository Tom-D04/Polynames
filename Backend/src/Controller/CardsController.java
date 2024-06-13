package Controller;

import java.util.ArrayList;

import DAO.CardsDAO;
import models.Card;
import webserver.WebServerContext;

public class CardsController {
    CardsDAO dao = new CardsDAO();

    public CardsController() {
        
    }
    public ArrayList<Card> findAll(WebServerContext context) {
        
        ArrayList<Card> cards = new ArrayList<Card>();
        try {
            cards = dao.findAll();
            context.getResponse().json(cards);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des cartes");
            e.printStackTrace();
        }
        return cards;

    } 


    public void initializeCards(WebServerContext context) {
        try {
            dao.initializeCards();
            context.getResponse().json("Cartes initialisées");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'initialisation des cartes");
            e.printStackTrace();
        }
    }

    public void updateState(WebServerContext context) {
        try {
            String word = context.getRequest().getParam("word");
            
            dao.updateState(word, false);
            context.getResponse().json("Carte mise à jour");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de l'état de la carte");
            e.printStackTrace();
        }
    }
}
