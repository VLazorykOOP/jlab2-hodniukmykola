import java.util.Scanner;

public class Triangle {
    private double sideA; 
    private double sideB; 
    private double sideC; 

    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Неможливо створити трикутник з такими сторонами.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getArea() {
        double s = getPerimeter() / 2; 
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public int compareTo(Triangle other) {
        double thisArea = this.getArea();
        double otherArea = other.getArea();

        if (thisArea > otherArea) {
            return 1;  
        } else if (thisArea < otherArea) {
            return -1; 
        } else {
            return 0;  
        } 
    }

    public static Triangle inputTriangle(Scanner scanner) {
        System.out.print("Введіть сторону A: ");
        double sideA = scanner.nextDouble();
        System.out.print("Введіть сторону B: ");
        double sideB = scanner.nextDouble();
        System.out.print("Введіть сторону C: ");
        double sideC = scanner.nextDouble();
        return new Triangle(sideA, sideB, sideC);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введіть перший трикутник:");
            Triangle t1 = inputTriangle(scanner);

            System.out.println("Введіть другий трикутник:");
            Triangle t2 = inputTriangle(scanner);

            System.out.println("Периметр першого трикутника: " + t1.getPerimeter());
            System.out.println("Площа першого трикутника: " + t1.getArea());

            System.out.println("Периметр другого трикутника: " + t2.getPerimeter());
            System.out.println("Площа другого трикутника: " + t2.getArea());

            int comparison = t1.compareTo(t2);
            if (comparison > 0) {
                System.out.println("Перший трикутник більший за другий.");
            } else if (comparison < 0) {
                System.out.println("Перший трикутник менший за другий.");
            } else {
                System.out.println("Трикутники мають однакову площу.");
            }
        } finally {
            scanner.close();
        }
    }
}
