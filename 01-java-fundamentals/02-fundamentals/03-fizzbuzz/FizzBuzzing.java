public class FizzBuzzing {
    public static void main(String[] args) {
        int number1 = 15;
        int number2 = 3;
        int number3 = 5;
        int number = 4;
        FizzBuzzer pheobe = new FizzBuzzer();
        String fizz = pheobe.fizzBuzz(number2);
        String fizzbuzz = pheobe.fizzBuzz(number1);
        String buzz = pheobe.fizzBuzz(number3);
        String test = pheobe.fizzBuzz(number);

        System.out.println("here is F, FB, B, and test" + fizz + fizzbuzz + buzz + test);
    }
}