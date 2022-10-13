public class Matrice {
    // region Ctor
    public Matrice(int ligne, int colonne, int modulo) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.modulo = modulo;
        genererMatriceAleatoire(ligne, colonne, modulo);
    }

    public Matrice(int matrice[][], int modulo) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.modulo = modulo;
        generateMatriceWhitModel(matrice, modulo);
    }



    //endregion


    // region Paramètres privés
    private int ligne;

    private int colonne;

    private int modulo;

    private int[][] matrice;
    // endregion

    // region Méthodes publiques

    // endregion

    // region Méthodes privées
    private void genererMatriceAleatoire(int ligne, int colonne, int modulo) {
        for (int i = 0; i < ligne; ++i) {
            for (int j = 0; j < colonne; ++j) {
                matrice[i][j] = (int) (Math.random() * modulo);
            }
        }
    }

    private void generateMatriceWhitModel(int matrice[][], int module) {
        int ligne = 0;
        int colonne = 0;

        if (matrice.length > 0)
            ligne = matrice.length;

        else return;

        if (matrice[0].length > 0)
            colonne = matrice[0].length;

        else return;

        this.matrice = matrice;
    }
    // endregion
}
