package DAO;

import java.sql.SQLException;

import database.polyNamesDatabase;
import models.Hint;

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

    public void newHint(Hint hint) {
        try {
            
            var statement = this.database.prepareStatement("INSERT INTO hint (id, hint, cards) VALUES (?, ?, ?)");
            statement.setInt(1, hint.id());
            statement.setString(2, hint.value());
            statement.setInt(3, hint.cards_number());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de l'indice");
            e.printStackTrace();
        }
    }




}
