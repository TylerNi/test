package ca.qc.bdeb.sim202.tp2;

public class Terrain extends CasePropriete{
    public Terrain(String typeCase, Joueur proprietaire, int prixAchat, int loyer, String nomCase) {
        super(typeCase, proprietaire = null, prixAchat, loyer, nomCase);
    }

    public int setLoyer(int loyer, Joueur joueur){
        if (joueur.isEstProprietaire()){
            loyer = loyer*2;
        }
        return loyer;
    }

    @Override
    void faireAction(Joueur joueur) {
        if(getProprietaire() == null){ //S'il n'y a pas de propriétaire, le joueur l'achète.
            setProprietaire(joueur);
            joueur.setNombreArgent(joueur.getNombreArgent() - getPrixAchat());

        }else if(getProprietaire().getNom().equals(joueur.getNom())){ //S'il y a un propriétaire autre que lui même,
            joueur.setNombreArgent(joueur.getNombreArgent() - getLoyer()); //le joueur paye le loyer au propriétaire.
            getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + getLoyer());

        }//Si le joueur est propriétaire, rien.
    }

    @Override
    public void survolerCase(Joueur j) {

    }

    public String toString() {
        String propietere;
        if (getProprietaire() == null){
            return nomCase + ": " + this.getPrixAchat() + "$, " + this.getLoyer() + "$, aucun propriétaire";
        }else {
            return nomCase + ": " + this.getPrixAchat() + "$, " + this.getLoyer()+ "$, appartient à: " + getProprietaire();
        }

    }


}
