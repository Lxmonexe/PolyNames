package models;

public class Joueur {
    private int _id;
    private int _id_role;
    
    public Joueur(int id, int id_role) {
        _id = id;
        _id_role = id_role;
    }

    public int get_id() {
        return _id;
    }

    public int get_id_role() {
        return _id_role;
    }
}
