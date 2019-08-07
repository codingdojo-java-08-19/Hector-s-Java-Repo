package humanSubClasses;
import baseClasses.Human;

public class Wizard extends Human{
	public Wizard() {
		intelligence = 8;
		health = 50;
	}
	
	public void heal(Human player) {
		player.health += intelligence;
	}
	
	public void fireBall(Human player) {
		player.health -= intelligence *3;
	}
}
