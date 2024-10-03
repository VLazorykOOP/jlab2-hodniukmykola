import java.util.Scanner;

public class Rational {
    private int numerator;   // чисел
    private int denominator; // знам

    
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); 
    }

    
    private void reduce() {
        int gcd = gcd(numerator, denominator); // НСД
        numerator /= gcd;
        denominator /= gcd;

        
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;//додавання
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;//віднімання
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Rational) {
            Rational other = (Rational) obj;
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }

    public boolean lessThan(Rational other) {
        return this.numerator * other.denominator < other.numerator * this.denominator;
    }

        public boolean greaterThan(Rational other) {
        return this.numerator * other.denominator > other.numerator * this.denominator;
    }
    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    public static Rational inputRational(Scanner scanner) {
        System.out.print("Введіть чисельник: ");
        int numerator = scanner.nextInt();
        System.out.print("Введіть знаменник: ");
        int denominator = scanner.nextInt();
        return new Rational(numerator, denominator);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Введіть перший дріб:");
        Rational r1 = inputRational(scanner);

        System.out.println("Введіть другий дріб:");
        Rational r2 = inputRational(scanner);

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));
        System.out.println("r1 == r2: " + r1.equals(r2));
        System.out.println("r1 < r2: " + r1.lessThan(r2));
        System.out.println("r1 > r2: " + r1.greaterThan(r2));

        scanner.close();
    } 
}
 