package ca.qc.bdeb.sim202.tp2;

public class Depart extends Case{
    private int montantGagne;
    public Depart(String typeCase,String nomCase, String descriptionCase, int montantGagne) {
        super(typeCase, nomCase, descriptionCase);
        this.montantGagne = montantGagne;
    }

    @Override
    void faireAction(Joueur joueur) {
        joueur.setNombreArgent(joueur.getNombreArgent()+montantGagne);
    }
}
