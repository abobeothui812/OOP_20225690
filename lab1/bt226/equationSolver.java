package bt226;
import java.util.Scanner;
public class equationSolver {
    public static void main(String args[]){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please input what type of equation you want to solve:\n" +
            "1.First-degree equation\n" +
            "2.Second-degree equation\n" +
            "3.System of first-degree equations");
            switch (scanner.nextInt()) {
                case 1:
                    firstDegreeEquation();
                    break;
                case 2:
                    secondDegreeEquation();
                    break;
                default:
                    systemOffirstDegreeEquation();
                    break;
            }
        }
        ;
    }

    public static void firstDegreeEquation() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please input the coefficient a: ");
            double a = scanner.nextDouble();
            if (a ==0){
                System.out.println("The equation is not a first-degree equation");
                return;
            }
            System.out.println("Please input the coefficient b: ");
            double b = scanner.nextDouble();
            double x = -b/a;
            System.out.println("The solution of the equation " + a + "x + " + b + " = 0 is x = " + x);
        }
    }

    public static void systemOffirstDegreeEquation(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please input the coefficient a_11: ");
            double a11 = scanner.nextDouble();
            System.out.println("Please input the coefficient a_12: ");
            double a12 = scanner.nextDouble();
            System.out.println("Please input the coefficient b_1: ");
            double b1 = scanner.nextDouble();
            System.out.println("Please input the coefficient a_21: ");
            double a21 = scanner.nextDouble();
            System.out.println("Please input the coefficient a_22: ");
            double a22 = scanner.nextDouble();
            System.out.println("Please input the coefficient b_2: ");
            double b2 = scanner.nextDouble();
            double D = a11*a22 - a21*a12;
            double D1 = b1*a22 - b2*a12;
            double D2 = a11*b2 - a21*b1;

            if (D == 0){
                if (D1 == 0 && D2 == 0){
                    System.out.println("The system of equations has infinitely many solutions");
                } else {
                    System.out.println("The system of equations has no solution");
                }
            } else {
                double x = D1/D;
                double y = D2/D;
                System.out.println("The solution of the system of equations is x = " + x + ", y = " + y);
            }
        }
    }

    public static void secondDegreeEquation(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please input the coefficient a: ");
            double a = scanner.nextDouble();
            System.out.println("Please input the coefficient b: ");
            double b = scanner.nextDouble();
            System.out.println("Please input the coefficient c: ");
            double c = scanner.nextDouble();

            if(a == 0){
                double x = -b/a;
                System.out.println("The solution of the equation " + a + "x + " + b + " = 0 is x = " + x);
            }else{
                double delta = b*b - 4*a*c;
                if (delta < 0){
                    System.out.println("The equation has no solution");
                } else if (delta == 0){
                    double x = -b/(2*a);
                    System.out.println("The solution of the equation " + a + "x^2 + " + b + "x + " + c + " = 0 is x = " + x);
                } else {
                    double x1 = (-b + Math.sqrt(delta))/(2*a);
                    double x2 = (-b - Math.sqrt(delta))/(2*a);
                    System.out.println("The solution of the equation " + a + "x^2 + " + b + "x + " + c + " = 0 is x1 = " + x1 + ", x2 = " + x2);
                }
            }
        }
    }
}
