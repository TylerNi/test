package ca.qc.bdeb.sim202.tp2;

public class Stationnement extends Case{

    private int valeurTicket;
    public Stationnement(String typeCase, String nomCase, String descriptionCase, int valeurTicket){
        super(typeCase, nomCase, descriptionCase);
        this.valeurTicket = valeurTicket;
    }

    @Override
    void faireAction(Joueur joueur) {
        int deStationement = DePipe.lancer();
        if (deStationement == 2){
            joueur.setNombreArgent(joueur.getNombreArgent() - deStationement * 1 /*Valeur tikcket*/);
            System.out.println("Stationnement interdit les jours de semaine.");
        } else if (deStationement == 4){
            joueur.setNombreArgent(joueur.getNombreArgent() - deStationement * 1 /*Valeur tikcket*/);
            System.out.println("Stationnement réservé aux détenteurs de permis.");
        } else if (deStationement == 6){
            joueur.setNombreArgent(joueur.getNombreArgent() - deStationement * 1 /*Valeur tikcket*/);
            System.out.println("Place réservée aux handicapés.");
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
