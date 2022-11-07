import java.util.Scanner;

public class LetterCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        do {
            System.out.println("Type something and I'll count the consonants and vowels!");
            String input = sc.nextLine();
            int vowels = 0, consonants = 0;
            input = input.toLowerCase();

            for (int i = 0; i < input.length(); ++i) {
                char letter = input.charAt(i);
                if (letter == 'a' || letter == 'e' || letter == 'i'
                        || letter == 'o' || letter == 'u') {
                    ++vowels;
                } else if ((letter >= 'a' && letter <= 'z')) {
                    ++consonants;
                }
            }
            System.out.println("Number of consonants: " + consonants);
            System.out.println("Number of vowels: " + vowels);
            System.out.println("Try again? [y/n]");
            String typeAgain = sc.nextLine();
            if (typeAgain.equals("n")) {
                System.out.println("Program terminated");
                break;
            }
        } while (true);
    }
}
