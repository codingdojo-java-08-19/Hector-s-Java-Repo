import java.util.ArrayList;

public class BasicJava {
    public void print1to1255() {
        int pace = 1;
        while (pace < 255) {
            pace += 1;
            System.out.println(pace);
        }
    }

    public void printSumsTo255() {
        int pace = 0;
        int sum = 0;

        while (pace < 255) {
            sum += pace;
            pace += 1;
            System.out.println(String.format("count: %d, sum: %d", pace, sum));
        }
    }

    public void printVals(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void findMax(Integer[] array) {
        Integer max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }

    public void findAverage(Integer[] array) {
        Integer sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum / array.length);
    }

    public ArrayList oddArray() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i += 2) {
            y.add(i);
        }
        return y;
    }

    public void greaterThanY(Integer[] array, Integer y) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > y) {
                counter += 1;
            }
        }
        System.out.println(counter);
    }

    // how to do with this with out creating a new array?
    public ArrayList squareArray(Integer[] array) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            newArray.add(array[i] * array[i]);
            newArray.add(i, array[i]);
        }
        return newArray;
    }

    public ArrayList<Integer> noNegatives(Integer[] array) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                newArray.add(array[i]);
            }
        }
        return newArray;
    }

    public ArrayList minMaxAv(Integer[] array) {
        Integer min = array[0];
        Integer max = array[0];
        Integer sum = 0;
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        newList.add(min);
        newList.add(max);
        newList.add(sum / array.length);

        return newList;
    }

    public ArrayList shiftValsLeft(Integer[] array) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < array.length - 1; i++) {
            newList.add(array[i + 1]);
        }
        newList.add(0);
        return newList;
    }
}