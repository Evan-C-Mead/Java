public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz();
    }

    public static void fizzBuzz() {
        for (int x = 1; x <= 100; x++) {
            if (x % 15 == 0) {
                System.out.printf("FizzBuzz %d\n", x);
            } else if (x % 5 == 0) {
                System.out.printf("Buzz %d\n", x);
            } else if (x % 3 == 0) {
                System.out.printf("Fizz %d\n", x);
            } else {
                System.out.printf("%d\n", x);
            }
        }
    }
}
