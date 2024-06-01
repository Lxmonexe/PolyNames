package models;

public class Type {
    private int _id;
    private String _couleur;
    private int _nombre;
    
    public Type(int id, String couleur, int nombre) {
        _id = id;
        _couleur = couleur;
        _nombre = nombre;
    }

    public int get_id() {
        return _id;
    }

    public String get_couleur() {
        return _couleur;
    }

    public int get_nombre() {
        return _nombre;
    }
}
