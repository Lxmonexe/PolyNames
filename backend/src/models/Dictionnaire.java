package models;

public class Dictionnaire {

    private int _id;
    private String _mot;
    
    /**
     * Dictionnaire constructor
     * @param id
     * @param mot
     */
    public Dictionnaire(int id, String mot) {
        this._id = id;
        this._mot = mot;
    }

    /**
     * 
     * @return id_dictionnaire
     */
    public int get_id() {
        return _id;
    }

    /**
     * 
     * @return mot_constructor
     */
    public String get_mot() {
        return _mot;
    }
}
