package humanSubClasses;
import baseClasses.Human;

public class Samuri extends Human{
	private static int howMany;
	public Samuri() {
		howMany += 1;
		health = 200;
	}
	public void deathBlow(Human player) {
		player.health -= player.health;
		health = health/2;
	}
	public void meditate() {
		health = 200;
	}
	public void howMany(){
		System.out.println(howMany);
	}
}

