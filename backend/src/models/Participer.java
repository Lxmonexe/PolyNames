package models;

public class Participer {
    private int _id;
    private String _pseudo;
    private int _id_partie;
    private int _id_role; // FK
    
    /**
     * Joueur constructor
     * @param id
     * @param pseudo
     * @param _id_partie
     * @param id_role
     */
    public Participer(int id, String pseudo, int id_partie, int id_role) {
        _id = id;
        _pseudo = pseudo;
        _id_partie = id_partie;
        _id_role = id_role;
    }

    /**
     * 
     * @return id_joueur
     */
    public int get_id() {
        return _id;
    }

    /**
     * 
     * @return pseudo_joueur
     */
    public String get_pseudo(){
        return _pseudo;
    }

    public int get_id_partie() {
        return _id_partie;
    }

    public int get_id_role() {
        return _id_role;
    }
}
