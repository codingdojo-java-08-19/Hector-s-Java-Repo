package baseClasses;

public class Human {
	protected int strength = 3;
	protected int intelligence = 3;
	protected int stealth = 3;
	protected int health = 300;
	
	public void showStatus() {
		System.out.println(String.format("stats: Intelligence=%d // stealth=%d // strength=%d // health=%d", intelligence, stealth, strength, health));
	}
	
	public void attack(Human adversary) {
		adversary.health -= strength; 
	}
}
