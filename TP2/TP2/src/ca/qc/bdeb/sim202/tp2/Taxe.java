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
            if (j.getNombreArgent()<montantTaxe){
                j.setFaillite(true);
                j.setNombreArgent(0);
            } else {
                j.setNombreArgent(j.getNombreArgent() - montantTaxe );
            }
        }
    }

    @Override
    public void survolerCase(Joueur j) {
        if (!j.isFaillite()) {
            j.setNombreArgent(j.getNombreArgent() - (int) (montantTaxe*0.1) );
        }
    }

    @Override
    public String toString() {
        return nomCase + ": " + descriptionCase + ", " + montantTaxe + "$";
    }
}
