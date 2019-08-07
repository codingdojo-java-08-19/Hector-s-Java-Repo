package humanSubClasses;
import baseClasses.Human;

public class Ninja extends Human{
	public Ninja() {
		stealth = 10;
	}
	public void steal(Human player) {
		player.health -= stealth;
		health += stealth;
	}
	public void runAway() {
		health -= 10;
	}
}
