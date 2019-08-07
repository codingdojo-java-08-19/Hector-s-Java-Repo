package zoo;

// energy level did not need to be protected for gorilla but did for bat?
public class Gorilla extends Mammal{
	public void throwSomething(){
		 energyLevel -= 5;
	}
	public void eatBanna() {
		energyLevel += 10;
	}
	public void climb() {
		energyLevel -= 10;
	}
}
