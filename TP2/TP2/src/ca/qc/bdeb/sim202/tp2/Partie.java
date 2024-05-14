package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;
import java.util.LinkedList;

public class Partie implements Serializable {

    private PlateauDeJeu plateauDeJeu;

    private LinkedList<Joueur> listJoueur;

    private int indicateur;

    public Partie(PlateauDeJeu plateauDeJeu, LinkedList<Joueur> listJoueur, int indicateur) {
        this.plateauDeJeu = plateauDeJeu;
        this.listJoueur = listJoueur;
        this.indicateur = indicateur;
    }

    public void commencerPartie(){
        System.out.println("************************ Le plateau ************************");
        Case[] liste = plateauDeJeu.getListeCase();

        for (int i = 0; i < liste.length; i++) {
            System.out.print("\033[34m" + i+1 + ": \033[39m");
            System.out.println("\033[34m" + liste[i] +"\033[39m");
        }

    }


}
