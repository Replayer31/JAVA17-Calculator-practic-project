package calculator;

import lib.Reps_filesLib;
import static lib.History.*;
import static lib.Changelog.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Calculator {

    public static int Version = 4; //VERSION
    //public static String code0 = "";
    public static String code0 = "Operation completed successfully! Code 0";
    public static String code1 = "Error: Unknown error. Operation ended with code 1";
    public static String code2 = "Error: Data is empty. Operation ended with code 2";
    public static String code3 = "Error: Unknown choice. Operation ended with code 3\nTip for common reason: Choose from the variants above!";
    public static String code4 = "Error: Invalid response. Operation ended with code 4";
    public static String code5 = "Error: Number overflow or too large. Operation ended with code 5";
    public static String code6 = "Error: Division by zero. Operation ended with code 6";
    public static String code7 = "Error: Unknown file operation error. Operation ended with code 7";
    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        System.out.println("==CALCULATOR==");
        System.out.println("V" + Version);
        startClock();
        calculator_brain();
    }
    public static void calculator_brain() {
        menu_title();
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
                    case "cl", "c", "changelog", "Changelog" -> {
                        System.out.println("Changelog of what version you need?");
                        System.out.println("Write only number of version (for example: '2', '3')");
                        System.out.println("Available changelogs from 2 to 4 inclusive");
                        while_changelog: {
                            while (true) {
                                int ver = not_int_error();
                                scanner.nextLine();
                                switch (ver) {
                                    case 2, 3, 4 -> {
                                        changelog_(ver);
                                        System.out.println("End of changelog");
                                        break while_changelog;
                                    }
                                    default -> System.out.println(code3);
                                }
                            }
                        }
                    }
                    case "cl_download", "c_download", "changelog_download", "Changelog_download" -> {
                        System.out.println("Changelog of what version you need?");
                        System.out.println("Write only number of version (for example: '2', '3')");
                        System.out.println("Available changelogs from 2 to 4 inclusive");
                        while_changelog: {
                            while (true) {
                                int ver = not_int_error();
                                scanner.nextLine();
                                switch (ver) {
                                    case 2 -> {
                                        if (Reps_filesLib.download_txt.downloads_folder("CHANGELOG_V2", ".txt", changelog_V2, false) == 0) {
                                            System.out.println(code0);
                                            System.out.println("Changelog downloaded in downloads folder successfully");
                                        } else {
                                            System.out.println(code7);
                                        }
                                        System.out.println("End of changelog");
                                        break while_changelog;
                                    }
                                    case 3 -> {
                                        if (Reps_filesLib.download_txt.downloads_folder("CHANGELOG_V3", ".txt", changelog_V3, false) == 0) {
                                            System.out.println(code0);
                                            System.out.println("Changelog downloaded in downloads folder successfully");
                                        } else {
                                            System.out.println(code7);
                                        }
                                        System.out.println("End of changelog");
                                        break while_changelog;
                                    }
                                    case 4 -> {
                                        if (Reps_filesLib.download_txt.downloads_folder("CHANGELOG_V4", ".txt", changelog_V4, false) == 0) {
                                            System.out.println(code0);
                                            System.out.println("Changelog downloaded in downloads folder successfully");
                                        } else {
                                            System.out.println(code7);
                                        }
                                        System.out.println("End of changelog");
                                        break while_changelog;
                                    }
                                    default -> System.out.println(code3);
                                }
                            }
                        }
                    }
                    case "cl_download_all", "c_download_all", "changelog_download_all", "Changelog_download_all" -> { //Download history/download history/Download h/download h
                        if (Reps_filesLib.download_txt.downloads_folder("CHANGELOGS", ".txt", fullChangelog, false) == 0) {
                            System.out.println(code0);
                            System.out.println("Changelogs downloaded in downloads folder successfully");
                        } else {
                            System.out.println(code7);
                        }
                    }
                    case "Download history", "download history", "Download h", "download h" -> {
                        if (Reps_filesLib.download_txt.downloads_folder("HISTORY", ".txt", history, true) == 0) {
                            System.out.println(code0);
                            System.out.println("History downloaded in downloads folder successfully");
                        } else {
                            System.out.println(code7);
                        }
                    }
                    case "help", "?" -> help_title();
                    case "unary", "Unary", "un", "Un", "Unary operation", "unary operation" -> unaryMethod();
                    default -> {
                        System.out.print(code3); //"\033[31m" +  + "\033[0m"
                        continue;
                    }
                }
                menu_title();
            } catch (Exception e) {
                System.out.println(code1);
            }
        }
    }
    public static void integerMethod() {
        history_menu_integer();
        while (true) {
            brain_integerMethod: {
                System.out.println("Write number");
                frstnum_int = not_int_error();
                while (true) {
                    System.out.println("Write an arithmetic operator or one of these variants:");
                    System.out.println("m - Main menu");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    op = scanner.next().charAt(0);
                    switch (op) {
                        case '+', '-', '*', '%' -> {
                            System.out.println("Write second number");
                            scndnum_int = not_int_error();
                            try {
                                switch (op) {
                                    case '+' -> result_int = Math.addExact(frstnum_int, scndnum_int);
                                    case '-' -> result_int = Math.subtractExact(frstnum_int, scndnum_int);
                                    case '*' -> result_int = Math.multiplyExact(frstnum_int, scndnum_int);
                                    case '%' -> result_int = frstnum_int % scndnum_int;
                                    default -> {
                                        System.out.println(code1);
                                        scanner.nextLine();
                                        break brain_integerMethod;
                                    }
                                }
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
                        case 'p' -> {
                            System.out.println("Write second number");
                            scndnum_int = not_int_error();
                            result_int = (int) Math.pow(frstnum_int, scndnum_int);
                            System.out.println("Current result:" + result_int);
                            history_int_result();
                        }
                        case 'm' -> {
                            System.out.println(code0);
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
            brain_floatMethod: {
                System.out.println("Write number");
                frstnum_float = not_float_error();
                while (true) {
                    System.out.println("Write an arithmetic operator or one of this variants:");
                    System.out.println("m - Main menu");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    op = scanner.next().charAt(0);
                    switch (op) {
                        case '+', '-', '*', '%' -> {
                            System.out.println("Write second number");
                            scndnum_float = not_float_error();
                            try {
                                switch (op) {
                                    case '+' -> result_float = frstnum_float + scndnum_float;
                                    case '-' -> result_float = frstnum_float - scndnum_float;
                                    case '*' -> result_float = frstnum_float * scndnum_float;
                                    case '%' -> result_float = frstnum_float % scndnum_float;
                                    default -> {
                                        System.out.println(code1);
                                        scanner.nextLine();
                                        break brain_floatMethod;
                                    }
                                }
                                if (Float.isInfinite(result_float)) {
                                    System.out.println(code5);
                                    break brain_floatMethod;
                                }
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
                            do {
                                scndnum_float = not_float_error();
                                if (scndnum_float == 0.0f) System.out.println(code6);
                            } while (scndnum_float == 0.0f);
                            result_float = frstnum_float / scndnum_float;
                            if (Float.isInfinite(result_float)) {
                                System.out.println(code5);
                                break brain_floatMethod;
                            }
                            System.out.println("Current result:" + result_float);
                            history_float_result();
                        }
                        case 'p' -> {
                            System.out.println("Write second number");
                            scndnum_float = not_float_error();
                            result_float = (float) Math.pow(frstnum_float, scndnum_float);
                            System.out.println("Current result:" + result_float);
                            history_float_result();
                        }
                        case 'm' -> {
                            System.out.println(code0);
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
            brain_doubleMethod: {
                System.out.println("Write number");
                frstnum_double = not_double_error();
                while (true) {
                    System.out.println("Write an arithmetic operator or one of this variants:");
                    System.out.println("m - Main menu");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    op = scanner.next().charAt(0);
                    switch (op) {
                        case '+', '-', '*', '%' -> {
                            System.out.println("Write second number");
                            scndnum_double = not_double_error();
                            try {
                                switch (op) {
                                    case '+' -> result_double = frstnum_double + scndnum_double;
                                    case '-' -> result_double = frstnum_double - scndnum_double;
                                    case '*' -> result_double = frstnum_double * scndnum_double;
                                    case '%' -> result_double = frstnum_double % scndnum_double;
                                    default -> {
                                        System.out.println(code1);
                                        scanner.nextLine();
                                        break brain_doubleMethod;
                                    }
                                }
                                if (Double.isInfinite(result_double) || Double.isNaN(result_double)) {
                                    System.out.println(code5);
                                    break brain_doubleMethod;
                                }
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
                            do {
                                scndnum_double = not_double_error();
                                if (scndnum_double == 0.0d) System.out.println(code6);
                            } while (scndnum_double == 0.0d);
                            result_double = frstnum_double / scndnum_double;
                            if (Double.isInfinite(result_double) || Double.isNaN(result_double)) {
                                System.out.println(code5);
                                break brain_doubleMethod;
                            }
                            System.out.println("Current result:" + result_double);
                            history_double_result();
                        }
                        case 'p' -> {
                            System.out.println("Write second number");
                            scndnum_double = not_double_error();
                            result_double = Math.pow(frstnum_double, scndnum_double);
                            System.out.println("Current result:" + result_double);
                            history_double_result();
                        }
                        case 'm' -> {
                            System.out.println(code0);
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
    public static void unaryMethod() {
        history_menu_unary();
        while (true) {
            brain_unaryMethod: {
                System.out.println("Write number");
                num = not_double_error();
                scanner.nextLine();
                while (true) {
                    System.out.println("Write an unary operator or one of these variants:");
                    System.out.println("m - Main menu");
                    System.out.println("q - Quit");
                    System.out.println("c - Clear number");
                    operator = scanner.nextLine();
                    switch (operator) {
                        case "v", "sqrt", "square root" -> {
                            num_result = Math.sqrt(num);
                            history_unary_result();
                        }
                        case "mod", "abs" -> {
                            num_result = Math.abs(num);
                            history_unary_result();
                        }
                        case "~", "r", "round" -> {
                            num_result = Math.round(num);
                            history_unary_result();
                        }
                        case "s", "sin" -> {
                            num_result = Math.sin(num);
                            history_unary_result();
                        }
                        case "cos" -> {
                            num_result = Math.cos(num);
                            history_unary_result();
                        }
                        case "t", "tan" -> {
                            num_result = Math.tan(num);
                            history_unary_result();
                        }
                        case "l", "log" -> {
                            num_result = Math.log(num);
                            history_unary_result();
                        }
                        case "log10" -> {
                            num_result = Math.log10(num);
                            history_unary_result();
                        }
                        case "e", "exp" -> {
                            num_result = Math.exp(num);
                            history_unary_result();
                        }
                        case "m" -> {
                            System.out.println(code0);
                            scanner.nextLine();
                            return;
                        }
                        case "c" -> {
                            System.out.println(code0);
                            scanner.nextLine();
                            break brain_unaryMethod;
                        }
                        case "q" -> System.exit(0);
                        default -> {
                            System.out.println(code3);
                            continue;
                        }
                    }
                    System.out.println("Current result:" + num_result);
                    num = num_result;
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
    public static void menu_title() {
        List<String> menu_ = new ArrayList<>();
        //menu_.add("");
        menu_.add("--Main Menu--");
        menu_.add("What calculator do you want?");
        menu_.add("Answer variants:");
        menu_.add("Integer");
        menu_.add("Floating point");
        menu_.add("Double precision");
        menu_.add("Unary operation");
        menu_.add("To quit write 'Quit' or 'q'");
        menu_.add("To view help write 'help' or '?'");
        for (String point : menu_) {
            System.out.println(point);
        }
    }
    public static void help_title() {
        List<String> help = new ArrayList<>();
        //help.add("");
        help.add("--Help--");
        help.add("-Menu:-");
        help.add("int/Int/integer/Integer - to Integer operations");
        help.add("float/Float/Floating point/floating point - to low-precision fractional numbers");
        help.add("double/Double/Double precision/double precision - to high-precision fractional numbers");
        help.add("un/Un/Unary/unary/Unary operation/unary operation - to operations with one number (for example, square root)");
        help.add("-History:-");
        help.add("History/history/h - if you gonna view history");
        help.add("Clear history/clear history/Clear h/clear h - if you gonna clear history");
        help.add("Download history/download history/Download h/download h - if you gonna download history in downloads folder");
        help.add("-Changelogs:-");
        help.add("cl/c/changelog/Changelog - if you gonna view changelogs from different changelogs");
        help.add("cl_download_all/c_download_all/changelog_download_all/Changelog_download_all - if you gonna download all changelogs to your computer in downloads folder");
        help.add("cl_download/c_download/changelog_download/Changelog_download - if you gonna download one changelog of a specific version in downloads folder");
        help.add("-Operators:-");
        help.add("+ - Addition");
        help.add("- - Subtraction");
        help.add("/ - Division");
        help.add("* - Multiplication");
        help.add("% - Modulo");
        help.add("-Unary operators:-");
        help.add("v/sqrt/square root - to calculate the square root of the number");
        help.add("mod/abs - to get the absolute value of the number");
        help.add("~/r/round - to round the number to the nearest integer");
        help.add("s/sin - to calculate the sine of the number");
        help.add("cos - to calculate the cosine of the number");
        help.add("t/tan - to calculate the tangent of the number");
        help.add("l/log - to calculate the natural logarithm of the number");
        help.add("log10 - to calculate the base 10 logarithm of the number");
        help.add("e/exp - to calculate the exponent of the number");
        help.add("End of help");
        for (String point : help) {
            System.out.println(point);
        }
    }
}
