package models;

public class Joueur {
    private int _id;
    private String _pseudo;

    public Joueur(int id, String pseudo) {
        _id = id;
        _pseudo = pseudo;
    }

    public int get_id() {
        return _id;
    }

    public String get_pseudo() {
        return _pseudo;
    }

}
