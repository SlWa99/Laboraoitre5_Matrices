public class Matrice {
    // region Ctor
    public Matrice(int ligne, int colonne, int modulo) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.modulo = modulo;
        generateRandomMatrice(ligne, colonne, modulo);
    }

    public Matrice(int[][] matrice, int modulo) {
        this.modulo = modulo;
        try {
            generateMatriceWhitModel(matrice, modulo);
        }
        catch (RuntimeException e) {
            throw e;
        }
    }
    //endregion

    // region Paramètres privés
    private int ligne;
    private int colonne;
    private int modulo;
    private int[][] matrice;
    // endregion

    // region Méthodes publiques
    public Matrice add(Matrice right) {
        try{
            return applyOperation(this,right, new Addition());
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    public Matrice substract(Matrice right) {
        try{
            return applyOperation(this,right, new Substraction());
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    public Matrice multiply(Matrice right) {
        try{
            return applyOperation(this,right, new Multiplication());
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        String m = "";

        for (int i = 0; i < ligne; ++i) {
            for (int j = 0; j < colonne; ++j) {
                m += matrice[i][j];
            }
            m += "\n";
        }
        return m;
    }
    // endregion

    // region Méthodes privées
    private void generateRandomMatrice(int ligne, int colonne, int modulo) {
        matrice = new int[ligne][colonne];
        for (int i = 0; i < ligne; ++i) {
            for (int j = 0; j < colonne; ++j) {
                matrice[i][j] = (int) (Math.random() * modulo);
            }
        }
    }

    private void generateMatriceWhitModel(int[][] matrice, int modulo) {
        if (matrice.length > 0)
            ligne = matrice.length;

        else return;

        if (matrice[0].length > 0)
            colonne = matrice[0].length;

        else return;

        for (int[] l : matrice) {
            for(int i : l) {
                if(i >= modulo) {
                    throw new RuntimeException("Valeur max de la matrice >= modulo");
                }
            }
        }
        this.matrice = matrice;
    }

    private void reformatMatriceWithModulo() {
        for(int i = 0; i < ligne; i++) {
            for(int j = 0; j < colonne; j++) {
                matrice[i][j] = Math.floorMod(matrice[i][j], modulo);
            }
        }
    }

    private Matrice applyOperation(Matrice left, Matrice right, Operator operator) {
        if(right.modulo != left.modulo) {
            throw new RuntimeException("Modulo pas identique entre les 2 éléments de l'operation");
        }

        int outL = Math.max(right.ligne,left.ligne);
        int outC = Math.max(right.colonne,left.colonne);

        Matrice out = new Matrice(outL,outC,modulo);
        for(int i = 0; i < outL; ++i) {
            for(int j = 0; j < outC; ++j) {
                if( i >= left.ligne  || j >= left.colonne) {
                    out.matrice[i][j] = operator.apply(0, right.matrice[i][j]);
                    continue;
                }

                if(i >= right.ligne  || j >= right.colonne ) {
                    out.matrice[i][j] = operator.apply(left.matrice[i][j],0);
                    continue;
                }
                out.matrice[i][j] = operator.apply(left.matrice[i][j], right.matrice[i][j]);
            }
        }
        out.reformatMatriceWithModulo();
        return out;
    }
    // endregion
}
