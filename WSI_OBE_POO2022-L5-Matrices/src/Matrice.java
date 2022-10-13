public class Matrice {
    // region Ctor
    public Matrice(int ligne, int colonne, int modulo) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.modulo = modulo;
        genererMatriceAleatoire(ligne, colonne, modulo);
    }

    public Matrice(int matrice[][], int modulo) {
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
    Matrice add(Matrice left){
        if(modulo != left.modulo){
            throw new RuntimeException("Modulo pas identique entre les 2 éléments de l'addition");
        }
        int outL = Math.max(ligne,left.ligne);
        int outC = Math.max(colonne,left.colonne);
        int[][] out = new int[outL][outC];
        for(int i = 0; i < outL; ++i){
            for(int j = 0; j < outL; ++j){
                if(i >= ligne || i >= left.ligne || j >= colonne || j >= left.colonne){
                    out[i][j] = 0;
                    continue;
                }
                out[i][j] = matrice[i][j] + left.matrice[i][j];
            }
        }
        Matrice outM = new Matrice(out,modulo);
        outM.modulo();
        return outM;
    }

    Matrice substract(Matrice left){
        if(modulo != left.modulo){
            throw new RuntimeException("Modulo pas identique entre les 2 éléments de la soustraction");
        }
        int outL = Math.max(ligne,left.ligne);
        int outC = Math.max(colonne,left.colonne);
        int[][] out = new int[outL][outC];
        for(int i = 0; i < outL; ++i){
            for(int j = 0; j < outL; ++j){
                if(i >= ligne || i >= left.ligne || j >= colonne || j >= left.colonne){
                    out[i][j] = 0;
                    continue;
                }
                out[i][j] = matrice[i][j] - left.matrice[i][j];
            }
        }
        Matrice outM = new Matrice(out,modulo);
        outM.modulo();
        return outM;
    }

    Matrice multiply(Matrice left){
        if(modulo != left.modulo){
            throw new RuntimeException("Modulo pas identique entre les 2 éléments de la multiplication");
        }
        int outL = Math.max(ligne,left.ligne);
        int outC = Math.max(colonne,left.colonne);
        int[][] out = new int[outL][outC];
        for(int i = 0; i < outL; ++i){
            for(int j = 0; j < outL; ++j){
                if(i >= ligne || i >= left.ligne || j >= colonne || j >= left.colonne){
                    out[i][j] = 0;
                    continue;
                }
                out[i][j] = matrice[i][j] * left.matrice[i][j];
            }
        }
        Matrice outM = new Matrice(out,modulo);
        outM.modulo();
        return outM;

    }

    private void modulo(){
        for(int i = 0; i < ligne; i++){
            for(int j = 0; j < ligne; j++){
                matrice[i][j] = Math.floorMod(matrice[i][j],modulo);
            }
        }
    }

    @Override
    public String toString() {
        String m = "[";

        for (int i = 0; i < ligne; ++i) {
            m += "[";
            for (int j = 0; j < colonne; ++j) {
                m += matrice[i][j];
                if (j < colonne - 1 )
                    m += ", ";
            }
            m += "]";

            if (i < ligne - 1) {
                m += ", ";
            }
        }
        m += "]";

        return m;
    }
    // endregion

    // region Méthodes privées
    private void genererMatriceAleatoire(int ligne, int colonne, int modulo) {
        matrice = new int[ligne][colonne];
        for (int i = 0; i < ligne; ++i) {
            for (int j = 0; j < colonne; ++j) {
                matrice[i][j] = (int) (Math.random() * modulo);
            }
        }
    }

    private void generateMatriceWhitModel(int matrice[][], int module) {
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
