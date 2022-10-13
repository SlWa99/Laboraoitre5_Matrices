public class Main {
    public static void main(String[] args) {

        Matrice m1 = new Matrice(2, 3, 45);

        Matrice m2 = new Matrice(3, 5, 7);

        Matrice m3 = new Matrice(new int[][] {{1, 2, 3},
                                              {4, 5, 6}}, 45);

        System.out.print(m3);
    }
}