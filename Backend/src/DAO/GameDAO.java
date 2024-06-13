package DAO;

import java.sql.SQLException;

import database.polyNamesDatabase;
import models.Game;

public class GameDAO {

    private polyNamesDatabase database;
    
    public GameDAO() {
        try {
            this.database = new polyNamesDatabase("localhost", 3306, "poly_names", "root", "");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
    }

    public void createGame(Game game) {
        try {
            var statement = this.database.prepareStatement("INSERT INTO game (score, connexion_code, spymaster, operative) VALUES (?, ?, ?, ?)");
            statement.setInt(1, game.score());
            statement.setInt(2, game.connexion_code());
            statement.setString(3, game.spymaster());
            statement.setString(4, game.operative());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de la partie");
            e.printStackTrace();
        }
    }

    public void updateScore(int score, int connexion_code) {
        try {
            var statement = this.database.prepareStatement("UPDATE game SET score = ? WHERE connexion_code = ?");
            statement.setInt(1, score);
            statement.setInt(2, connexion_code);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du score");
            e.printStackTrace();
        }

    }




}
