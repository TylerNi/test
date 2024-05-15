package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * Classe abstraite représentant une case sur le plateau de jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public abstract class Case implements Serializable {

    protected String typeCase;
    protected String nomCase;
    protected String descriptionCase;

    /**
     * Constructeur pour la classe Case.
     *
     * @param typeCase le type de la case
     * @param nomCase le nom de la case
     * @param descriptionCase la description de la case
     */
    public Case (String typeCase, String nomCase, String descriptionCase){
        this.typeCase = typeCase;
        this.nomCase = nomCase;
        this.descriptionCase = descriptionCase;
    }

    /**
     * Renvoie le nom de la case.
     *
     * @return le nom de la case
     */
    public String getNomCase() {
        return nomCase;
    }

    /**
     * Renvoie la description de la case.
     *
     * @return la description de la case
     */
    public String getDescriptionCase() {
        return descriptionCase;
    }

    /**
     * Définit le nom de la case.
     *
     * @param nomCase le nouveau nom de la case
     */
    public void setNomCase(String nomCase) {
        this.nomCase = nomCase;
    }

    /**
     * Définit la description de la case.
     *
     * @param descriptionCase la nouvelle description de la case
     */
    public void setDescriptionCase(String descriptionCase) {
        this.descriptionCase = descriptionCase;
    }

    /**
     * Méthode abstraite pour définir l'action à effectuer lorsqu'un joueur arrive sur cette case.
     *
     * @param joueur le joueur qui arrive sur la case
     */
    abstract void faireAction(Joueur joueur, int valeurDe);

    /**
     * Méthode abstraite pour définir l'action à effectuer lorsqu'un joueur survole cette case.
     *
     * @param j le joueur qui survole la case
     */
    abstract public void survolerCase(Joueur j);

    /**
     * Renvoie le type de la case.
     *
     * @return le type de la case
     */
    public String getTypeCase() {
        return typeCase;
    }


}
