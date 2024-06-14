package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import database.polyNamesDatabase;
import models.Game;
import webserver.WebServerContext;
import DAO.CardsDAO;

public class GameDAO {

    private CardsDAO CardsDao;
    private polyNamesDatabase database;
    
    public GameDAO() {
        try {
            this.CardsDao = new CardsDAO();
            this.database = new polyNamesDatabase("localhost", 3306, "poly_names", "root", "");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
    }

    public void createGame(Game game) {
        try {
            PreparedStatement deleteGameStatement = this.database.prepareStatement("DELETE FROM game");
            deleteGameStatement.executeUpdate();
            PreparedStatement statement = this.database.prepareStatement("INSERT INTO game (authentication_code, score, turn) VALUES (?, ?, ?)");
            Random rand = new Random();

            int randomCode = rand.nextInt(9999);

            statement.setInt(1, randomCode);
            statement.setInt(2, 0);
            statement.setInt(3, 0);

            statement.executeUpdate();

            this.CardsDao.initializeCards();

        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de la partie");
            e.printStackTrace();
        }
    }

    public void updateScore(int score, int connexion_code) {
        try {
            PreparedStatement statement = this.database.prepareStatement("UPDATE game SET score = ? WHERE connexion_code = ?");
            statement.setInt(1, score);
            statement.setInt(2, connexion_code);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du score");
            e.printStackTrace();
        }

    }

    public void addPlayers(int playerId, String role) {
        try {
            PreparedStatement statement = this.database.prepareStatement("UPDATE INTO game () VALUES (?, ?) WHERE role = ?");
            statement.setInt(2, playerId);
            statement.setString(3, role);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du joueur");
            e.printStackTrace();
        }
    }


    public void nextTurn(int connexion_code) {
        try {
            PreparedStatement statement = this.database.prepareStatement("UPDATE game SET turn = turn + 1 WHERE connexion_code = ?");
            statement.setInt(1, connexion_code);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors du passage au tour suivant");
            e.printStackTrace();    

        }
    }

    public int getTurn(WebServerContext context, int connexion_code) {
        try {
            PreparedStatement statement = this.database.prepareStatement("SELECT turn FROM game WHERE connexion_code = ?");
            statement.setInt(1, connexion_code);
            var result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("turn"));
                return result.getInt("turn");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du tour");
            e.printStackTrace();
        }
        return 0;
    }

}
