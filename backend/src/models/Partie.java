package models;

public class Partie {
    private String _id;

    /**
     * Constructeur
     * @param id
     */
    public Partie(String id) {
        _id = id;
    }

    /**
     * Retourne le code hexa de la partie
     * @return
     */
    public String get_id() {
        return _id;
    }

    
}
