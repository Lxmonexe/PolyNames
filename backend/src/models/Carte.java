package models;
public class Carte {
    private String _texte;
    private String _couleur;
    private Boolean _decouvert;

    public Carte(String texte, String couleur, Boolean decouvert) {
        _texte = texte;
        _couleur = couleur;
        _decouvert = decouvert;
    }

    public String get_texte() {
        return _texte;
    }

    public String get_couleur() {
        return _couleur;
    }

    public Boolean get_decouvert() {
        return _decouvert;
    }

    public void set_decouvert(Boolean decouvert) {
        _decouvert = decouvert;
    }

    public void set_couleur(String couleur) {
        _couleur = couleur;
    }

    public void set_texte(String texte) {
        _texte = texte;
    }
}
