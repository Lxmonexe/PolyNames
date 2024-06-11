package models;

public class Grille {
    private int _id;
    private String _idPartie;
    private int _idMot;
    private String _couleur;
    private Boolean _decouvert;

    public Grille(int id, String idPartie, int idMot, String couleur, Boolean decouvert) {
        _id = id;
        _idPartie = idPartie;
        _idMot = idMot;
        _couleur = couleur;
        _decouvert = decouvert;
    }

    public int get_id() {
        return _id;
    }

    public String get_idPartie() {
        return _idPartie;
    }

    public int get_idMot() {
        return _idMot;
    }

    public String get_couleur() {
        return _couleur;
    }

    public Boolean get_decouvert() {
        return _decouvert;
    }
}
