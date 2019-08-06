public class BasicJavaMain {
    public static void main(String[] args) {
        BasicJava basic = new BasicJava();
        // basic.print1to1255();
        // basic.printSumsTo255();
        Integer[] mrArray = { 1, -2, 3, -4, 5, -6, 7, -8, 9, -10 };
        // basic.printVals(mrArray);
        basic.findMax(mrArray);
        basic.findAverage(mrArray);
        // System.out.println(basic.oddArray();
        basic.greaterThanY(mrArray, 5);
        System.out.println(basic.shiftValsLeft(mrArray));

    }
}