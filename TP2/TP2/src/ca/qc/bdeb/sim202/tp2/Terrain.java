package ca.qc.bdeb.sim202.tp2;

public class Terrain extends CasePropriete{
    public Terrain(Joueur proprietaire, int prixAchat, int loyer, String nomCase) {
        super(proprietaire, prixAchat, loyer, nomCase);
    }

    public int setLoyer(int loyer, Joueur joueur){
        if (joueur.isEstProprietaire()){
            loyer = loyer*2;
        }

        return loyer;
    }

    @Override
    void faireAction(Joueur joueur) {
        if(getProprietaire() == null){
            setProprietaire(joueur);
        }else if(getProprietaire().getNom() != joueur.getNom()){
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
