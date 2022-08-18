package cash_operations;

import FamilyAccount.Utility;

public class cash_operation {
	public static void main(String[] args) {
		boolean isFlag=true;
		String details="";
		int balance=10000;
		while(isFlag){
			System.out.println("-----FamilyAccount-----");
			System.out.println("1. List bank account balance");
			System.out.println("2. Money deposit");
			System.out.println("3. Money withdrawal");
			System.out.println("4. Exit\n");
			System.out.println("     Choose(1-4):");
			char selection=Utility.readMenuSelection();
			switch(selection) {
			case'1':
				System.out.println("------Current Record------");
				System.out.println("Operation\tBalance\tAmount\tDescription\n");
				System.out.println(details);
				break;
			case'2':
				System.out.print("Deposit Amount: ");
				int money_in=Utility.readNumber();
				
				System.out.print("Deposit Description: ");
				String info_in=Utility.readString();
				balance+=money_in;
				details+=("Deposit\t"+balance+"\t"+money_in+"\t"+info_in+"\n");
				System.out.println("-------Deposit succeed---------");
				break;
			case'3':
				System.out.print("Withdrawal Amount: ");
				int money_out=Utility.readNumber();
				System.out.print("Withdrawal Description");
				String info_out=Utility.readString();
				balance-=money_out;
				if (balance>=0) {
					details+=("Withdrawal\t"+balance+"\t"+money_out+"\t"+info_out+"\n");
					System.out.println("-------Withdrawal succeed---------");
				}else {
					System.out.println("Overdrew!");
				}
				break;
			case'4':
				System.out.print("Confirm(Y/N):");
				char isExist=Utility.readConfirmSelection();
				if(isExist=='Y') {
					isFlag=false;
				}
			}
		}
	}
}
