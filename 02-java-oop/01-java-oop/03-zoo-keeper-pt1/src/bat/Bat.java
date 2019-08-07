package bat;
import zoo.Mammal;

public class Bat extends Mammal{
	
	public Bat() {
		energyLevel = 300;
	}
	
	public void eatManFlesh() {
		energyLevel += 50;
	}
	public void fly() {
		energyLevel -= 50;
		System.out.println("Whoosh!");
	}
	public void attackATown() {
		energyLevel -= 100;
	}
	
}
