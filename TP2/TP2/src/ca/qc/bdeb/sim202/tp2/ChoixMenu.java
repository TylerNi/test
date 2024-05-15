package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * @author vikmo (Victor Morais)
 * <p>
 * ChoixMenu est une enum pour définir les options du menu 1
 */
/**
 * Énumération représentant les options du menu dans le jeu.
 * Cette énumération est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public enum ChoixMenu implements Serializable {
    CHARGER_SAUVEGARDE("1"),
    NOUVELLE_PARTIE("2"),
    QUITTER("3");

    private String valeur;

    /**
     * Constructeur pour l'énumération ChoixMenu.
     *
     * @param valeur la valeur de l'option du menu
     */
    ChoixMenu(String valeur) {
        this.valeur = valeur;
    }

    /**
     * Renvoie l'option du menu correspondant à la valeur donnée.
     *
     * @param choix la valeur de l'option du menu
     * @return l'option du menu correspondant à la valeur donnée
     */
    public static ChoixMenu getValeurAvecIndice(String choix) {
        return switch (choix) {
            case "1" -> ChoixMenu.CHARGER_SAUVEGARDE;
            case "2" -> ChoixMenu.NOUVELLE_PARTIE;
            default -> ChoixMenu.QUITTER;
        };
    }
}