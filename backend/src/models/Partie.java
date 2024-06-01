package models;

public class Partie {
    private int _id;
    private int _code;
    private int _score;
    private int _id_joueur; //foreign key
    private int _id_carte; //foreign key
    
    public Partie(int id, int code, int score, int id_joueur, int id_carte) {
        _id = id;
        _code = code;
        _score = score;
        _id_joueur = id_joueur;
        _id_carte = id_carte;
    }

    public int get_id() {
        return _id;
    }

    public int get_code() {
        return _code;
    }

    public int get_score() {
        return _score;
    }

    public int get_id_joueur() {
        return _id_joueur;
    }

    public int get_id_carte() {
        return _id_carte;
    }

    
}
