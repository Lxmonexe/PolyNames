package models;

public class Joueur {
    private int _id;
    private String _pseudo;

    /**
     * Constructeur
     * @param id
     * @param pseudo
     */
    public Joueur(int id, String pseudo) {
        _id = id;
        _pseudo = pseudo;
    }

    /**
     * Retourne l'id
     * @return
     */
    public int get_id() {
        return _id;
    }

    /**
     * Retourne le pseudo 
     * @return
     */
    public String get_pseudo() {
        return _pseudo;
    }

}
