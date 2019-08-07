package bankAccounts;
import java.util.Random;

public class BankAccount {
	Random rand = new Random();
	// is there a reason they want this to be string?
	private int accountNumber;
	private Double checking = 0.00;
	private Double savings = 0.00;
	
	private static int activeAccounts=0;
	private static Double totalMoney=0.0;
	
	public BankAccount() {
		activeAccounts += 1;
		accountNumber = generateAccountNumber();
	}
	
	private int generateAccountNumber() {
		int acntNumber = rand.nextInt(2000000000);
		return acntNumber;		
	}
	
	public void displayTotalBalance() {
		Double total = checking + savings;
		System.out.println(String.format("your balance is : %.2f",total ));
	}
	
	public void displayChecking() {
		System.out.println(String.format("your checking balance is : %.2f", checking));
	}
	public void displaySavings() {
		System.out.println(String.format("your savings balance is : %.2f", savings));
	}
	public void displayAccountNumber() {
		System.out.println(String.format("your account number is : %d", accountNumber));
	}
	
	public void depositIntoChecking(double deposit) {
		totalMoney += deposit;
		checking += deposit;
		displayChecking();
	}
	public void depositIntoSavings(double deposit) {
		totalMoney += deposit;
		savings += deposit;
		displaySavings();
	}
	
	public void withdrawFromChecking(double withdraw) {
		totalMoney -= withdraw;
		checking -= withdraw;
		displayChecking();
	}
	public void withdrawFromSavings(double withdraw) {
		totalMoney -= withdraw;
		savings -= withdraw;
		displaySavings();
	}
	
	static void displayTotals() {
		System.out.println(String.format("total accounts %d : total money %.2f", activeAccounts, totalMoney));
	}
	
}
