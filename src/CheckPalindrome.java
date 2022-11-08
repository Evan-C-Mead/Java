import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for a palindrome:");
        String userString = sc.nextLine();

        if (palindrome(userString)) {
            System.out.printf("%s is a palindrome!\n", userString);
            System.out.printf("Largest palindrome substring is: %s", longestPalindrome(userString));
        } else {
            System.out.printf("%s is not a palindrome\n", userString);
        }
    }

    public static boolean palindrome(String input) {
        if (input.length() == 0 || input.length() == 1)
            return true;
        if (input.charAt(0) == input.charAt(input.length() - 1))
            return palindrome(input.substring(1, input.length() - 1));
        return false;
    }

    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 1) {
            return "Please enter a palindrome.\n";
        }

        int strStart = 0, strEnd = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = checkStringCenter(str, i, i);
            int len2 = checkStringCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > strEnd - strStart) {
                strStart = i - (len - 1) / 2;
                strEnd = i + len / 2;
            }
        }
        return str.substring(strStart, strEnd + 1);
    }

    public static int checkStringCenter(String str, int leftStr, int rightStr) {
        while (leftStr >= 0 && rightStr < str.length() && str.charAt(leftStr) == str.charAt(rightStr)) {
            leftStr--;
            rightStr++;
        }
        return rightStr - leftStr - 1;
    }

}
