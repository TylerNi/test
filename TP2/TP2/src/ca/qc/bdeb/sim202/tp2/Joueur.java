package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Classe représentant un joueur dans le jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class Joueur implements Serializable {
    private String nom;
    private int nombreArgent;
    private int position;
    private boolean estProprietaire;

    private LinkedList<CasePropriete> listePropriete;

    private boolean faillite;

    /**
     * Constructeur pour la classe Joueur.
     *
     * @param nom le nom du joueur
     * @param nombreArgent le montant d'argent que le joueur possède
     * @param position la position du joueur sur le plateau de jeu
     */
    public Joueur (String nom, int nombreArgent, int position){
        this.nom = nom;
        this.nombreArgent = nombreArgent;
        this.position = position;
        this.estProprietaire = false;
        this.faillite = false;
        this.listePropriete = new LinkedList<>();
    }

    /**
     * Renvoie le nom du joueur.
     *
     * @return le nom du joueur
     */
    public String getNom(){
        return nom;
    }

    /**
     * Renvoie le montant d'argent que le joueur possède.
     *
     * @return le montant d'argent que le joueur possède
     */
    public int getNombreArgent(){
        return nombreArgent;
    }

    /**
     * Renvoie la position du joueur sur le plateau de jeu.
     *
     * @return la position du joueur sur le plateau de jeu
     */
    public int getPosition() {
        return position;
    }

    /**
     * Définit le montant d'argent que le joueur possède.
     *
     * @param nombreArgent le nouveau montant d'argent que le joueur possède
     */
    public void setNombreArgent(int nombreArgent) {
        this.nombreArgent = nombreArgent;
    }

    /**
     * Définit la position du joueur sur le plateau de jeu.
     *
     * @param position la nouvelle position du joueur sur le plateau de jeu
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Renvoie si le joueur est propriétaire ou non d'une propriété.
     *
     * @return vrai si le joueur est propriétaire, faux sinon
     */
    public boolean isEstProprietaire() {
        return estProprietaire;
    }

    /**
     * Renvoie si le joueur a fait faillite ou non.
     *
     * @return vrai si le joueur est en faillite, faux sinon
     */
    public boolean isFaillite() {
        return faillite;
    }

    /**
     * Définit si le joueur est en faillite ou non.
     *
     * @param faillite vrai si le joueur est en faillite, faux sinon
     */
    public void setFaillite(boolean faillite) {
        this.faillite = faillite;
    }

    /**
     * Ajoute une propriété à la liste des propriétés du joueur.
     *
     * @param casePropriete la propriété à ajouter
     */
    public void ajouterPropriete(CasePropriete casePropriete) {
        listePropriete.add(casePropriete);
    }

    /**
     * Renvoie le total de l'argent du joueur, y compris la valeur de ses propriétés.
     *
     * @return le total de l'argent du joueur
     */
    public int retourneArgentTotal(){
        int argentTotal = getNombreArgent();
        for (CasePropriete caseP:listePropriete) {
            argentTotal += caseP.getPrixAchat();
        }
        return argentTotal;
    }

    /**
     * Renvoie une représentation sous forme de chaîne du joueur.
     *
     * @return une représentation sous forme de chaîne du joueur
     */
    @Override
    public String toString() {
        if (isFaillite()){
            return nom + " a fait faillite";
        } else {
            String stringP = "";
            for (CasePropriete caseP:this.listePropriete) {
                stringP += caseP.nomCase + " - ";
            }

            return nom + " possède: les propriétés " + stringP + " et il a fini avec: " + nombreArgent;
        }
    }
}


