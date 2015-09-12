package fraction;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class FractionMain {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 4);
        Fraction f2 = new Fraction(5, 20);
        Fraction f3 = new Fraction(4, 8);
        Fraction f4 = new Fraction(-3, 5);

        if(f4.isNegative()) {
            System.out.println("This shit is negative:\r\n" + f4.toString());
        }

        System.out.println();

        System.out.println("Adding\r\n" + f1.toString() + "\r\nto\r\n" + f2.toString());
        System.out.println("Sum:\r\n" + f2.add(f1));

        System.out.println();

        System.out.println("Subtracting\r\n" + f1.toString() + "\r\nfrom\r\n" + f2.toString());
        System.out.println("Difference:\r\n" + f2.subtract(f1));

        System.out.println();

        System.out.println("Multiplying\r\n" + f1.toString() + "\r\nby\r\n" + f2.toString());
        System.out.println("Product:\r\n" + f1.multiply(f2));

        System.out.println();

        System.out.println("Dividing\r\n" + f1.toString() + "\r\nby\r\n" + f2.toString());
        System.out.println("Quotient:\r\n" + f1.divide(f2));

        System.out.println();

        if(f1.isEqualTo(f3)) {
            System.out.println("This shit\r\n" + f1.toString() + "\r\nis equal to this shit\r\n" + f3.toString());
        }
    }
}
