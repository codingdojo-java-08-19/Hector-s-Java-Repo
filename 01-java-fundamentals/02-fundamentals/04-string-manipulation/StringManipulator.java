public class StringManipulator {
    public String trimAndConcat(String string1, String string2) {
        string1 = string1.trim();
        string2 = string2.trim();
        return string1 + string2;
    }

    public Integer indexOrNull(String string, char hunted) {
        if (string.indexOf(hunted) == -1) {
            return null;
        } else {
            return string.indexOf(hunted);
        }
    }

    public Integer indexOrNull(String string, String hunted) {
        if (string.indexOf(hunted) == -1) {
            return null;
        } else {
            return string.indexOf(hunted);
        }
    }

    public String concatSubstrings(String string, int beginning, int end, String string2) {
        return string.substring(beginning, end) + string2;
    }
}