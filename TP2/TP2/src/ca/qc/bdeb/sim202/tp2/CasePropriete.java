package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * Classe abstraite représentant une case de type propriété sur le plateau de jeu, qui peut être un service public ou un terrain.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public abstract class CasePropriete extends Case implements Serializable {

    private Joueur proprietaire = null;
    private int prixAchat;
    private int loyer;

    /**
     * Constructeur pour la classe CasePropriete.
     *
     * @param typeCase le type de la case
     * @param proprietaire le propriétaire de la case
     * @param prixAchat le prix d'achat de la case
     * @param loyer le loyer de la case
     * @param nomCase le nom de la case
     */
    public CasePropriete(String typeCase, Joueur proprietaire, int prixAchat, int loyer, String nomCase ) {
        super(typeCase, nomCase, null);
        this.proprietaire = proprietaire;
        this.prixAchat = prixAchat;
        this.loyer = loyer;

    }

    /**
     * Définit le propriétaire de la case.
     *
     * @param proprietaire le nouveau propriétaire de la case
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Renvoie le propriétaire de la case.
     *
     * @return le propriétaire de la case
     */
    public Joueur getProprietaire() {
        return proprietaire;
    }

    /**
     * Renvoie le prix d'achat de la case.
     *
     * @return le prix d'achat de la case
     */
    public int getPrixAchat() {
        return prixAchat;
    }

    /**
     * Renvoie le loyer de la case.
     *
     * @return le loyer de la case
     */
    public int getLoyer() {
        return loyer;
    }

    /**
     * Méthode abstraite pour définir l'action à effectuer lorsqu'un joueur arrive sur cette case.
     *
     * @param joueur le joueur qui arrive sur la case
     */
    abstract void faireAction(Joueur joueur, int valeurDe);
}
