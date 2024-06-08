package models;

public class Posseder {

    private int _id;
    private Dictionnaire _id_dictionnaire; // fk dictionnaire
    private int _id_type;
    
    /**
     * Carte constructor
     * @param id
     * @param mot
     * @param id_type
     */
    public Posseder(int id, Dictionnaire mots, int id_type) {
        _id = id;
        _id_dictionnaire = mots;
        _id_type = id_type;
    }

    /**
     * 
     * @return id_carte
     */
    public int get_id() {
        return _id;
    }

    /**
     * 
     * @return mot_carte
     */
    public Dictionnaire get_id_dictionnaire() {
        return _id_dictionnaire;
    }

    public int get_id_type() {
        return _id_type;
    }

}
