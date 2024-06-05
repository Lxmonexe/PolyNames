package models;

public class Dictionnaire {

    private int _id;
    private String _mot;
    
    public Dictionnaire(int id, String mot) {
        this._id = id;
        this._mot = mot;
    }

    public int get_id() {
        return _id;
    }

    public String get_mot() {
        return _mot;
    }
}
