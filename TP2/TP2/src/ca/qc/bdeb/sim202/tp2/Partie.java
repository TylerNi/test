package ca.qc.bdeb.sim202.tp2;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe représentant une partie du jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class Partie implements Serializable {

    private static final String SAUVEGARDE_DAT = "TP2/TP2/sauvegarde.dat";

    private PlateauDeJeu plateauDeJeu;

    private LinkedList<Joueur> listeJoueur;

    private boolean partieEstTerminer;

    private LinkedList<Joueur> gagnant;

    /**
     * Constructeur de la classe Partie.
     * @param plateauDeJeu Le plateau de jeu sur lequel la partie se déroule.
     * @param listeJoueur La liste des joueurs participant à la partie.
     */
    public Partie(PlateauDeJeu plateauDeJeu, LinkedList<Joueur> listeJoueur) {
        this.plateauDeJeu = plateauDeJeu;
        this.listeJoueur = listeJoueur;
        this.partieEstTerminer = false;
        this.gagnant = new LinkedList<>();
    }

    /**
     * Méthode pour introduire la partie.
     */
    public void introPArtie() {
        System.out.println();
        System.out.println("************************ Le plateau ************************");
        Case[] liste = plateauDeJeu.getListeCase();

        for (int i = 0; i < liste.length; i++) {
            System.out.print("\033[34m" + i + ": \033[39m");
            System.out.println("\033[34m" + liste[i] + "\033[39m");
        }

    }

    /**
     * Méthode pour jouer la partie.
     * Qui a chaque manche propose 3 options, soit sauvegarder, fini la partie ou lancer le dé.
     * Cette méthode va ensuite executer les actions associés au choix fait.
     */
    public void jouerPartie() {
        if (!partieEstTerminer) {
            Case[] liste = plateauDeJeu.getListeCase();
            ChoixMenuDansPartie choix = null;
            do {
                int nbJoueurFaillite = 0;
                for (Joueur j : listeJoueur) {
                    if (j.isFaillite()) {
                        nbJoueurFaillite++;
                    }
                }

                if (nbJoueurFaillite == 1) {
                    partieEstTerminer = true;
                    gagnant = determinerGagant();
                }


                if (!partieEstTerminer) {
                    Joueur joueurActuel;

                    System.out.println();
                    System.out.println("********** Les joueurs **********");
                    for (Joueur j : listeJoueur) {
                        if (j.isFaillite()) {
                            System.out.println("\033[36m" + j.getNom() + " a fait faillite \033[39m");
                        } else {
                            System.out.println("\033[36m" + j.getNom() + " est sur la case : " + liste[j.getPosition()].getNomCase() + " et possède " + j.getNombreArgent() + "$.\033[39m");
                        }
                    }

                    joueurActuel = listeJoueur.poll();

                    if (!joueurActuel.isFaillite()) {
                        System.out.println();
                        System.out.println("\033[96m" + "C'est au tour de " + joueurActuel.getNom() + "\033[35m");
                    }

                    choix = menu();

                    switch (choix) {
                        case LANCER_DE -> {
                            if (!joueurActuel.isFaillite()) {
                                int valeurDe = DePipe.lancer();
                                System.out.println(joueurActuel.getNom() + " a obtenu: " + valeurDe);

                                if (joueurActuel.getPosition() == 14) {
                                    joueurActuel.setPosition(0);
                                    for (int i = joueurActuel.getPosition(); i < joueurActuel.getPosition() + valeurDe; i++) {
                                        plateauDeJeu.getListeCase()[i].survolerCase(joueurActuel);
                                    }
                                    joueurActuel.setPosition(joueurActuel.getPosition() + valeurDe);

                                } else if ((joueurActuel.getPosition() + valeurDe) > 14) {
                                    int valeurDe1 = (14 - joueurActuel.getPosition());
                                    int valeurDe2 = valeurDe - valeurDe1;

                                    for (int i = joueurActuel.getPosition() + 1; i < joueurActuel.getPosition() + valeurDe1; i++) {
                                        plateauDeJeu.getListeCase()[i].survolerCase(joueurActuel);
                                    }
                                    joueurActuel.setPosition(0);
                                    for (int i = joueurActuel.getPosition(); i < joueurActuel.getPosition() + valeurDe2; i++) {
                                        plateauDeJeu.getListeCase()[i].survolerCase(joueurActuel);
                                    }
                                    joueurActuel.setPosition(joueurActuel.getPosition() + valeurDe2);


                                } else {
                                    for (int i = joueurActuel.getPosition() + 1; i < joueurActuel.getPosition() + valeurDe; i++) {
                                        plateauDeJeu.getListeCase()[i].survolerCase(joueurActuel);
                                    }
                                    joueurActuel.setPosition(joueurActuel.getPosition() + valeurDe);
                                }

                                plateauDeJeu.getListeCase()[joueurActuel.getPosition()].faireAction(joueurActuel, valeurDe);
                                System.out.println();


                            }
                            listeJoueur.add(joueurActuel);
                        }
                        case SAUVEGARDER_ET_QUITTER -> {
                            listeJoueur.add(joueurActuel);
                        }
                        case METTRE_FIN_ET_QUITTER -> {
                            listeJoueur.add(joueurActuel);
                            partieEstTerminer = true;
                            gagnant = determinerGagant();
                        }
                    }
                }


            } while (choix != ChoixMenuDansPartie.METTRE_FIN_ET_QUITTER && choix != ChoixMenuDansPartie.SAUVEGARDER_ET_QUITTER && !partieEstTerminer);

            if (choix == ChoixMenuDansPartie.SAUVEGARDER_ET_QUITTER) {
                System.out.println("La partie a été sauvegardée");
            } else {
                if (gagnant.size() == 1) {
                    System.out.println("La partie est terminée et le gagant est " + gagnant.get(0).getNom());
                } else {
                    System.out.print("La partie est terminée et les gagants sont ");
                    for (Joueur j : gagnant) {
                        System.out.print(j.getNom() + " ");
                    }
                }
            }

        } else {
            System.out.println("La partie est deja terminée");
        }
    }

    /**
     * Détermine le ou les gagnants de la partie.
     *
     * @return une liste de joueurs qui ont gagné la partie
     */
    private LinkedList<Joueur> determinerGagant() {
        int tempArgent = 0;
        LinkedList<Joueur> tempJoueurRiche = new LinkedList<>();

        for (Joueur j : listeJoueur) {
            if (!j.isFaillite()) {
                if (j.retourneArgentTotal() == tempArgent) {
                    tempJoueurRiche.add(j);
                } else if (j.retourneArgentTotal() > tempArgent) {
                    tempArgent = j.retourneArgentTotal();
                    tempJoueurRiche.clear();
                    tempJoueurRiche.add(j);
                }
            }
        }

        System.out.println();
        System.out.println("\033[39m************** Tableau de l'argent et des propriétés des joueurs à la fin de la partie **************\033[39m");
        for (Joueur j : listeJoueur) {
            System.out.println(j);
        }

        return tempJoueurRiche;
    }

    /**
     * Affiche un menu pour le joueur et renvoie le choix du joueur.
     *
     * @return le choix du joueur sous forme de valeur de l'énumération ChoixMenuDansPartie
     */
    public static ChoixMenuDansPartie menu() {
        Scanner sc = new Scanner(System.in);
        String choix;

        System.out.println("""
                                
                1) Lancer le dé\s
                2) Sauvegarder et quitter\s
                3) Mettre fin et quitter""");
        System.out.print("Faites votre choix (1,3): ");
        choix = sc.nextLine();
        if (choix.isEmpty()) {
            choix = "1";
        }

        while (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.isEmpty()) {
            System.out.println("Le choix est invalide, il doit etre de 1, 2 ou 3");
            System.out.print("Faites votre choix (1,3): ");
            choix = sc.nextLine();
        }
        return ChoixMenuDansPartie.getValeurAvecIndice(choix);
    }

    /**
     * Sauvegarde l'état actuel de la partie dans un fichier.
     *
     * @param partie la partie à sauvegarder
     */
    public static void sauvegarderPartie(Partie partie) {
        try (FileOutputStream fos = new FileOutputStream(SAUVEGARDE_DAT);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(partie);
        } catch (IOException e) {
            System.out.println("Erreur d'entrées-sorties");
        }
    }

    /**
     * Lit l'état d'une partie à partir d'un fichier.
     *
     * @return la partie lue à partir du fichier
     */
    public static Partie lirePartie() {
        try (FileInputStream fichier = new FileInputStream(SAUVEGARDE_DAT);
             ObjectInputStream ois = new ObjectInputStream(fichier)) {

            return (Partie) ois.readObject();

        } catch (java.io.IOException e) {
            System.out.println("Erreur d'entrées-sorties");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur classe introuvable");
        }
        return null;
    }

    /**
     * Renvoie si la partie est terminée ou non.
     *
     * @return vrai si la partie est terminée, faux sinon
     */
    public boolean isPartieEstTerminer() {
        return partieEstTerminer;
    }
}
