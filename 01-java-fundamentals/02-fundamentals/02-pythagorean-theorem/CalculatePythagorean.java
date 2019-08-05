public class CalculatePythagorean {
    public static void main(String[] args) {
        int legA = 5;
        int legB = 6;
        Pythagorean calHyp = new Pythagorean();
        double hyp = calHyp.calculateHypotenuse(legA, legB);
        double hyp2 = calHyp.calculateHypotenuse(legA);
        System.out.println("here is the hypotenuse" + hyp);
        System.out.println("here is the hypotenuse" + hyp2);
    }

}