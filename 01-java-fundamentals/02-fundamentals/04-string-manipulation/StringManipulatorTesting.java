public class StringManipulatorTesting {
    public static void main(String[] args) {
        StringManipulator stringer = new StringManipulator();
        String attitude = stringer.trimAndConcat("     wat-       ", "     eves      ");
        System.out.println(attitude);
        char split = '-';
        char testChar = '_';
        Integer theSplit = stringer.indexOrNull(attitude, split);
        Integer theTest = stringer.indexOrNull(attitude, testChar);
        System.out.println(theSplit);
        System.out.println(theTest);
        System.out.println(stringer.indexOrNull(attitude, "eves"));
        System.out.println(stringer.indexOrNull(attitude, "attic"));

        String newAttitude = stringer.concatSubstrings(attitude, 0, 3, "-ever");
        System.out.println(newAttitude);

    }
}