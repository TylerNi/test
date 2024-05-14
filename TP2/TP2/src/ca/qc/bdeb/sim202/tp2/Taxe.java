package ca.qc.bdeb.sim202.tp2;

public class Taxe extends Case{
    private int montantTaxe;
    public Taxe(String typeCase, String nomCase, String descriptionCase, int montantTaxe) {
        super(typeCase, nomCase, descriptionCase);
        this.montantTaxe = montantTaxe;
    }

    @Override
    void faireAction(Joueur joueur) {

    }
}
