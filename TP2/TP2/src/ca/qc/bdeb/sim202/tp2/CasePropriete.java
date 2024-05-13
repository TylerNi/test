package ca.qc.bdeb.sim202.tp2;

public abstract class CasePropriete extends Case{

    private Joueur proprietaire = null;
    private int prixAchat;
    private int loyer;

    public CasePropriete(Joueur proprietaire, int prixAchat, int loyer, String nomCase ) {
        super(nomCase, null);
        this.proprietaire = proprietaire;
        this.prixAchat = prixAchat;
        this.loyer = loyer;

    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
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

    abstract void faireAction(Joueur joueur);
}
