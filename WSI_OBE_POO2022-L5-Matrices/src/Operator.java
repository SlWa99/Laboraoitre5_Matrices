/*
 -----------------------------------------------------------------------------------
 Nom du fichier  : Operator.java
 Nom du labo     : Laboratoire 5 POO : Matrice
 Auteur(s)       : Baume Oscar, Slimani Walid
 Date creation   : 12.10.2022

 Description     : Ce fichier défini la classe abstraite Operator, qui a pour seul élément la
                   méthode abstraite apply.

 Remarque(s)     : La méthode apply retourne le resultat de l'operation modéliser entre 2 entiers.

 Modification(s) : / aucune modification
 -----------------------------------------------------------------------------------
*/
public abstract class  Operator {
    /**
     * Nom          : apply
     * Description  : Fonction effectuant l'operation
     * @param left  : entier de gauche
     * @param right : entier de droite
     * @return      : Résultat de l'opération
     */
    public abstract int apply(int left, int right);
}
