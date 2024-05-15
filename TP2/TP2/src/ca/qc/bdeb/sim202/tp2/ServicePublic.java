package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * Classe représentant un service public sur le plateau de jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class ServicePublic extends CasePropriete implements Serializable {

    /**
     * Constructeur pour la classe ServicePublic.
     *
     * @param typeCase le type de la case
     * @param proprietaire le propriétaire de la case
     * @param prixAchat le prix d'achat de la case
     * @param nomCase le nom de la case
     */
    public ServicePublic(String typeCase, Joueur proprietaire, int prixAchat, String nomCase) {
        super(typeCase, proprietaire = null, prixAchat, 0, nomCase);
    }

    /**
     * Définit le loyer de la case.
     *
     * @param loyer le loyer de la case
     * @param joueur le joueur qui paie le loyer
     * @return le loyer de la case
     */
    public int setLoyer(int loyer, Joueur joueur, int valeurDe){
        loyer = 10 * valeurDe;
        return loyer;
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur arrive sur cette case.
     *
     * @param joueur le joueur qui arrive sur la case
     */
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
            if (joueur.getNombreArgent() >= getLoyer()) {
                joueur.setNombreArgent(joueur.getNombreArgent() - getLoyer()); //le joueur paye le loyer au propriétaire.
                getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + getLoyer());
                System.out.println("\033[38m" + joueur.getNom() + " a payé " + this.getLoyer() + "$ a " + getProprietaire() + "." + "\033[35m");
                System.out.println("\033[38m" + joueur.getNom() + " a maintenant " + joueur.getNombreArgent() + "$ et " + getProprietaire() + getProprietaire().getNombreArgent() + "$" + "\033[39m");
            }else{
                getProprietaire().setNombreArgent(getProprietaire().getNombreArgent() + joueur.getNombreArgent());
                joueur.setNombreArgent(0);
                joueur.setFaillite(true);
                System.out.println("Oh non, " + joueur.getNom() + " n'a pas assez d'argent pour pauer le loyer. Il fait faillite.");
            }

        }else {
            System.out.println("\033[38;2;255;105;180m" + joueur.getNom() + " est propriétaire de " + nomCase + ". Il n'a donc rien a payé. Il a " + joueur.getNombreArgent() + "$" + "\033[39m");
        }
    }

    /**
     * Définit l'action à effectuer lorsqu'un joueur survole cette case.
     *
     * @param j le joueur qui survole la case
     */
    @Override
    public void survolerCase(Joueur j) {

    }

    /**
     * Renvoie une représentation sous forme de chaîne de la case.
     *
     * @return une représentation sous forme de chaîne de la case
     */
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
