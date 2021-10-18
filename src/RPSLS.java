import java.util.*;

import util.Input;

public class RPSLS {

    public static void main(String[] args) {

        game();
    }


    public static void gameRules() {

        System.out.println("ROCK - PAPER - SCISSORS - LIZARD - SPOCK\n");
        System.out.println("Here are the game rules:\n\n");
        System.out.println("SCISSORS cuts PAPER.\n");
        System.out.println("PAPER covers ROCK.\n");
        System.out.println("ROCK smashes LIZARD.\n");
        System.out.println("LIZARD poisons SPOCK\n");
        System.out.println("SPOCK smashes SCISSORS.\n");
        System.out.println("SCISSORS decapitates LIZARD.\n");
        System.out.println("LIZARD eats PAPER.\n");
        System.out.println("PAPER disproves SPOCK.\n");
        System.out.println("SPOCK vaporizes ROCK.\n");
        System.out.println("And, as it always has, ROCK smashes SCISSORS.\n\n");
        System.out.println("The first PLAYER to win THREE rounds wins!\n\n");
    }

    public static void gameMode() {

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.out.println("Choose game mode: \n\n" +
                "HUMAN = 1 | CPU = 2 | SPECTATE = 3\n");
        String input = sc.nextLine();
        input = input.toLowerCase();

        if (input.equals("HUMAN") || input.equals("1")) {

            System.out.println("P1 enter your name: \n");
            String p1Name = sc.nextLine();
            p1Name = p1Name.toUpperCase();
            System.out.println("Hello, " + p1Name +".\n");

            System.out.println("P2 enter your name: \n");
            String p2Name = sc.nextLine();
            p2Name = p2Name.toUpperCase();
            System.out.println("Salutations, " + p2Name + ".\n");

            System.out.println(p1Name + " versus " + p2Name);
        }
        else if (input.equals("CPU") || input.equals("2")) {

            System.out.println("P1 enter your name: \n");
            String p1Name = sc.nextLine();
            p1Name = p1Name.toUpperCase();
            System.out.println("Hello, " + p1Name +".\n");

            String[] aiPlayers = {"Zero", "Red", "Bender", "Glados"};
            Random rand = new Random();
            int cpuPlayer =  rand.nextInt(aiPlayers.length);
            String randomPlayer = aiPlayers[cpuPlayer].toUpperCase();
            System.out.println("P2 will be played by AI - " + randomPlayer + ".\n");

            System.out.println(p1Name + " versus " + randomPlayer + ".\n");
        } else if (input.equals("SPECTATE") || input.equals("3")) {

            String[] aiPlayers = {"Dude Bot", "Weebo", "Hank", "T100", "Johnny 5", "Clap-Trap"};
            Random rand = new Random();
            int cpuPlayer1 =  rand.nextInt(aiPlayers.length);
            String randomPlayer1 = aiPlayers[cpuPlayer1].toUpperCase();
            System.out.println("P1 will be played by AI - " + randomPlayer1 + ".\n");

            int cpuPlayer2 =  rand.nextInt(aiPlayers.length);
            String randomPlayer2 = aiPlayers[cpuPlayer2].toUpperCase();
            System.out.println("P2 will be played by AI - " + randomPlayer2 + ".\n");

            System.out.println(randomPlayer1 + " versus " + randomPlayer2 + ".\n");
        } else {
            gameMode();
        }

    }

    public static void game() {

        int playerScore = 0;
        int round = 0;

        gameRules();
        gameMode();

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");


    }

}
