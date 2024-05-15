package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * Classe représentant une case de taxe sur le plateau de jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class Taxe extends Case implements Serializable {
    private int montantTaxe;

    /**
     * Constructeur pour la classe Taxe.
     *
     * @param typeCase le type de la case
     * @param nomCase le nom de la case
     * @param descriptionCase la description de la case
     * @param montantTaxe le montant de la taxe
     */
    public Taxe(String typeCase, String nomCase, String descriptionCase, int montantTaxe) {
        super(typeCase, nomCase, descriptionCase);
        this.montantTaxe = montantTaxe;
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur arrive sur cette case.
     *
     * @param j le joueur qui arrive sur la case
     */
    @Override
    void faireAction(Joueur j) {
        if (!j.isFaillite()) {
            System.out.println();
            if (j.getNombreArgent()<montantTaxe){
                j.setFaillite(true);
                j.setNombreArgent(0);
                System.out.println("Oh non, " + j.getNom() + " n'a pas assez d'argent, il fait faillite.");
            } else {
                j.setNombreArgent(j.getNombreArgent() - montantTaxe );
                System.out.println(j.getNom() + " a payé une taxe de " + montantTaxe + "$. Il lui reste" + j.getNombreArgent() +"$");
            }
        }
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur survole cette case.
     *
     * @param j le joueur qui survole la case
     */
    @Override
    public void survolerCase(Joueur j) {
        if (!j.isFaillite()) {
            System.out.println();
            if (j.getNombreArgent()<montantTaxe * .1){
                j.setFaillite(true);
                j.setNombreArgent(0);
                System.out.println("Oh non, " + j.getNom() + " n'a pas assez d'argent, il fait faillite.");
            } else {
                j.setNombreArgent(j.getNombreArgent() - (int) (montantTaxe * .1));
                System.out.println(j.getNom() + " a payé une taxe de " + (int) (montantTaxe*.1) + "$. En passant sur la case taxe. Il lui reste" + j.getNombreArgent() +"$");
            }
        }
    }

    /**
     * Renvoie une représentation sous forme de chaîne de la case.
     *
     * @return une représentation sous forme de chaîne de la case
     */
    @Override
    public String toString() {
        return nomCase + ": " + descriptionCase + ", " + montantTaxe + "$";
    }
}
