package models;

public class Joueur {
    private int _id;
    private String _pseudo;
    private int _id_role; // FK
    
    public Joueur(int id, String pseudo, int id_role) {
        _id = id;
        _pseudo = pseudo;
        _id_role = id_role;
    }

    public int get_id() {
        return _id;
    }

    public String get_pseudo(){
        return _pseudo;
    }

    public int get_id_role() {
        return _id_role;
    }
}
