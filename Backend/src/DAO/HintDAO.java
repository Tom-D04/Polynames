package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.polyNamesDatabase;
import models.Hint;

import webserver.WebServerContext;

public class HintDAO {

    private polyNamesDatabase database;
    
    public HintDAO() {
        try {
            this.database = new polyNamesDatabase("localhost", 3306, "poly_names", "root", "");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
    }

    public void updateHint(String hint, int cards_number) {

        try {
            if (!isHintInDatabase(hint)) {
                PreparedStatement statement = this.database.prepareStatement("UPDATE hint SET hintValue = ?, cards_number = ? WHERE id = ?");
                statement.setString(1, hint);
                statement.setInt(2, cards_number);
                statement.setInt(3, 1);
                System.out.println("Indice mis à jour");
                statement.executeUpdate();
                
                System.out.println("Indice mis à jour");
            } else {
                System.out.println("L'indice est déjà présent dans la base de données de cartes");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'indice");
            e.printStackTrace();
        }
    }
    
    private boolean isHintInDatabase(String hint) {
        try {
            String[] words = hint.split("\\s+"); //Divise la phrase en mots
            PreparedStatement statement = this.database.prepareStatement("SELECT COUNT(*) FROM cards WHERE word IN (?)");

            for (String word : words) {
                statement.setString(1, word);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count > 0) {
                    return false; //Si un mot est trouvé dans la base de données, retourne false
                }
            }

            return true; //Si aucun mot n'est trouvé dans la base de données, retourne true
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification de l'indice dans la base de données de cartes");
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<Hint> getHint() {
        ArrayList<Hint> hints = new ArrayList<Hint>();
        try {
            PreparedStatement statement = this.database.prepareStatement("SELECT * FROM `hint` WHERE id = ?");
            statement.setInt(1, 1);
            var result = statement.executeQuery();
            while (result.next()) {
                hints.add(new Hint(result.getInt("id"), result.getString("value"), result.getInt("cards_number")));
                
            }

            return hints;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'indice dao");
            e.printStackTrace();
            return null;
        }
    }

}
