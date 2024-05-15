package ca.qc.bdeb.sim202.tp2;

public class Taxe extends Case{
    private int montantTaxe;
    public Taxe(String typeCase, String nomCase, String descriptionCase, int montantTaxe) {
        super(typeCase, nomCase, descriptionCase);
        this.montantTaxe = montantTaxe;
    }

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

    @Override
    public String toString() {
        return nomCase + ": " + descriptionCase + ", " + montantTaxe + "$";
    }
}
