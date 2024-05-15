package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * @author vikmo (Victor Morais)
 * <p>
 * ChoixMenu est une enum pour définir les options du menu 1
 */
public enum ChoixMenu implements Serializable {
    CHARGER_SAUVEGARDE("1"),
    NOUVELLE_PARTIE("2"),
    QUITTER("3");

    private String valeur;

    ChoixMenu(String valeur) {
        this.valeur = valeur;
    }

    public static ChoixMenu getValeurAvecIndice(String choix) {
        return switch (choix) {
            case "1" -> ChoixMenu.CHARGER_SAUVEGARDE;
            case "2" -> ChoixMenu.NOUVELLE_PARTIE;
            default -> ChoixMenu.QUITTER;
        };
    }
}