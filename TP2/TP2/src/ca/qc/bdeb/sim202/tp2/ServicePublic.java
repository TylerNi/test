package ca.qc.bdeb.sim202.tp2;

public class ServicePublic extends CasePropriete {
    public ServicePublic(String typeCase, Joueur proprietaire, int prixAchat, String nomCase) {
        super(typeCase, proprietaire, prixAchat, 0, nomCase);
    }




    public int setLoyer(int loyer, Joueur joueur){
        loyer = 10 * 1; //La valeur 1 est temporaire pour que le code puisse run,
        return loyer;   // il faudrait la remplacer par la valeur du dé.
    }

    @Override
    void faireAction(Joueur joueur) {
        if(getProprietaire() == null){ //S'il n'y a pas de propriétaire, le joueur l'achète.
            setProprietaire(joueur);
            joueur.setNombreArgent(joueur.getNombreArgent() - getPrixAchat());

        }else if(getProprietaire().getNom() != joueur.getNom()){ //S'il y a un propriétaire autre que lui même,
            joueur.setNombreArgent(joueur.getNombreArgent() - getLoyer()); //le joueur paye le loyer au propriétaire.
            getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + getLoyer());

        }//Si le joueur est propriétaire, rien.

    }
}
