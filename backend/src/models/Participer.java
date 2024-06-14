package models;

// record non utilisé du à la version du JDK
public class Participer {
    
    private int _id;
    private int _idJoueur;
    private String _idPartie;
    private String _role;
    private int _score;

    public Participer(int id, int idJoueur, String idPartie, String role, int score) {
        _id = id;
        _idJoueur = idJoueur;
        _idPartie = idPartie;
        _role = role;
        _score = score;
    }

    public int get_id() {
        return _id;
    }

    public int get_idJoueur() {
        return _idJoueur;
    }

    /**
     * Renvoie le code de la partie en hexa
     * @return
     */
    public String get_idPartie() {
        return _idPartie;
    }

    public String get_role() {
        return _role;
    }

    public int get_score() {
        return _score;
    }
}
