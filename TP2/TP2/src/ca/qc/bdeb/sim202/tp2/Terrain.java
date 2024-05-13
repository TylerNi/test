package ca.qc.bdeb.sim202.tp2;

public class Terrain extends CasePropriete{
    public Terrain(Joueur proprietaire, int prixAchat, int loyer, String nomCase, String descriptionCase) {
        super(proprietaire, prixAchat, loyer, nomCase, descriptionCase);
    }

    public int setLoyer(int loyer){
        if (/*proprietere possède propriété*/){
            loyer = loyer*2;
        }

        return loyer;
    }

    @Override
    void faireAction(Joueur joueur) {
        if(getProprietaire() == null){
            setProprietaire(Joueur joueur);
        }else if(getProprietaire() != /*joueurActuel*/){
            int nombreArgent = joueur.getNombreArgent() - getLoyer();
            joueur.setNombreArgent(nombreArgent);

            nombreArgent = getProprietaire().getNombreArgent() + getLoyer();
            getProprietaire().setNombreArgent(nombreArgent);
        }else{
            int nombreArgent = joueur.getNombreArgent();
            nombreArgent = nombreArgent - getPrixAchat();
            joueur.setNombreArgent(nombreArgent);

        }
    }
}
