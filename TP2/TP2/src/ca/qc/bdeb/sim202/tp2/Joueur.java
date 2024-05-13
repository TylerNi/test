package ca.qc.bdeb.sim202.tp2;

public class Joueur {
    private String nom;
    private int nombreArgent;
    private int position;

    public Joueur (String nom, int nombreArgent, int position){
        this.nom = nom;
        this.nombreArgent = 50;
        this.position = 50;
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
}


