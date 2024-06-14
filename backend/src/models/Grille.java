package models;

public class Grille {
    private int _id;
    private String _idPartie;
    private int _idMot;
    private String _couleur;
    private Boolean _decouvert;

    /**
     * Constructeur
     * @param id
     * @param idPartie
     * @param idMot
     * @param couleur
     * @param decouvert
     */
    public Grille(int id, String idPartie, int idMot, String couleur, Boolean decouvert) {
        _id = id;
        _idPartie = idPartie;
        _idMot = idMot;
        _couleur = couleur;
        _decouvert = decouvert;
    }

    /**
     * Retourne l'id
     * @return
     */
    public int get_id() {
        return _id;
    }

    /**
     * Retourne l'id de la partie associé
     * @return
     */
    public String get_idPartie() {
        return _idPartie;
    }

    /**
     * Retourne l'id d'un mot
     * @return
     */
    public int get_idMot() {
        return _idMot;
    }

    /**
     * Retourne la couleur associé
     * @return
     */
    public String get_couleur() {
        return _couleur;
    }

    /**
     * Retourne le status du mot (decouvert ou non)
     * @return
     */
    public Boolean get_decouvert() {
        return _decouvert;
    }
}
