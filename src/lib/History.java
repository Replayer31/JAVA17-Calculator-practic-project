package lib;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {

    public static int result_int;
    public static float result_float;
    public static double result_double;
    public static int frstnum_int;
    public static float frstnum_float;
    public static double frstnum_double;
    public static int scndnum_int;
    public static float scndnum_float;
    public static double scndnum_double;
    public static char op;
    public static List<String> history = new ArrayList<>();
    public static LocalDateTime now_ = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static String now = now_.format(formatter);

    public static void history_int_result() {
        now_ = LocalDateTime.now();
        now = now_.format(formatter);
        history.add(now + " | " + frstnum_int + op + scndnum_int + " = " + result_int);
    }
    public static void history_float_result() {
        now_ = LocalDateTime.now();
        now = now_.format(formatter);
        history.add(now + " | " + frstnum_float + op + scndnum_float + " = " + result_float);
    }
    public static void history_double_result() {
        now_ = LocalDateTime.now();
        now = now_.format(formatter);
        history.add(now + " | " + frstnum_double + op + scndnum_double + " = " + result_double);
    }
    public static void history_menu_integer() {
        now_ = LocalDateTime.now();
        now = now_.format(formatter);
        history.add(now + " | " + "Integer menu variant");
    }
    public static void history_menu_float() {
        now_ = LocalDateTime.now();
        now = now_.format(formatter);
        history.add(now + " | " + "Floating point menu variant");
    }
    public static void history_menu_double() {
        now_ = LocalDateTime.now();
        now = now_.format(formatter);
        history.add(now + " | " + "Double precision menu variant");
    }
}
