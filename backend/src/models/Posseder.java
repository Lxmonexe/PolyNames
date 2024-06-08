package models;

public class Posseder {

    private int _id;
    private Mot _id_mot; // fk dictionnaire
    private Couleur _id_couleur;
    
    /**
     * Carte constructor
     * @param id
     * @param i_mot
     * @param id_couleur
     */
    public Posseder(int id, Mot mot, Couleur id_couleur) {
        _id = id;
        _id_mot = mot;
        _id_couleur = id_couleur;
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
    public Mot get_id_dictionnaire() {
        return _id_mot;
    }

    public Couleur get_id_type() {
        return _id_couleur;
    }

}
