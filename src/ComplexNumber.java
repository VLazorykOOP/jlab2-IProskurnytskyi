public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getMagnitude() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double getArgument() {
        return Math.atan2(imaginary, real);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = this.real * other.real - this.imaginary * other.imaginary;
        double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double resultReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double resultImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj instanceof ComplexNumber) {
            ComplexNumber other = (ComplexNumber) obj;
            if (this.real == other.real &&
                this.imaginary == other.imaginary) {
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(3, 4);
        ComplexNumber num2 = new ComplexNumber(1, 2);

        ComplexNumber sum = num1.add(num2);
        ComplexNumber difference = num1.subtract(num2);
        ComplexNumber product = num1.multiply(num2);
        ComplexNumber quotient = num1.divide(num2);
        ComplexNumber conjugate = num1.conjugate();

        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);
        System.out.println("Magnitude of Number 1: " + num1.getMagnitude());
        System.out.println("Argument of Number 1: " + num1.getArgument());
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Conjugate of Number 1: " + conjugate);
        System.out.println("Are Number 1 and Number 2 equal? " + num1.equals(num2));
    }
}
