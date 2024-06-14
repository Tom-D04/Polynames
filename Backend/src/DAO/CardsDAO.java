package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import database.polyNamesDatabase;
import models.Card;
import DAO.GameDAO;

public class CardsDAO {
    private polyNamesDatabase database;

    public CardsDAO() {
        try {
            this.database = new polyNamesDatabase("localhost", 3306, "poly_names", "root", "");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
    }

    public void initializeWords() throws IOException {
        try {
            PreparedStatement statement = this.database.prepareStatement("INSERT INTO words (word) VALUES (?)");
            BufferedReader reader = new BufferedReader(new FileReader("src/words.txt"));
            String line = reader.readLine();
            while (line != null) {
                statement.setString(1, line);
                statement.executeUpdate();
                line = reader.readLine();
            }
            reader.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'initialisation des mots");
            e.printStackTrace();

        }
    }


    public void initializeCards() {
        reset_cards();
        try {
            PreparedStatement statement_insert = this.database.prepareStatement("INSERT INTO card (word, color, state) VALUES (?, ?, ?)");
            String updateQuery = "SELECT word FROM words";
            PreparedStatement statementUpdate = this.database.prepareStatement(updateQuery);
            ArrayList<String> wordList = new ArrayList<>();
            String[] colors = {"blue", "black", "grey"};
            int[] colorCounts = {0, 0, 0}; // Compteurs pour bleu, noir et gris respectivement
            Random rand = new Random();
    
            
            ResultSet result = statementUpdate.executeQuery();
            while (result.next()) {
                wordList.add(result.getString("word"));
            }
    
            for (int i = 0; i < 25; i++) {
                if (!wordList.isEmpty()) {
                    int randomColorIndex;
                    do {
                        randomColorIndex = rand.nextInt(colors.length);
                    } while ((randomColorIndex == 0 && colorCounts[0] >= 8) ||
                            (randomColorIndex == 1 && colorCounts[1] >= 2) || 
                            (randomColorIndex == 2 && colorCounts[2] >= 15));
    
                    int randomWordIndex = rand.nextInt(wordList.size());
                    statement_insert.setString(1, wordList.get(randomWordIndex));
                    statement_insert.setString(2, colors[randomColorIndex]);
                    statement_insert.setBoolean(3, true);
                    statement_insert.executeUpdate();
                    wordList.remove(randomWordIndex); 
                    colorCounts[randomColorIndex]++; // On incrémente le compteur de la couleur choisie
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'initialisation des cartes");
            e.printStackTrace();
        }
    }

    public void reset_cards() {
        try {
            PreparedStatement statement = this.database.prepareStatement("DELETE FROM card");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la réinitialisation des cartes");
            e.printStackTrace();
        }
    }

    public ArrayList<Card> findAll() {
        ArrayList<Card> cards = new ArrayList<Card>();
        try {
            PreparedStatement statement = this.database.prepareStatement("SELECT * FROM card");
            var result = statement.executeQuery();

            while (result.next()) {
                cards.add(new Card(
                    result.getString("word"),
                    result.getString("color"),
                    result.getBoolean("state")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des cartes");
            e.printStackTrace();
        }

        return cards;
        
    }

    public String findColorByWord(String word) {
        try {
            PreparedStatement statement = this.database.prepareStatement("SELECT * FROM card WHERE word = ?");
            statement.setString(1, word);
            var result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("word"));
                System.out.println(result.getString("color"));
                System.out.println(result.getBoolean("state"));
                return result.getString("color");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la carte");
            e.printStackTrace();
        }
        
        return ""; 
    }


    public void flipCard(String word, boolean state) {
        try {
            PreparedStatement statement = this.database.prepareStatement("UPDATE card SET state = ? WHERE word = ?");
            statement.setBoolean(1, state);
            statement.setString(2, word);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'état de la carte");
            e.printStackTrace();

        }
    }

}