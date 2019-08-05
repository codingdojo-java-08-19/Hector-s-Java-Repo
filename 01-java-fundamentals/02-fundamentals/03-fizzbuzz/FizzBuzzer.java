// import com.sun.org.apache.regexp.internal.recompile;

public class FizzBuzzer {
    public String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        } else {
            return String.format("%d", number);
        }
    }
}