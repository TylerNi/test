package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;
import java.util.LinkedList;

public class Joueur implements Serializable {
    private String nom;
    private int nombreArgent;
    private int position;
    private boolean estProprietaire;

    private LinkedList<CasePropriete> listePropriete;

    private boolean faillite;

    public Joueur (String nom, int nombreArgent, int position){
        this.nom = nom;
        this.nombreArgent = nombreArgent;
        this.position = position;
        this.estProprietaire = false;
        this.faillite = false;
        this.listePropriete = new LinkedList<>();
    }

    public String getNom(){
        return nom;
    }
    public int getNombreArgent(){
        return nombreArgent;
    }

    public int getPosition() {
        return position;
    }

    public void setNombreArgent(int nombreArgent) {
        this.nombreArgent = nombreArgent;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isEstProprietaire() {
        return estProprietaire;
    }

    public boolean isFaillite() {
        return faillite;
    }

    public void setFaillite(boolean faillite) {
        this.faillite = faillite;
    }

    public void ajouterPropriete(CasePropriete casePropriete) {
        listePropriete.add(casePropriete);
    }

    public int retourneArgentTotal(){
        int argentTotal = getNombreArgent();
        for (CasePropriete caseP:listePropriete) {
            argentTotal += caseP.getPrixAchat();
        }
        return argentTotal;
    }

}


