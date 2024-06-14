package models;

// record non utilisé du à la version du JDK
public class Participer {
    
    private int _id;
    private int _idJoueur;
    private String _idPartie;
    private String _role;
    private int _score;

    /**
     * Constructeur
     * @param id
     * @param idJoueur
     * @param idPartie
     * @param role
     * @param score
     */
    public Participer(int id, int idJoueur, String idPartie, String role, int score) {
        _id = id;
        _idJoueur = idJoueur;
        _idPartie = idPartie;
        _role = role;
        _score = score;
    }

    /**
     * Retourne l'id
     * @return
     */
    public int get_id() {
        return _id;
    }

    /**
     * Retourne l'id du joueur participant à une partie
     * @return
     */
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

    /**
     * Retourne le role d'un joueur
     * @return
     */
    public String get_role() {
        return _role;
    }

    /**
     * Retourne le score d'une partie
     * @return
     */
    public int get_score() {
        return _score;
    }
}
