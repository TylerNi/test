package ca.qc.bdeb.sim202.tp2;

public class ServicePublic extends CasePropriete {
    public ServicePublic(String typeCase, Joueur proprietaire, int prixAchat, String nomCase) {
        super(typeCase, proprietaire, prixAchat, 0, nomCase);
    }


    public int setLoyer(){
        return 10 * /*Valeur dé*/ 1 /*temp*/;
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
