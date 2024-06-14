package models;

public class Carte {
    private String _texte;
    private String _couleur;
    private Boolean _decouvert;

    /**
     * Constructeur
     * @param texte
     * @param couleur
     * @param decouvert
     */
    public Carte(String texte, String couleur, Boolean decouvert) {
        _texte = texte;
        _couleur = couleur;
        _decouvert = decouvert;
    }

    /**
     * Retourne le mot
     * @return
     */
    public String get_texte() {
        return _texte;
    }

    /**
     * Retourne la couleur du mot
     * @return
     */
    public String get_couleur() {
        return _couleur;
    }

    /**
     * Retourne le status de la carte (decouvert ou non)
     * @return
     */
    public Boolean get_decouvert() {
        return _decouvert;
    }

}
