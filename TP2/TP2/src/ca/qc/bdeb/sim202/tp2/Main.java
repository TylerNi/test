package ca.qc.bdeb.sim202.tp2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        switch (menu()) {
            case CHARGER_SAUVEGARDE -> {

            }
            case NOUVELLE_PARTIE -> {
                System.out.println("\033[33mCréation d'une nouvelle partie \033[39m");
                PlateauDeJeu plateauDeJeu = new PlateauDeJeu();
                System.out.println();
                LinkedList<Joueur> listeJoueur = MenuListeJoueur();
                Partie partie = new Partie(plateauDeJeu, listeJoueur, 0);
                partie.commencerPartie();
            }
            case QUITTER -> {
                System.out.println("Merci d'avoir jouer, à la prochaine");
            }
        }


    }

    public static ChoixMenu menu() {
        Scanner sc = new Scanner(System.in);
        String choix;

        System.out.println("""
                TP2 sim202 de Victor Morais et Tyler Nichols
                ************ MONTREALOPOY ************ \s
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
        return ChoixMenu.getValeurAvecIndice(choix);
    }

    public static LinkedList<Joueur> MenuListeJoueur() {
        int nombreJoueur;
        LinkedList<Joueur> listeJoueur;
        do {
            listeJoueur = new LinkedList<>();
            Scanner sc = new Scanner(System.in);
            nombreJoueur = 0;

            for (int i = 1; i <= 5; i++) {
                System.out.print("Saisir le nom du joueur " + i + " (ou vide si la saisit est terminée) :");
                String nomJoueur = sc.nextLine();
                if (!nomJoueur.isEmpty()) {
                    listeJoueur.add(new Joueur(nomJoueur, 500, 0));
                    nombreJoueur++;
                } else {
                    break;
                }
            }
            if (nombreJoueur < 2) {
                System.out.println("il faut un minimum de 2 joueurs pour commencer, veuillez recommencer");
            }
        } while (nombreJoueur < 2);

        return listeJoueur;

    }
}