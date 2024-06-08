package models;

public class Couleur {
    private int _id;
    private String _nom;
    
    /**
     * Type constructor
     * @param id
     * @param nom
     */
    public Couleur(int id, String couleur) {
        _id = id;
        _nom = couleur;
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
        return _nom;
    }
}
