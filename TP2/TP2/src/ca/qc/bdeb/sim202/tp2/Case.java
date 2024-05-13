package ca.qc.bdeb.sim202.tp2;

public abstract class Case {

    protected String typeCase;
    protected String nomCase;
    protected String descriptionCase;

    public Case (String typeCase, String nomCase, String descriptionCase){
        this.typeCase = typeCase;
        this.nomCase = nomCase;
        this.descriptionCase = descriptionCase;
    }

    public String getNomCase() {
        return nomCase;
    }

    public String getDescriptionCase() {
        return descriptionCase;
    }

    public void setNomCase(String nomCase) {
        this.nomCase = nomCase;
    }

    public void setDescriptionCase(String descriptionCase) {
        this.descriptionCase = descriptionCase;
    }

    abstract void faireAction(Joueur joueur);
}
