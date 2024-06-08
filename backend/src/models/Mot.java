package models;

public class Mot {

    private int _id;
    private String _texte;
    
    /**
     * Dictionnaire constructor
     * @param id
     * @param texte
     */
    public Mot(int id, String texte) {
        this._id = id;
        this._texte = texte;
    }

    /**
     * 
     * @return id
     */
    public int get_id() {
        return _id;
    }

    /**
     * 
     * @return texte
     */
    public String get_texte() {
        return _texte;
    }
}


