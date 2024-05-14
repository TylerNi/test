package ca.qc.bdeb.sim202.tp2;

public class ServicePublic extends CasePropriete {
    public ServicePublic(String typeCase, Joueur proprietaire, int prixAchat, String nomCase) {
        super(typeCase, proprietaire = null, prixAchat, 0, nomCase);
    }

    public int setLoyer(int loyer, Joueur joueur){
        loyer = 10 * 1; //La valeur 1 est temporaire pour que le code puisse run,
        return loyer;   // il faudrait la remplacer par la valeur du dé.
    }

    @Override
    void faireAction(Joueur joueur) {
        if(getProprietaire() == null){ //S'il n'y a pas de propriétaire, le joueur l'achète.
            if (joueur.getNombreArgent() >= getPrixAchat()) {
                setProprietaire(joueur);
                joueur.setNombreArgent(joueur.getNombreArgent() - getPrixAchat());
                System.out.println("\\033[38;2;255;105;180m" + joueur.getNom() + "a acheté " + nomCase + "pour " + this.getPrixAchat() + ". " + joueur.getNombreArgent() + "$ restant.");

            }else {
                System.out.println("\\033[38;2;255;105;180m" + joueur.getNom() + "n'a pas assez d'argent, il ne peut donc pas acheter " + nomCase);
            }

        }else if(getProprietaire().getNom().equals(joueur.getNom())){ //S'il y a un propriétaire autre que lui même,
            joueur.setNombreArgent(joueur.getNombreArgent() - getLoyer()); //le joueur paye le loyer au propriétaire.
            getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + getLoyer());
            System.out.println("\033[38;2;255;105;180m" + joueur.getNom() + " a payé " + this.getLoyer() + "$ a " + getProprietaire() + ".");
            System.out.println("\033[38;2;255;105;180m" + joueur.getNom() + " a maintenant " + joueur.getNombreArgent() + "$ et " + getProprietaire() + getProprietaire().getNombreArgent() + "$");

        }else {
            System.out.println("\033[38;2;255;105;180m" + joueur.getNom() + "est propriétaire de " + nomCase + ". Il a" + joueur.getNombreArgent() + "$");
        }
    }

    @Override
    public void survolerCase(Joueur j) {

    }

    @Override
    public String toString() {
        String propietere;
        if (getProprietaire() == null){
            return nomCase + ": " + this.getPrixAchat() + "$, aucun propriétaire";
        }else {
            return nomCase + ": " + this.getPrixAchat() + "$, appartient à: " + getProprietaire();
        }

    }
}
