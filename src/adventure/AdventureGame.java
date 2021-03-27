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
        if (option.trim().equalsIgnoreCase("y") || option.trim().equalsIgnoreCase("yes")) {
            System.out.println("Please enter your name: ");
            playerName = sc.nextLine();
            System.out.printf("\n%s, welcome to the start of your adventure!\n", playerName);
            andAction();
        } else {
            System.out.println("Maybe another time...");
        }
    }

    public static void andAction() {
        System.out.printf("%s, what would you like to do?\n", playerName);
        System.out.println("A: Walk to the stream.");
        System.out.println("B: Go to the tavern.");
        System.out.println("C: Take a trip to the library.");
        System.out.println("D: Take a nap.");
        String scenarioInput = sc.nextLine();

        if (scenarioInput.equalsIgnoreCase("a")) {
            stream();
        } else if (scenarioInput.equalsIgnoreCase("b")) {
            tavern();
        } else if (scenarioInput.equalsIgnoreCase("c")) {
            library();
        } else if (scenarioInput.equalsIgnoreCase("d")) {
            nap();
        } else {
            andAction();
        }
    }

    public static void stream() {
        System.out.println("You leave your house and start walking towards the trail that leads to the stream.");

    }

    public static void tavern() {
        int minDrinks = 1;
        int maxDrinks = 20;

        System.out.println("You decide to head to the tavern to get a few pints with your mates.");
        System.out.printf("%s! Everyone shouts as you enter the tavern door.", playerName);
        System.out.printf("You order %d pints and spark up a conversation about how awful the bard sounds today.", rand.nextInt(maxDrinks) + minDrinks);

    }

    public static void library() {
        System.out.println("A book is what you want, a book is what you'll get! Off to the library...");

    }

    public static void nap() {
        System.out.println("You get comfy on your bed and decide to take a nap.");
        System.out.println("zzz...zzz...zzz");

    }


}
