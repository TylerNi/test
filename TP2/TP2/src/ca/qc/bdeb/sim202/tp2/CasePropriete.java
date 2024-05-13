package ca.qc.bdeb.sim202.tp2;

public abstract class CasePropriete extends Case{

    private Joueur proprietaire;
    private int prixAchat;
    private int loyer;

    public CasePropriete(Joueur proprietaire, int prixAchat, int loyer, String nomCase, String descriptionCase) {
        super(nomCase, descriptionCase);
        this.proprietaire = proprietaire;
        this.prixAchat = prixAchat;
        this.loyer = loyer;

    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public int getLoyer() {
        return loyer;
    }
}
