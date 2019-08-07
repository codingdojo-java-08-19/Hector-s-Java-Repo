package test;
import baseClasses.Human;

public class PlayerTestingGround {

	public static void main(String[] args) {
		Human dummy1 = new Human();
		Human dummy2 = new Human();
		dummy1.attack(dummy2);
		
		dummy2.showStatus();
	}

}
