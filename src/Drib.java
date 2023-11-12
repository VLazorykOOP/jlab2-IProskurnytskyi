public class Drib {
    private int numerator;
    private int denominator;

    public Drib() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Drib(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Drib add(Drib other) {
        int resultNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int resultDenominator = this.denominator * other.denominator;
        return new Drib(resultNumerator, resultDenominator);
    }

    public Drib subtract(Drib other) {
        int resultNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int resultDenominator = this.denominator * other.denominator;
        return new Drib(resultNumerator, resultDenominator);
    }

    public Drib multiply(Drib other) {
        int resultNumerator = this.numerator * other.numerator;
        int resultDenominator = this.denominator * other.denominator;
        return new Drib(resultNumerator, resultDenominator);
    }

    public Drib divide(Drib other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int resultNumerator = this.numerator * other.denominator;
        int resultDenominator = this.denominator * other.numerator;
        return new Drib(resultNumerator, resultDenominator);
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj instanceof Drib) {
            Drib other = (Drib) obj;
            if (this.numerator == other.numerator &&
                this.denominator == other.denominator) {
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Drib drib1 = new Drib(1, 2);
        Drib drib2 = new Drib(3, 4);

        Drib sum = drib1.add(drib2);
        Drib difference = drib1.subtract(drib2);
        Drib product = drib1.multiply(drib2);
        Drib quotient = drib1.divide(drib2);

        System.out.println("Drib 1: " + drib1);
        System.out.println("Drib 2: " + drib2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Are Drib 1 and Drib 2 equal? " + drib1.equals(drib2));
    }
}
