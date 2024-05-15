package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * Classe représentant une case de stationnement sur le plateau de jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class Stationnement extends Case implements Serializable {

    private int valeurTicket;

    /**
     * Constructeur pour la classe Stationnement.
     *
     * @param typeCase le type de la case
     * @param nomCase le nom de la case
     * @param descriptionCase la description de la case
     * @param valeurTicket la valeur du ticket de stationnement
     */
    public Stationnement(String typeCase, String nomCase, String descriptionCase, int valeurTicket){
        super(typeCase, nomCase, descriptionCase);
        this.valeurTicket = valeurTicket;
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur arrive sur cette case.
     *
     * @param joueur le joueur qui arrive sur la case
     */
    @Override
    void faireAction(Joueur joueur, int valeurDe) {
        System.out.println();
        System.out.println("Vous êtes sur la case: " + nomCase);
        int deStationement = DePipe.lancer();
        System.out.println();
        if (deStationement == 2){
            joueur.setNombreArgent(joueur.getNombreArgent() - deStationement * valeurTicket);
            System.out.println(deStationement +  ": Stationnement interdit les jours de semaine.");
        } else if (deStationement == 4){
            joueur.setNombreArgent(joueur.getNombreArgent() - deStationement * valeurTicket);
            System.out.println(deStationement + ": Stationnement réservé aux détenteurs de permis.");
        } else if (deStationement == 6){
            joueur.setNombreArgent(joueur.getNombreArgent() - deStationement * valeurTicket);
            System.out.println(deStationement + ": Place réservée aux handicapés.");
        }else {
            System.out.println(deStationement + ": Stationement ici! Je pense que j'ai le droit de stationner!");
        }
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur survole cette case.
     *
     * @param j le joueur qui survole la case
     */
    @Override
    public void survolerCase(Joueur j) {
    }

    /**
     * Renvoie une représentation sous forme de chaîne de la case.
     *
     * @return une représentation sous forme de chaîne de la case
     */
    @Override
    public String toString() {
        return nomCase + ": " + descriptionCase + ", " + valeurTicket + "$";
    }
}
