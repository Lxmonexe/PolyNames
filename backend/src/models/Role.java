package models;

public class Role {
    private int _id;
    private String _nom;

    /**
     * Role constructor
     * @param id
     * @param nom
     */
    public Role(int id, String nom){
        _id = id;
        _nom = nom;
    }

    /**
     * 
     * @return id_role
     */
    public int get_id() {
        return _id;
    }

    /**
     * 
     * @return nom
     */
    public String get_nom() {
        return _nom;
    }

    

}
