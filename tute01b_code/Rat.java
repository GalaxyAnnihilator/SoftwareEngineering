package tute01b_code;

/**
 * A class representing a rational number.
 */
public class Rat {
    private int numerator;
    private int denominator;

    /**
     * @effects: Constructs a rational number with the given numerator and denominator.
     * @param numerator The numerator of the rational number.
     * @param denominator The denominator of the rational number (must not be zero).
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public Rat(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    /**
     * @effects
     * Returns the greatest common divisor of two numbers.
     */
    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    /**
     * @effects
     * Adds this rational number to another.
     */
    public Rat add(Rat other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Rat(num, den);
    }

    /**
     * @effects
     * Subtracts another rational number from this one.
     */
    public Rat subtract(Rat other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Rat(num, den);
    }

    /**
     * @effects
     * Multiplies this rational number by another.
     */
    public Rat multiply(Rat other) {
        return new Rat(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    /**
     * @effects
     * Divides this rational number by another.
     */
    public Rat divide(Rat other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return new Rat(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    /**
     * @effects
     * Returns a string representation of this rational number.
     */
    @Override
    public String toString() {
        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }
}

