package ca.qc.bdeb.sim202.tp2;

import java.io.Serializable;

/**
 * @author vikmo (Victor Morais)
 * <p>
 * ChoixMenu est une enum pour définir les options du menu 1
 */
/**
 * Énumération représentant les options du menu dans une partie du jeu.
 * Cette énumération est sérialisable pour permettre la sauvegarde et le chargement de l'état du jeu.
 */
public enum ChoixMenuDansPartie implements Serializable {
    LANCER_DE("1"),
    SAUVEGARDER_ET_QUITTER("2"),
    METTRE_FIN_ET_QUITTER("3");

    private String valeur;

    /**
     * Constructeur pour l'énumération ChoixMenuDansPartie.
     *
     * @param valeur la valeur de l'option du menu
     */
    ChoixMenuDansPartie(String valeur) {
        this.valeur = valeur;
    }

    /**
     * Renvoie l'option du menu correspondant à la valeur donnée.
     *
     * @param choix la valeur de l'option du menu
     * @return l'option du menu correspondant à la valeur donnée
     */
    public static ChoixMenuDansPartie getValeurAvecIndice(String choix) {
        return switch (choix) {
            case "1" -> ChoixMenuDansPartie.LANCER_DE;
            case "2" -> ChoixMenuDansPartie.SAUVEGARDER_ET_QUITTER;
            default -> ChoixMenuDansPartie.METTRE_FIN_ET_QUITTER;
        };
    }
}