public class Main {
    public static void main(String[] args) {

        final int MODULO = 5;

        Matrice one = new Matrice(new int[][] {{1,3,1,1},{3,2,4,2},{1,0,1,0}}, MODULO);
        Matrice two = new Matrice(new int[][] {{1,4,2,3,2},{0,1,0,4,2},{0,0,2,0,2}}, MODULO);

        System.out.println("The modulus is " + MODULO);

        System.out.println("one");
        System.out.println(one);

        System.out.println("two");
        System.out.println(two);

        System.out.println("one + two");
        System.out.println(one.add(two));

        System.out.println("one - two");
        System.out.println(one.substract(two));

        System.out.println("one x two");
        System.out.println(one.multiply(two));
    }
}