package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import database.polyNamesDatabase;
import models.Card;

public class CardsDAO {
    private polyNamesDatabase database;

    public CardsDAO() {
        try {
            this.database = new polyNamesDatabase("localhost", 3306, "poly_names", "TOM", "123");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
    }

    public void initialize_cards() {
        reset_cards();
        try {
            var statement = this.database.prepareStatement("INSERT INTO card (word, color, state) VALUES (?, ?, ?)");
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            List<String> wordList = new ArrayList<>();
            String line;
            String[] colors = {"bleu", "noir", "blanc"};
            Random rand = new Random();

            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }

            for (int i = 0; i < 25; i++) {
                if (reader.readLine() != null) {
                    int randomWordIndex = rand.nextInt(400);
                    statement.setString(1, wordList.get(randomWordIndex));
                    statement.setString(2, colors[rand.nextInt(colors.length)]);
                    statement.setBoolean(3, true);
                    statement.executeUpdate();
                    wordList.remove(randomWordIndex); //On retire les lignes déjà utilisées pour éviter les doublons
                }
            }
            reader.close();

        } catch (SQLException | IOException e) {
        System.out.println("Erreur lors de l'initialisation des cartes");
        e.printStackTrace();
        }
    }

    public void reset_cards() {
        try {
            var statement = this.database.prepareStatement("DELETE FROM card");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la réinitialisation des cartes");
            e.printStackTrace();
        }
    }

    public ArrayList<Card> findAll() {
        ArrayList<Card> cards = new ArrayList<Card>();
        try {
            var statement = this.database.prepareStatement("SELECT * FROM card");
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

    public void updateState(String word, boolean state) {
        try {
            var statement = this.database.prepareStatement("UPDATE card SET state = ? WHERE word = ?");
            statement.setBoolean(1, state);
            statement.setString(2, word);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'état de la carte");
            e.printStackTrace();

        }
    }

}