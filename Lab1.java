import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double y;
        double d = 3.0;

        try {
            System.out.print("Введіть y: ");
            y = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Помилка: потрібно ввести числове значення y!");
            scanner.close();
            return;
        }

        double xMin = -10 - 2.5 * 9;
        double xMax = 5 + 1.2 * 9;
        double dx = 0.5 + 9.0 / 20.0;

        System.out.println("\nXmin = " + xMin);
        System.out.println("Xmax = " + xMax);
        System.out.println("Крок = " + dx);
        System.out.println("y = " + y);
        System.out.println("d = " + d);

        // =====================================================
        // СПОСІБ 1. ЦИКЛ FOR
        // =====================================================

        System.out.println("\n===== Обчислення за допомогою FOR =====");

        for (double x = xMin; x <= xMax + 0.000001; x += dx) {

            double logArgument = Math.pow(Math.sin(x), 2) + 7.4;
            double denominator = Math.exp(y) + Math.log(logArgument);

            // Перевірка області допустимих значень
            if (logArgument <= 0 || Math.abs(denominator) < 0.000001) {
                System.out.println("x = " + x + " -> Значення не належить ОДЗ");
                continue;
            }

            double R = (Math.pow(Math.cos(y), 3)
                    + Math.pow(2, x) * d)
                    / denominator;

            System.out.printf("x = %.2f   R = %.6f%n", x, R);
        }

        // =====================================================
        // СПОСІБ 2. ЦИКЛ WHILE
        // =====================================================

        System.out.println("\n===== Обчислення за допомогою WHILE =====");

        double x = xMin;

        while (x <= xMax + 0.000001) {

            double logArgument = Math.pow(Math.sin(x), 2) + 7.4;
            double denominator = Math.exp(y) + Math.log(logArgument);

            if (logArgument <= 0 || Math.abs(denominator) < 0.000001) {
                System.out.println("x = " + x + " -> Значення не належить ОДЗ");
                x += dx;
                continue;
            }

            double R = (Math.pow(Math.cos(y), 3)
                    + Math.pow(2, x) * d)
                    / denominator;

            System.out.printf("x = %.2f   R = %.6f%n", x, R);

            x += dx;
        }

        scanner.close();
    }
}