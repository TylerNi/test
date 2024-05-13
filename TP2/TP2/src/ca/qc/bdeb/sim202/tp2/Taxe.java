package ca.qc.bdeb.sim202.tp2;

public class Taxe extends Case{
    private int moutantPaye;
    public Taxe(String typeCase, String nomCase, String descriptionCase, int moutantPaye) {
        super(typeCase, nomCase, descriptionCase);
        this.moutantPaye = moutantPaye;
    }

    @Override
    void faireAction(Joueur joueur) {

    }
}
