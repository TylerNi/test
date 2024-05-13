package ca.qc.bdeb.sim202.tp2;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class PlateauDeJeu {

    private static final String PLATEAU_BIN = "TP2/TP2/plateau.bin";
    private String victor;

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
                        listeCase[i] = new Depart(nom, description, montantPayer);
                        break;
                    case "T":
                        listeCase[i] = new Terrain(null, valeur,montantPayer, nom, description);
                        break;
                    case "Tx":
                        listeCase[i] = new Taxe(nom,description, montantPayer);
                        break;
                    case "SP":
                        listeCase[i] = new ServicePublic(null, valeur, nom,description);
                        break;
                    case "P":
                        listeCase[i] = new Stationnement(nom,description);
                        break;

                }

            }


        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
