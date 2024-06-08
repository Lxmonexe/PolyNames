package models;

public class Participer {
    private int _id;
    private Joueur _idJoueur;
    private Partie _idPartie;
    private String _role;
    private int _score;

    public Participer(int id, Joueur idJoueur, Partie idPartie, String role, int score) {
        _id = id;
        _idJoueur = idJoueur;
        _idPartie = idPartie;
        _role = role;
        _score = score;
    }

    public int get_id() {
        return _id;
    }

    public Joueur get_idJoueur() {
        return _idJoueur;
    }

    public Partie get_idPartie() {
        return _idPartie;
    }

    public String get_role() {
        return _role;
    }

    public int get_score() {
        return _score;
    }
}
