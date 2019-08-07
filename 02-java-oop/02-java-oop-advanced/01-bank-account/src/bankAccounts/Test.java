package bankAccounts;

public class Test {

	public static void main(String[] args) {
		BankAccount acnt1 = new BankAccount();
		
		BankAccount.displayTotals();
		acnt1.displayTotalBalance();
		acnt1.depositIntoSavings(100.00);
		acnt1.depositIntoChecking(150.00);
		acnt1.withdrawFromChecking(50.00);
		acnt1.displayTotalBalance();
		
		BankAccount.displayTotals();

	}

}
