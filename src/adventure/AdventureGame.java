package adventure;

import java.util.Scanner;
import java.util.Random;

public class AdventureGame {

    public static void main(String[] args) {
        System.out.println("This is a text based game. \nPlease follow text prompts, as they are specific to how you will need to enter commands.");
        System.out.println("Are you ready to start your adventure? - [Yes / No]");
        adventureTime();
    }

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static String playerName;

    public static void adventureTime() {
        String option = sc.nextLine();
        if (option.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your name: ");
            playerName = sc.nextLine().toUpperCase();
            System.out.printf("%s, welcome to the start of your adventure!\n", playerName);
            andAction();
        } else {
            System.out.println("Maybe another time...");
        }
    }

    public static void andAction() {
        System.out.printf("%s, what would you like to do?\n", playerName);
    }

}
