package ca.qc.bdeb.sim202.tp2;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class PlateauDeJeu {

    private static final String PLATEAU_BIN = "TP2/TP2/plateau.bin";

    private Boolean estValide = true;

    private Case[] listeCase = new Case[15];

    public PlateauDeJeu() {

        try (DataInputStream lecteur = new DataInputStream(new FileInputStream(PLATEAU_BIN))){

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
                        listeCase[i] = new Stationnement(typeCase,nom,description);
                        break;

                }


            }

            if (!listeCase[0].getNomCase().equals("Départ")){
                estValide = false;
            }
            boolean contientSP = false;
            boolean contientT = false;
            boolean contientD = false;
            boolean contientTx = false;
            boolean contientP = false;

            for (int i = 0; i < listeCase.length; i++) {
                switch (listeCase[i].getTypeCase()){
                    case "Sp" :
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
            }



        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
