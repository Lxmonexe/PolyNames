package models;

public class Type {
    private int _id;
    private String _couleur;
    private int _nombre;
    
    /**
     * Type constructor
     * @param id
     * @param couleur
     * @param nombre
     */
    public Type(int id, String couleur, int nombre) {
        _id = id;
        _couleur = couleur;
        _nombre = nombre;
    }

    /**
     * 
     * @return id_type
     */
    public int get_id() {
        return _id;
    }

    /**
     * 
     * @return couleur_type
     */
    public String get_couleur() {
        return _couleur;
    }

    /**
     * 
     * @return nombre_type
     */
    public int get_nombre() {
        return _nombre;
    }
}
