package models;

public class Role {
    private int _id;
    private String _nom;

    public Role(int id, String nom){
        _id = id;
        _nom = nom;
    }

    public int get_id() {
        return _id;
    }

    public String get_nom() {
        return _nom;
    }

    

}
