public class Vector3D {
    private static final Vector3D ZERO_VECTOR = new Vector3D(0, 0, 0);

    private double x;
    private double y;
    private double z;

    public Vector3D() {
        this(0, 0, 0);
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3D getZeroVector() {
        return ZERO_VECTOR;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vector3D multiplyByScalar(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) obj;
            if (this.x == vector3D.getX() &&
                this.y == vector3D.getY() &&
                this.z == vector3D.getZ()) {
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Vector3D vectorA = new Vector3D(1, 2, 3);
        Vector3D vectorB = new Vector3D(4, 5, 6);

        Vector3D sum = vectorA.add(vectorB);
        Vector3D difference = vectorA.subtract(vectorB);
        double dotProduct = vectorA.dotProduct(vectorB);
        Vector3D scaledVector = vectorA.multiplyByScalar(2);
        double magnitudeA = vectorA.calculateMagnitude();
        double magnitudeB = vectorB.calculateMagnitude();

        System.out.println("Vector A: " + vectorA);
        System.out.println("Vector B: " + vectorB);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Dot Product: " + dotProduct);
        System.out.println("Scaled Vector A: " + scaledVector);
        System.out.println("Magnitude of A: " + magnitudeA);
        System.out.println("Magnitude of B: " + magnitudeB);
        System.out.println("Magnitude of B: " + magnitudeB);

        boolean areEqual = vectorA.equals(vectorB);
        System.out.println("Are Vector A and Vector B equal? " + areEqual);
    }
}
