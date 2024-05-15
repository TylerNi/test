package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * Classe représentant une case de départ sur le plateau de jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class Depart extends Case implements Serializable {
    private int montantGagne;

    /**
     * Constructeur pour la classe Depart.
     *
     * @param typeCase le type de la case
     * @param nomCase le nom de la case
     * @param descriptionCase la description de la case
     * @param montantGagne le montant gagné lorsqu'un joueur passe par cette case
     */
    public Depart(String typeCase,String nomCase, String descriptionCase, int montantGagne) {
        super(typeCase, nomCase, descriptionCase);
        this.montantGagne = montantGagne;
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur arrive sur cette case.
     * Le joueur gagne un certain montant d'argent lorsqu'il passe par cette case.
     *
     * @param j le joueur qui arrive sur la case
     */
    @Override
    void faireAction(Joueur j) {
        if (!j.isFaillite()) {
            j.setNombreArgent(j.getNombreArgent() + montantGagne);
            System.out.println();
            System.out.println("Vous avez passer la case départ réclamé " + montantGagne + "$" );
        }
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur survole cette case.
     * Le joueur gagne un certain montant d'argent lorsqu'il survole cette case.
     *
     * @param j le joueur qui survole la case
     */
    @Override
    public void survolerCase(Joueur j) {
        if (!j.isFaillite()) {
            j.setNombreArgent(j.getNombreArgent() + montantGagne);
            System.out.println();
            System.out.println("Vous avez passer la case départ réclamé " + montantGagne + "$" );
        }
    }

    /**
     * Renvoie une représentation sous forme de chaîne de la case.
     *
     * @return une représentation sous forme de chaîne de la case
     */
    @Override
    public String toString() {
        return nomCase + ": " + descriptionCase + ", " + montantGagne + "$";
    }
}
