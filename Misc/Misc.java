package Misc;

import java.util.Scanner;

public class Misc {
    
    public byte nextByte(Scanner in) {
        byte input;
        while (true) {
            try {
                input = in.nextByte();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Not a valid number.");
                // Clear invalid input
                in.next();
                continue;
            } catch (Exception e) {
                System.out.println("Something went wrong...");
                System.out.println(e);
                continue;
            }
        }
        return input;
    }

    public String nextLine(Scanner in) {
        // Skip newline
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        return in.nextLine();
    }
}
