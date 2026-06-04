package lib;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {


    public static double num;
    public static double num_result;
    public static String operator;
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
    public static volatile LocalDateTime now_ = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static volatile String now = now_.format(formatter);

    public static void startClock() {
        Thread clockThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                now_ = LocalDateTime.now();
                now = now_.format(formatter);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        clockThread.setDaemon(true);
        clockThread.start();
    }

    public static void history_int_result() {
        history.add(now + " | " + frstnum_int + op + scndnum_int + " = " + result_int);
    }
    public static void history_float_result() {
        history.add(now + " | " + frstnum_float + op + scndnum_float + " = " + result_float);
    }
    public static void history_double_result() {
        history.add(now + " | " + frstnum_double + op + scndnum_double + " = " + result_double);
    }
    public static void history_unary_result() {
        history.add(now + " | " + num + operator + " = " + num_result);
    }
    public static void history_menu_integer() {
        history.add(now + " | " + "Integer menu variant");
    }
    public static void history_menu_float() {
        history.add(now + " | " + "Floating point menu variant");
    }
    public static void history_menu_double() {
        history.add(now + " | " + "Double precision menu variant");
    }
    public static void history_menu_unary() {
        history.add(now + " | " + "Unary operation menu variant");
    }
}
