package calculator;

import static lib.History.*;
import java.util.Scanner;
import java.util.Locale;

public class Calculator {

    //public static String code0 = "";
    public static String code0 = "Operation completed successfully! Code 0";
    public static String code1 = "Error: Unknown error. Operation ended with code 1";
    public static String code2 = "Error: Data is empty. Operation ended with code 2";
    public static String code3 = "Error: Unknown choice. Operation ended with code 3\nTip for the most popular reason: Choose from the variants above!";
    public static String code4 = "Error: Invalid response.";
    public static String code5 = "Error: Number overflow or too large. Operation ended with code 5";
    public static String code6 = "Error: Division by zero. Operation ended with code 6";
    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int Version = 3;
        System.out.println("==CALCULATOR==");
        System.out.println("V" + Version);
        calculator_brain();
    }
    public static void calculator_brain() {
        System.out.println("What calculator do you want?");
        System.out.println("Answer variants:");
        System.out.println("Integer");
        System.out.println("Floating point");
        System.out.println("Double precision");
        System.out.println("For quit write \"Quit\" or q");
        System.out.println("For see history write h");
        System.out.println("For clear history write clear h");
        while (true) {
            try {
                System.out.println(" ");
                String calculator = scanner.nextLine();
                switch (calculator) {
                    case "Integer", "integer", "int" -> integerMethod();
                    case "Floating point", "float", "Float" -> floatMethod();
                    case "Double precision", "double", "Double" -> doubleMethod();
                    case "Quit", "q" -> System.exit(0);
                    case "History", "history", "h" -> {
                        if (!history.isEmpty()) {
                            System.out.println("History:");
                            for (String record : history) {
                                System.out.println("-" + record);
                            }
                            System.out.println("End of history");
                        } else {
                            System.out.println(code2);
                        }
                    }
                    case "clear h", "Clear h", "clear history", "Clear history" -> {
                        history.clear();
                        System.out.println(code0);
                    }
                    default -> {
                        System.out.print(code3); //"\033[31m" +  + "\033[0m"
                        continue;
                    }
                }
                System.out.println("What calculator do you want?");
                System.out.println("Answer variants:");
                System.out.println("Integer");
                System.out.println("Floating point");
                System.out.println("Double precision");
                System.out.println("For quit write \"Quit\" or q");
                System.out.println("For see history write h");
                System.out.println("For clear history write clear h");
            } catch (Exception e) {
                System.out.println(code1);
            }
        }
    }
    public static void integerMethod() {
        history_menu_integer();
        while (true) {
            brain_integerMethod:
            {
                System.out.println("Write number");
                frstnum_int = not_int_error();
                while (true) {
                    System.out.println("Write an arithmetic operator or one of this variants:");
                    System.out.println("r - Reset program");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    op = scanner.next().charAt(0);
                    switch (op) {
                        case '+', '-', '*', '%' -> {
                            System.out.println("Write second number");
                            scndnum_int = not_int_error();
                            try {
                                if (op == '+') result_int = frstnum_int + scndnum_int;
                                if (op == '-') result_int = frstnum_int - scndnum_int;
                                if (op == '*') result_int = frstnum_int * scndnum_int;
                                if (op == '%') result_int = frstnum_int % scndnum_int;
                                System.out.println("Current result:" + result_int);
                                history_int_result();
                            } catch (ArithmeticException e) {
                                System.out.println(code5);
                                scanner.nextLine();
                                break brain_integerMethod;
                            }
                        }
                        case '/' -> {
                            System.out.println("Write second number");
                            do {
                                scndnum_int = not_int_error();
                                if (scndnum_int == 0) System.out.println(code6);
                            } while (scndnum_int == 0);
                            result_int = frstnum_int / scndnum_int;
                            System.out.println("Current result:" + result_int);
                            history_int_result();
                        }
                        case 'r' -> {
                            System.out.println("Restarting program...");
                            scanner.nextLine();
                            return;
                        }
                        case 'c' -> {
                            System.out.println(code0);
                            scanner.nextLine();
                            break brain_integerMethod;
                        }
                        case 'q' -> System.exit(0);
                        default -> {
                            System.out.println(code3);
                            continue;
                        }
                    }
                    frstnum_int = result_int;
                }
            }
        }
    }
    public static void floatMethod() {
        history_menu_float();
        while (true) {
            brain_floatMethod:
            {
                System.out.println("Write number");
                frstnum_float = not_float_error();
                while (true) {
                    System.out.println("Write an arithmetic operator or one of this variants:");
                    System.out.println("r - Reset program");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    op = scanner.next().charAt(0);
                    switch (op) {
                        case '+', '-', '*', '%' -> {
                            System.out.println("Write second number");
                            scndnum_float = not_float_error();
                            try {
                                if (op == '+') result_float = frstnum_float + scndnum_float;
                                if (op == '-') result_float = frstnum_float - scndnum_float;
                                if (op == '*') result_float = frstnum_float * scndnum_float;
                                if (op == '%') result_float = frstnum_float % scndnum_float;
                                System.out.println("Current result:" + result_float);
                                history_float_result();
                            } catch (ArithmeticException e) {
                                System.out.println(code5);
                                scanner.nextLine();
                                break brain_floatMethod;
                            }
                        }
                        case '/' -> {
                            System.out.println("Write second number");
                            scndnum_float = not_float_error();
                            if (scndnum_float == 0.0f) {
                                System.out.println(code6);
                                scanner.nextLine();
                                break brain_floatMethod;
                            }
                            result_float = frstnum_float / scndnum_float;
                            System.out.println("Current result:" + result_float);
                            history_float_result();
                        }
                        case 'r' -> {
                            System.out.println("Restarting program...");
                            scanner.nextLine();
                            return;
                        }
                        case 'c' -> {
                            System.out.println(code0);
                            scanner.nextLine();
                            break brain_floatMethod;
                        }
                        case 'q' -> System.exit(0);
                        default -> {
                            System.out.println(code3);
                            continue;
                        }
                    }
                    frstnum_float = result_float;
                }
            }
        }
    }
    public static void doubleMethod() {
        history_menu_double();
        while (true) {
            brain_doubleMethod:
            {
                System.out.println("Write number");
                frstnum_double = not_double_error();
                while (true) {
                    System.out.println("Write an arithmetic operator or one of this variants:");
                    System.out.println("r - Reset program");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    op = scanner.next().charAt(0);
                    switch (op) {
                        case '+', '-', '*', '%' -> {
                            System.out.println("Write second number");
                            scndnum_double = not_double_error();
                            try {
                                if (op == '+') result_double = frstnum_double + scndnum_double;
                                if (op == '-') result_double = frstnum_double - scndnum_double;
                                if (op == '*') result_double = frstnum_double * scndnum_double;
                                if (op == '%') result_double = frstnum_double % scndnum_double;
                                System.out.println("Current result:" + result_double);
                                history_double_result();
                            } catch (ArithmeticException e) {
                                System.out.println(code5);
                                scanner.nextLine();
                                break brain_doubleMethod;
                            }
                        }
                        case '/' -> {
                            System.out.println("Write second number");
                            scndnum_double = not_double_error();
                            if (scndnum_double == 0.0d) {
                                System.out.println(code6);
                                scanner.nextLine();
                                break brain_doubleMethod;
                            }
                            result_double = frstnum_double / scndnum_double;
                            System.out.println("Current result:" + result_double);
                            history_double_result();
                        }
                        case 'r' -> {
                            System.out.println("Restarting program...");
                            scanner.nextLine();
                            return;
                        }
                        case 'c' -> {
                            System.out.println(code0);
                            scanner.nextLine();
                            break brain_doubleMethod;
                        }
                        case 'q' -> System.exit(0);
                        default -> {
                            System.out.println(code3);
                            continue;
                        }
                    }
                    frstnum_double = result_double;
                }
            }
        }
    }
    public static int not_int_error() {
        while (!scanner.hasNextInt()) {
            System.out.println(code4);
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static float not_float_error() {
        while (!scanner.hasNextFloat()) {
            System.out.println(code4);
            scanner.next();
        }
        return scanner.nextFloat();
    }
    public static double not_double_error() {
        while (!scanner.hasNextDouble()) {
            System.out.println(code4);
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
