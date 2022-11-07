import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class DiceGame {
    private int p1Score = 0;
    private int p2Score = 0;
    private int rounds;

    public static void main(String[] args) {
        DiceGame game = new DiceGame();

        game.rounds(50);

        System.out.println("The game is over.");

        if (game.p1Score >= game.p2Score)
            System.out.println("The winner is P1");
        else
            System.out.println("The winner is P2");

        System.out.println("How many rounds did it take to win?");
        System.out.println("Rounds played: " + game.rounds);

        System.out.println("Final score:");
        System.out.println("P1 score: " + game.p1Score);
        System.out.println("P2 score: " + game.p2Score);
    }

    void rounds(int maxScore) {
        System.out.printf("Round number: %d.\n", rounds);

        int p1Roll = (int) ((Math.random() * 6) + 1);
        int p2Roll = (int) ((Math.random() * 6) + 1);

        System.out.printf("P1 rolled a: %d.\n" +
                "P2 rolled a: %d.\n", p1Roll, p2Roll);

        if (p1Roll == p2Roll) {
            p1Score += 3;
            p2Score += 3;
        } else if (p1Roll > p2Roll) {
            p1Score += 5;
        } else {
            p2Score += 5;
        }
        if (p1Score >= maxScore || p2Score >= maxScore) {
            return;
        }
        rounds++;
        rounds(maxScore);
    }
//    Converting an older C# project into Java
}
