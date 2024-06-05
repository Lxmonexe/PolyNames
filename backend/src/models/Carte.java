package models;

public class Carte {

    private int _id;
    private String _mot;
    private int _id_type;
    
    /**
     * Carte constructor
     * @param id
     * @param mot
     * @param id_type
     */
    public Carte(int id, String mot, int id_type) {
        _id = id;
        _mot = mot;
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
    public String get_mot() {
        return _mot;
    }

    public int get_id_type() {
        return _id_type;
    }

}
