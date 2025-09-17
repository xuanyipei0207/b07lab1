public class Polynomial {
    private double[] coeffs;

    // No-argument constructor (polynomial = 0)
    public Polynomial() {
        coeffs = new double[]{0};
    }

    // Constructor with coefficients
    public Polynomial(double[] c) {
        coeffs = c.clone();
    }

    // Add two polynomials
    public Polynomial add(Polynomial other) {
        int maxLen = Math.max(this.coeffs.length, other.coeffs.length);
        double[] sum = new double[maxLen];

        for (int i = 0; i < maxLen; i++) {
            double a = (i < this.coeffs.length) ? this.coeffs[i] : 0;
            double b = (i < other.coeffs.length) ? other.coeffs[i] : 0;
            sum[i] = a + b;
        }
        return new Polynomial(sum);
    }

    // Evaluate polynomial at x
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    // Check if x is a root
    public boolean hasRoot(double x) {
        return Math.abs(evaluate(x)) < 1e-9;
    }
}
