package lib;

import static calculator.Calculator.*;
import java.util.List;
import java.util.ArrayList;

public class Changelog {
    @SuppressWarnings("unused")
    public static List<String> fullChangelog = new ArrayList<>();
    public static List<String> changelog_V2 = new ArrayList<>();
    public static List<String> changelog_V3 = new ArrayList<>();
    public static List<String> changelog_V4 = new ArrayList<>();


    static {
        changelog_V2_();
        changelog_V3_();
        changelog_V4_();
        setFullChangelog();
    }


    public static void changelog_(int ver) {
        switch (ver) {
            case 2 -> {
                for (String point : changelog_V2) {
                    System.out.println("- " + point);
                }
            }
            case 3 -> {
                for (String point : changelog_V3) {
                    System.out.println("- " + point);
                }
            }
            case 4 -> {
                for (String point : changelog_V4) {
                    System.out.println("- " + point);
                }
            }
            default -> System.out.println(code3);
        }
    }
    public static void setFullChangelog() {
        fullChangelog.clear();
        int cl_ver = 1;
        while (cl_ver < Version) {
            cl_ver = cl_ver + 1;
            fullChangelog.add("V" + cl_ver);
            switch (cl_ver) {
                case 2 -> fullChangelog.addAll(changelog_V2);
                case 3 -> fullChangelog.addAll(changelog_V3);
                case 4 -> fullChangelog.addAll(changelog_V4);
            }
        }
    }
    public static void changelog_V2_() {
        //changelog_V2.add("");
        changelog_V2.add("Deleted text formatting (for correct CMD viewing)");
        changelog_V2.add("Function 'Reload calculator' renamed to 'Clear number'");
        changelog_V2.add("Added input validation (protection against entering letters instead of numbers)");
    }
    public static void changelog_V3_() {
        //changelog_V3.add("");
        changelog_V3.add("General package and method were renamed");
        changelog_V3.add("Added history");
        changelog_V3.add("Added error codes");
        changelog_V3.add("Added more safe-points, including try-catch code parts");
        changelog_V3.add("Added more variety in input options from the main menu");
        changelog_V3.add("The main variables were moved to the history library");
        changelog_V3.add("Recursion removal and other bug fixes");
    }
    public static void changelog_V4_() {
        //changelog_V4.add("");
        changelog_V4.add("Menu title moved to separate method");
        changelog_V4.add("Added help");
        changelog_V4.add("Added one new operator and unary operators");
        changelog_V4.add("Now the time in History.java is updated in a separate loop method");
        changelog_V4.add("Operators verification changed from 'if' to 'switch'");
        changelog_V4.add("Added changelog");
        changelog_V4.add("You can download history or changelog now!");
        changelog_V4.add("Function 'r - reset program' renamed to 'm - main menu'");
        changelog_V4.add("Added more safe-points, including Float.isInfinite and Double.isInfinite code parts");
    }
}