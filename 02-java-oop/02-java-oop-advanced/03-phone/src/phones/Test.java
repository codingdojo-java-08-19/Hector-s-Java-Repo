package phones;

public abstract class Test {

	public static void main(String[] args) {
		IPhone iphone = new IPhone("X",100,"Verizon","doink!");
		Galaxy galaxy = new Galaxy("9s",99, "At&t", "bluudadoo-doo, bluudadoo-dooo, bluudoooo-doo-doo-dooo");
		
		
		iphone.displayInfo();
		System.out.println(iphone.ring());
		System.out.println(iphone.unlock());
		
		galaxy.displayInfo();
		System.out.println(galaxy.ring());
		System.out.println(galaxy.unlock());
		
	}

}
