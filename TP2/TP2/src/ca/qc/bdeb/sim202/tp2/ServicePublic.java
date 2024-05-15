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
        System.out.println();
        System.out.println("Vous êtes sur la case: " + nomCase);
        if(getProprietaire() == null){ //S'il n'y a pas de propriétaire, le joueur l'achète.
            System.out.println("Cette case n'appartient à personne");
            if (joueur.getNombreArgent() >= getPrixAchat()) {
                setProprietaire(joueur);
                joueur.setNombreArgent(joueur.getNombreArgent() - getPrixAchat());
                System.out.println("\033[38m" + joueur.getNom() + " a acheté " + nomCase + "pour " + this.getPrixAchat() + ". Il lui reste " + joueur.getNombreArgent() + "$" + "\033[39m");
                joueur.ajouterPropriete(this);
            }else {
                System.out.println("\033[38m" + joueur.getNom() + " n'a pas assez d'argent, il ne peut donc pas acheter " + nomCase + "\033[39m");
            }

        }else if(getProprietaire().getNom().equals(joueur.getNom())){ //S'il y a un propriétaire autre que lui même,
            System.out.println("Cette case appartient a " + getProprietaire().getNom());
            joueur.setNombreArgent(joueur.getNombreArgent() - getLoyer()); //le joueur paye le loyer au propriétaire.
            getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + getLoyer());
            System.out.println("\033[38m" + joueur.getNom() + " a payé " + this.getLoyer() + "$ a " + getProprietaire() + "." + "\033[35m");
            System.out.println("\033[38m" + joueur.getNom() + " a maintenant " + joueur.getNombreArgent() + "$ et " + getProprietaire() + getProprietaire().getNombreArgent() + "$" + "\033[39m");

        }else {
            System.out.println("\033[38;2;255;105;180m" + joueur.getNom() + " est propriétaire de " + nomCase + ". Il n'a donc rien a payé. Il a " + joueur.getNombreArgent() + "$" + "\033[39m");
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
