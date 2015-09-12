package fraction;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 * There's no weird code here, just a bunch of math that you can google if you don't understand it. So no comments.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        checkForZeroDenominator(denominator);

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public boolean isNegative() {
        return this.numerator < 0 ^ this.denominator < 0;
    }

    public Fraction add(Fraction other) {
        checkForZeroDenominator(this.denominator);
        checkForZeroDenominator(other.denominator);

        if(this.denominator == other.denominator) {
            return new Fraction(this.numerator + other.numerator, this.denominator);
        }
        else {
            return new Fraction((this.numerator * other.denominator) + (other.numerator * this.denominator),
                    this.denominator * other.denominator);
        }
    }

    public Fraction subtract(Fraction other) {
        checkForZeroDenominator(this.denominator);
        checkForZeroDenominator(other.denominator);

        if(this.denominator == other.denominator) {
            return new Fraction(this.numerator - other.numerator, this.denominator);
        }
        else {
            return new Fraction((this.numerator * other.denominator) - (other.numerator * this.denominator),
                    this.denominator * other.denominator);
        }
    }

    public Fraction multiply(Fraction other) {
        checkForZeroDenominator(this.denominator);
        checkForZeroDenominator(other.denominator);

        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        checkForZeroDenominator(this.denominator);
        checkForZeroDenominator(other.denominator);

        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public boolean isEqualTo(Fraction other) {
        return this.numerator * other.denominator == other.numerator * this.denominator;
    }

    public String toString() {
        return this.numerator + "\r\n-\r\n" + this.denominator;
    }

    private void checkForZeroDenominator(int denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
    }
}
