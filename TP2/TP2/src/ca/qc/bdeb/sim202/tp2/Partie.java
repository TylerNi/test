package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Partie implements Serializable {

    private PlateauDeJeu plateauDeJeu;

    private LinkedList<Joueur> listeJoueur;

    private int indicateur;

    public Partie(PlateauDeJeu plateauDeJeu, LinkedList<Joueur> listeJoueur, int indicateur) {
        this.plateauDeJeu = plateauDeJeu;
        this.listeJoueur = listeJoueur;
        this.indicateur = indicateur;
    }

    public void commencerPartie() {
        System.out.println("************************ Le plateau ************************");
        Case[] liste = plateauDeJeu.getListeCase();

        for (int i = 0; i < liste.length; i++) {
            System.out.print("\033[34m" + i + ": \033[39m");
            System.out.println("\033[34m" + liste[i] + "\033[39m");
        }

        ChoixMenuDansPartie choix;
        do {
            Joueur joueurActuel;

            for (Joueur j : listeJoueur) {
                if (j.isFaillite()) {
                    System.out.println("\033[36m" + j.getNom() + " a fait faillite \033[39m");
                } else {
                    System.out.println("\033[36m" + j.getNom() + " est sur la case : " + liste[j.getPosition()].getNomCase() + " et possède " + j.getNombreArgent() + "$.\033[39m");
                }
            }

            joueurActuel = listeJoueur.poll();
            listeJoueur.add(joueurActuel);

            System.out.println("\033[36m" + "C'est au tour de " + joueurActuel.getNom() + "\033[35m");

            choix = menu();

            switch (choix) {
                case LANCER_DE -> {
                    int valeurDe = DePipe.lancer();
                }
                case SAUVEGARDER_ET_QUITTER -> {
                    //
                }
                case METTRE_FIN_ET_QUITTER -> {

                }
            }


        } while (choix != ChoixMenuDansPartie.METTRE_FIN_ET_QUITTER && choix != ChoixMenuDansPartie.SAUVEGARDER_ET_QUITTER);
    }

    public static ChoixMenuDansPartie menu() {
        Scanner sc = new Scanner(System.in);
        String choix;

        System.out.println("""
                1) Charger la partie de sauvegarde\s
                2) Commencer une nouvelle partie\s
                3) Quitter""");
        System.out.print("Faites votre choix (1,3): ");
        choix = sc.nextLine();

        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3")) {
            System.out.println("Le choix est invalide, il doit etre de 1, 2 ou 3");
            System.out.print("Faites votre choix (1,3): ");
            choix = sc.nextLine();
        }
        return ChoixMenuDansPartie.getValeurAvecIndice(choix);
    }



}
