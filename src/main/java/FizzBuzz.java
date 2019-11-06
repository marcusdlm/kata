
public class FizzBuzz {

    public static String fizzbuzz(int i) {
        if (i%15 == 0) {
            return "FizzBuzz";
        }
        else if (i%5 == 0) {
            return "buzz";
        }
        else if (i%3 == 0) {
            return "fizz";
        }
        return String.valueOf(i);
    }

}