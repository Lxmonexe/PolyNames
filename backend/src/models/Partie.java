package models;

public class Partie {
    private int _id;
    private String _code;

    public Partie(int id, String code) {
        _id = id;
        _code = code;
    }

    public int get_id() {
        return _id;
    }

    public String get_code() {
        return _code;
    }

    
}
