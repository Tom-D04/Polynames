package models;

public record Game (
    int id,
    int score,
    int connexion_code,
    String spymaster,
    String operative
){}