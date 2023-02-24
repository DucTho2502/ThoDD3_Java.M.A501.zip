package fa.training.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Validate {

    public static final Scanner sc = new Scanner(System.in);
    private static Set<String> ids = new HashSet<String>();

    public static String inputString() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static final String PHONE_VALID = "^[0-9]{10}";

    public static String checkPhone() {
        while (true) {
            try {
                System.out.print("Enter phone number: ");
                String resultCheck = inputString();
                if (!resultCheck.matches(PHONE_VALID)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
                System.out.print("Phone number: ");
                System.err.println("Phone number must be number");
            }
        }
    }

    public static String inputStringLimit() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else if(result.length() < 10 || result.length() > 10) {
                System.out.println("number string with length equals 10");
            } else {
                return result;
            }
        }
    }

    public static String getString(String msg, boolean empty, String pattern) {
        String line;
        if (pattern == "empty") {
            do {
                System.out.format("%s: ", msg);
                line = sc.nextLine();
                if (line.trim().isEmpty() && empty == true) return "Not available";
                if (line.trim().isEmpty() && empty == false) System.err.println("Not Empty");
                if (!line.trim().isEmpty()) return line;
            } while (true);
        } else {
            do {
                System.out.format("%s: ", msg);
                line = sc.nextLine();
                if (line.trim().isEmpty() && empty == true) return "Not available";
                if (line.matches(pattern)) return line;
                else System.err.println("Must Be String");
            } while (true);
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static Set<String> getIds() {
        return ids;
    }
}
