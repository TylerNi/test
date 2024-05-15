package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

public class Terrain extends CasePropriete implements Serializable {
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
        System.out.println();
        System.out.println("Vous êtes sur la case: " + nomCase);
        if(getProprietaire() == null){ //S'il n'y a pas de propriétaire, le joueur l'achète.
            System.out.println("Cette case n'appartient à personne");
            if (joueur.getNombreArgent() >= getPrixAchat()) {
                setProprietaire(joueur);
                joueur.setNombreArgent(joueur.getNombreArgent() - getPrixAchat());
                System.out.println("\033[38m" + joueur.getNom() + " a acheté " + nomCase + " pour " + this.getPrixAchat() + ". Il lui reste " + joueur.getNombreArgent() + "$" + "\033[39m");
                joueur.ajouterPropriete(this);
            }else {
                System.out.println("\033[38m" + joueur.getNom() + " n'a pas assez d'argent, il ne peut donc pas acheter " + nomCase + "\033[39m");
            }

        }else if(getProprietaire().getNom().equals(joueur.getNom())){ //S'il y a un propriétaire autre que lui même,
            if (joueur.getNombreArgent() >= getLoyer()) {
                System.out.println("Cette case appartient a " + getProprietaire().getNom());
                joueur.setNombreArgent(joueur.getNombreArgent() - getLoyer()); //le joueur paye le loyer au propriétaire.
                getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + getLoyer());
                System.out.println("\033[38m" + joueur.getNom() + " a payé " + this.getLoyer() + "$ a " + getProprietaire() + ".");
                System.out.println("\033[38m" + joueur.getNom() + " a maintenant " + joueur.getNombreArgent() + "$ et " + getProprietaire() + getProprietaire().getNombreArgent() + "$" + "\033[39m");
            }else {
                getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + joueur.getNombreArgent());
                joueur.setNombreArgent(0);
                joueur.setFaillite(true);
                System.out.println("Oh non, " + joueur.getNom() + " n'a pas assez d'argent pour pauer le loyer. Il fait faillite.");
            }

        }else {
            System.out.println("\033[38m" + joueur.getNom() + " est propriétaire de " + nomCase + ". Il n'a donc rien a payé. Il a " + joueur.getNombreArgent() + "$" + "\033[39m");
        }
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
