/*
 -----------------------------------------------------------------------------------
 Nom du fichier  : Multiplcation.java
 Nom du labo     : Laboratoire 5 POO : Matrice
 Auteur(s)       : Baume Oscar, Slimani Walid
 Date creation   : 12.10.2022

 Description     : Ce fichier défini la classe Multiplcation héritant de Operator.

 Remarque(s)     : La méthode apply retourne le resultat de la multiplication entre 2 entiers.

 Modification(s) : / aucune modification
 -----------------------------------------------------------------------------------
*/
public class Multiplication extends Operator {
    @Override
    public int apply(int left, int right) {
        return left * right;
    }
}
