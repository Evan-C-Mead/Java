import java.util.*;

public class RandomNumberGenerator {

    public static void main(String[] args) {
        randomizer();
    }

    public static void randomizer() {
        int number;
        Random rand = new Random();

        System.out.println("Here are your random numbers:\n");
        for (number = 0; number <= 10; number++) {
            System.out.println(rand.nextInt(100));
        }
    }
}
