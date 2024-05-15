package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

public class Stationnement extends Case implements Serializable {

    private int valeurTicket;
    public Stationnement(String typeCase, String nomCase, String descriptionCase, int valeurTicket){
        super(typeCase, nomCase, descriptionCase);
        this.valeurTicket = valeurTicket;
    }

    @Override
    void faireAction(Joueur joueur) {
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

    @Override
    public void survolerCase(Joueur j) {
    }

    @Override
    public String toString() {
        return nomCase + ": " + descriptionCase + ", " + valeurTicket + "$";
    }
}
