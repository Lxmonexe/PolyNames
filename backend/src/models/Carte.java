package models;

public class Carte {

    private int _id;
    private String _mot;
    private int _id_type; // FK
    
    public Carte(int id, String mot, int id_type) {
        _id = id;
        _mot = mot;
        _id_type = id_type;
    }

    public int get_id() {
        return _id;
    }

    public String get_mot() {
        return _mot;
    }

    public int get_id_type() {
        return _id_type;
    }

}
