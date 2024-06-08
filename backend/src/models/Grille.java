package models;

public class Grille {
    private int _id;
    private Partie _idPartie;
    private Mot _idMot;
    private String _couleur;

    public Grille(int id, Partie idPartie, Mot idMot, String couleur) {
        _id = id;
        _idPartie = idPartie;
        _idMot = idMot;
        _couleur = couleur;
    }

    public int get_id() {
        return _id;
    }

    public Partie get_idPartie() {
        return _idPartie;
    }

    public Mot get_idMot() {
        return _idMot;
    }

    public String get_couleur() {
        return _couleur;
    }
}
