package Controller;

import java.util.ArrayList;

import DAO.CardsDAO;
import DAO.GameDAO;
import models.Card;
import webserver.WebServerContext;

public class CardsController {
    CardsDAO cardDao = new CardsDAO();
    GameDAO gameDAO = new GameDAO();

    public CardsController() {
        
    }
    public ArrayList<Card> findAll(WebServerContext context) {
        
        ArrayList<Card> cards = new ArrayList<Card>();
        try {
            cards = cardDao.findAll();
            context.getResponse().json(cards);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des cartes");
            e.printStackTrace();
        }
        return cards;

    } 


    public void initializeCards() {
        try {
            cardDao.initializeCards();
        } catch (Exception e) {
            System.err.println("Erreur lors de l'initialisation des cartes");
            e.printStackTrace();
        }
    }

    public void flipCard(WebServerContext context) {
        int n = Integer.parseInt(context.getRequest().getParam("flippedCardIndex"));
        int connexion_code = Integer.parseInt(context.getRequest().getParam("connexion_code"));
        try {
            String word = context.getRequest().getParam("word");
            cardDao.flipCard(word, 0);
            gameDAO.updateScore(word, n, connexion_code);

            context.getResponse().json("Carte mise à jour");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de l'état de la carte");
            e.printStackTrace();
        }
    }

    public void findColorByWord(WebServerContext context) {
        try {
            String word = context.getRequest().getParam("word");
            String color = cardDao.findColorByWord(word);
            context.getResponse().json(color);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de la carte");
            e.printStackTrace();
        }
    }
}
