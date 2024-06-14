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


    public void initializeCards() {
        try {
            dao.initializeCards();
        } catch (Exception e) {
            System.err.println("Erreur lors de l'initialisation des cartes");
            e.printStackTrace();
        }
    }

    public void flipCard(WebServerContext context) {
        try {
            String word = context.getRequest().getParam("word");
            dao.flipCard(word, false);


            context.getResponse().json("Carte mise à jour");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de l'état de la carte");
            e.printStackTrace();
        }
    }

    public void findColorByWord(WebServerContext context) {
        try {
            String word = context.getRequest().getParam("word");
            word = "Australie";
            String color = dao.findColorByWord(word);
            context.getResponse().json(color);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération de la carte");
            e.printStackTrace();
        }
    }
}
