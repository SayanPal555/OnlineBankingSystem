import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<-----Welcome to ABC Bank ----->");
		System.out.println("************************************");
		
		System.out.println("Enter ACCOUNT NUMBER : ");
		int accNo = sc.nextInt();
		sc.nextLine(); //for scanning next line
		System.out.println("Enter ACCOUNT HOLDER NAME : ");
		String accHoldName = sc.nextLine();
		
		BankAccount obj = new BankAccount(accNo, accHoldName);
		obj.menu();
		
	}

}

class BankAccount{
	
	Scanner sc1 = new Scanner(System.in);
	
	double bal, prevTran;
	
	int accNum;
	String name;
	
	int ch;
	
	BankAccount(int accNumber, String accHname){
		this.accNum =accNumber;
		this.name = accHname;
	}
	
	void checkBal() {
		System.out.println("Account Holder Name: " + name + "\n" + "Account Number: " + accNum);
		System.out.println("Current Balance : " + bal);
	}
	void deposit() {
		System.out.println("Enter amount to deposit: ");
		double amount = sc1.nextDouble();
		if(amount > 0) {
			bal += amount; //bal = bal + amount;
			prevTran = amount;
			System.out.println("Rs " + amount + " deposit Successfully...");
		}
		else
			System.out.println("Please enter currect amount!!!");
	}
	
	void withdraw() {
		System.out.println("Enter amount to withdraw: ");
		double amount = sc1.nextDouble();
		if(amount != 0 && bal > amount) {
			bal -= amount; //bal = bal - amount;
			prevTran =- amount; //prevTran = (-ve value of amount);
			System.out.println("Rs " + amount + " withdraw successfully...");
		}
		else if(amount == 0) {
			System.out.println("Please enter some amount..");
		}
		else {
			System.out.println("Bank Balance Insufficience!!!");
		}
		
	}
	void previousTransaction() {
		if(prevTran > 0) {
			System.out.println("Previously Deposited : " + prevTran);
		}
		else if(prevTran < 0) {
			System.out.println("Previously Withdrawn : " + Math.abs(prevTran));
		}
		else
		{
			System.out.println("Sorry.... No Transaction occured previously...");
		}
	}
	
	
	void  menu() {
		System.out.println("Welcome " + name + " , Your Account Number is: " + accNum);
		
		do {
			System.out.println("---------------------------- \n");
			System.out.println("Enter 1) : For Check Balance");
			System.out.println("Enter 2) : For Deposit Amount");
			System.out.println("Enter 3) : For Withdraw Amount");
			System.out.println("Enter 4) : To Check Previous Transaction");
			System.out.println("Enter 5) : For Exit");
			
			System.out.println("----------------------------- \n");
			System.out.println("Pease Enter your choise (1-5) : ");
			ch = sc1.nextInt();
			
			System.out.println("----------------------------- \n");
			
			switch(ch) {
			case 1: 
				checkBal();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				previousTransaction();
				break;
			case 5:
				System.out.println("-----------------------------");
				break;
			default :
				System.out.println("Choose a currect option!!!");
			}
			
		}while(ch != 5);
		
		System.out.println("Thank you for using Online ABC Bank...");
	}
	
	
}
