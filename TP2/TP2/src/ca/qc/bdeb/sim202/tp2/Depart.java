package ca.qc.bdeb.sim202.tp2;

public class Depart extends Case{
    private int moutantGagne;
    public Depart(String nomCase, String descriptionCase, int moutantGagne) {
        super(nomCase, descriptionCase);
        this.moutantGagne = moutantGagne;
    }

    @Override
    void faireAction(Joueur joueur) {
        joueur.setNombreArgent(joueur.getNombreArgent()+moutantGagne);
    }
}
