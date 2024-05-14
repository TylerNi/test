package ca.qc.bdeb.sim202.tp2;

public class Depart extends Case{
    private int montantGagne;
    public Depart(String typeCase,String nomCase, String descriptionCase, int montantGagne) {
        super(typeCase, nomCase, descriptionCase);
        this.montantGagne = montantGagne;
    }

    @Override
    void faireAction(Joueur j) {
        if (!j.isFaillite()) {
            j.setNombreArgent(j.getNombreArgent() + montantGagne);
        }
    }

    @Override
    public void survolerCase(Joueur j) {
        if (!j.isFaillite()) {
            j.setNombreArgent(j.getNombreArgent() + montantGagne);
        }
    }
}
