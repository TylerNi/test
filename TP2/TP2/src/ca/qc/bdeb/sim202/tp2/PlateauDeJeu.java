package ca.qc.bdeb.sim202.tp2;


import javax.imageio.stream.ImageOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Classe représentant le plateau de jeu.
 * Cette classe est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public class PlateauDeJeu implements Serializable {

    private static final String PLATEAU_BIN = "TP2/TP2/plateau.bin";

    private Boolean estValide = true;

    private Case[] listeCase = new Case[15];

    /**
     * Constructeur pour la classe PlateauDeJeu.
     * Charge et valide le plateau de jeu à partir d'un fichier binaire.
     */
    public PlateauDeJeu() {

        try (DataInputStream lecteur = new DataInputStream(new FileInputStream(PLATEAU_BIN))){
            System.out.print("Chargement et validation du plateau de jeu : ");

            for (int i = 0; i < listeCase.length; i++) {
                String typeCase = null;
                String nom = null;
                String description = null;
                int valeur = 0;
                int montantPayer = 0;

                typeCase = lecteur.readUTF();
                nom = lecteur.readUTF();
                if (!typeCase.equals("T") && !typeCase.equals("SP")) {
                    description = lecteur.readUTF();
                } else {
                    valeur = lecteur.readInt();
                }

                if (!typeCase.equals("SP")) {
                    montantPayer = lecteur.readInt();
                }

                switch(typeCase) {
                    case "D":
                        listeCase[i] = new Depart(typeCase, nom, description, montantPayer);
                        break;
                    case "T":
                        listeCase[i] = new Terrain(typeCase,null, valeur,montantPayer, nom);
                        break;
                    case "Tx":
                        listeCase[i] = new Taxe(typeCase,nom,description, montantPayer);
                        break;
                    case "SP":
                        listeCase[i] = new ServicePublic(typeCase,null, valeur, nom);
                        break;
                    case "P":
                        listeCase[i] = new Stationnement(typeCase,nom,description, montantPayer);
                        break;

                }


            }

            if (!listeCase[0].getTypeCase().equals("D")){
                estValide = false;
                System.out.println("\033[31m Erreur car la première case n'est pas une case départ \033[39m");
            }
            boolean contientSP = false;
            boolean contientT = false;
            boolean contientD = false;
            boolean contientTx = false;
            boolean contientP = false;

            for (int i = 0; i < listeCase.length; i++) {
                switch (listeCase[i].getTypeCase()){
                    case "SP" :
                        contientSP = true;
                        break;
                    case "T" :
                        contientT = true;
                        break;
                    case "D" :
                        contientD = true;
                        break;
                    case "Tx" :
                        contientTx = true;
                        break;
                    case "P" :
                        contientP = true;
                        break;
                }
            }

            if (!contientSP || !contientD || !contientTx || !contientP || !contientT) {
                estValide = false;
                System.out.println("\033[31m Erreur car le plateau de jeu ne contient pas tous les types de case \033[39m");
            }

            if (estValide) {
                System.out.println("\033[32m Ok \033[39m");
            }



        } catch (IOException e) {
            System.out.println("\033[31m Erreur avec le fichier \033[39m");
            System.out.println(e);
        }
    }

    /**
     * Renvoie la liste des cases sur le plateau de jeu.
     *
     * @return un tableau de cases
     */
    public Case[] getListeCase() {
        return listeCase;
    }
}
