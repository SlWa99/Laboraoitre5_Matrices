public class Matrice {
    // region Ctor

    //endregion

    // region Paramètres privés

    private int ligne;
    private int colonne;
    private int modulo;
    private int[][] matrice;


    // endregion
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

    // region Méthodes publiques
}
