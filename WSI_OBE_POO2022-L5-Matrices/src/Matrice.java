public class Matrice {
    // region Ctor

    public Matrice(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    //endregion


    // region Paramètres privés
    private int ligne;

    private int colonne;

    private int[][] tab = new int[ligne][colonne];

    // endregion

    // region Méthodes publiques
}
