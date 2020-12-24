import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for a palindrome:");
        String userString = sc.nextLine();

        if (palindrome(userString))
            System.out.printf("%s is a palindrome!", userString);
        else
            System.out.printf("%s is not a palindrome", userString);
    }

    public static boolean palindrome(String input) {
        if (input.length() == 0 || input.length() == 1)
            return true;
        if (input.charAt(0) == input.charAt(input.length() - 1))
            return palindrome(input.substring(1, input.length() - 1));
        return false;
    }

}
