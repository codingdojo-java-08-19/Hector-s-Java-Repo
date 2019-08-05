public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double hyp = (legA * legA) + (legB * legB);
        return Math.sqrt(hyp);
    }

    public double calculateHypotenuse(int legA) {

        return this.calculateHypotenuse(legA, 10);
    }

}