package test;
import baseClasses.Human;
import humanSubClasses.Ninja;
import humanSubClasses.Wizard;
import humanSubClasses.Samuri;

public class PlayerTestingGround {

	public static void main(String[] args) {
		Human dummy1 = new Human();
		Wizard biaz = new Wizard();
		Ninja gaiden = new Ninja();
		Samuri hectoro = new Samuri();
		
		biaz.fireBall(dummy1);
		System.out.println("biaz used fire ball on dummy");
		dummy1.showStatus();
		biaz.heal(dummy1);
		System.out.println("biaz used heal on dummy");
		dummy1.showStatus();
		
		gaiden.steal(dummy1);
		System.out.println("gaiden used fire steal on dummy");
		dummy1.showStatus();
		gaiden.showStatus();
		gaiden.runAway();
		System.out.println("gaiden ran away");
		gaiden.showStatus();
		
		hectoro.deathBlow(dummy1);
		System.out.println("hectoro used deathblow on dummy");
		dummy1.showStatus();
		hectoro.showStatus();
		hectoro.meditate();
		System.out.println("hectoro used meditate");
		hectoro.showStatus();
		
		Samuri challenger = new Samuri();
		Samuri challenger2 = new Samuri();
		Samuri challenger3 = new Samuri();
		System.out.println("hectoro detakes more challengers");
		hectoro.howMany();
	}

}
