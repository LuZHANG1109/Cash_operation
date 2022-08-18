package cash_operations;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import cash_operations.Utility;

public class cash_operation {
	public static void main(String[] args) {
		boolean isFlag=true;
		String details="";
		ArrayList<String[]> accounts=new ArrayList();
		ArrayList<String[]> transactions=new ArrayList();
		int OSL_FEE=0;
		while(isFlag){
			System.out.println("-----Cash Operations-----");
			System.out.println("0. Account Creation");
			System.out.println("1. List bank account balance");
			System.out.println("2. Money deposit");
			System.out.println("3. Money withdrawal");
			System.out.println("4. Money transfer");
			System.out.println("5. Display transaction statement");
			System.out.println("6. Exit\n");
			System.out.println("Choose(0-6):");
			char selection=Utility.readMenuSelection();
			switch(selection) {
			case'0':
				String[] newAccount=new String[3];
				System.out.print("Username: ");
				String username=Utility.readString();
				newAccount[0]=username;
				System.out.print("Currency Name: ");
				String cur_name=Utility.readString();
				newAccount[1]=cur_name;
				System.out.print("Balance: ");
				String _balance=Utility.readString();
				newAccount[2]=cur_name;
				accounts.add(newAccount);
			case'1':
				System.out.println("Username: ");
				String _username=Utility.readString();
				for(int i=0;i<accounts.size();i++) {
					if(accounts.get(i)[0].equals(_username)) {
						System.out.println("Balance: "+accounts.get(i)[2]+" "+accounts.get(i)[1]);
					}
				}
				break;
			case'2':
				System.out.println("Username: ");
				String d_username=Utility.readString();
				System.out.print("Currency:");
				String d_cur=Utility.readString();
				System.out.print("Withdrawal Amount: ");
				System.out.print("Deposit Amount: ");
				int money_in=Utility.readNumber();
				System.out.print("Deposit Currency: ");
				String cur_in=Utility.readString();
				if(!(cur_in.equals("USD")||cur_in.equals("HKD")||cur_in.equals("SGD"))) {
					System.out.print("Currency not supported!");
					
				}else {
					System.out.print("Deposit Description: ");
					String info_in=Utility.readString();
					for(int i=0;i<accounts.size();i++) {
						if(accounts.get(i)[0].equals(d_username)) {
							accounts.get(i)[2]=Integer.toString(Integer.parseInt(accounts.get(i)[2])+money_in);
							String[] txinfo=new String[5];
							Date time=new Date(); 
							SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
							txinfo[0]=df.format(time);
							txinfo[1]=d_cur;
							txinfo[2]="Deposit";
							txinfo[3]="+"+Integer.toString(money_in);
							txinfo[4]=d_username;
							transactions.add(txinfo);
						}
					}
					System.out.println("-------Deposit succeed---------");
			
				}
				break;
			case'3':
				System.out.println("Username: ");
				String w_username=Utility.readString();
				System.out.print("Currency:");
				String w_cur=Utility.readString();
				System.out.print("Withdrawal Amount: ");
				int money_out=Utility.readNumber();
				System.out.print("Withdrawal Description");
				String info_out=Utility.readString();
				for(int i=0;i<accounts.size();i++) {
					if(accounts.get(i)[0].equals(w_username)) {
						if(Integer.parseInt(accounts.get(i)[2])<money_out){
							System.out.print("Overdrew!");
						}else {
							accounts.get(i)[2]=Integer.toString(Integer.parseInt(accounts.get(i)[2])-money_out);
							String[] txinfo=new String[5];
							Date time=new Date(); 
							SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
							txinfo[0]=df.format(time);
							txinfo[1]=w_cur;
							txinfo[2]="Withdrawal";
							txinfo[3]="-"+Integer.toString(money_out);
							txinfo[4]=w_username;
							transactions.add(txinfo);
							System.out.println("-------Withdrawal succeed---------");
						}
					}
				}
				break;
			case'4':
				System.out.print("Transfer from:");
				String fromname=Utility.readString();
				System.out.print("Transfer to:");
				String toname=Utility.readString();
				System.out.print("Transfer Currency:");
				String _cur=Utility.readString();
				System.out.print("Transfer Amount:");
				int _amount=Utility.readNumber();
				OSL_FEE+=0.01*_amount;
				_amount-=OSL_FEE;
				for(int i=0;i<accounts.size();i++) {
					if(accounts.get(i)[0].equals(fromname)) {
						if(Integer.parseInt(accounts.get(i)[2])<_amount){
							System.out.print("Transfer Failed:");
						}else {
							accounts.get(i)[2]=Integer.toString(Integer.parseInt(accounts.get(i)[2])-_amount);
						}
					}
				}
				for(int i=0;i<accounts.size();i++) {
					if(accounts.get(i)[0].equals(toname)) {
						accounts.get(i)[2]=Integer.toString(Integer.parseInt(accounts.get(i)[2])+_amount);
					}
				}
				String[] in_txinfo=new String[5];
				Date time=new Date(); 
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
				in_txinfo[0]=df.format(time);
				in_txinfo[1]=_cur;
				in_txinfo[2]="Transfer In";
				in_txinfo[3]="+"+Integer.toString(_amount);
				in_txinfo[4]=toname;
				transactions.add(in_txinfo);
				String[] out_txinfo=new String[5];
				out_txinfo[0]=df.format(time);
				out_txinfo[1]=_cur;
				out_txinfo[2]="Transfer Out";
				out_txinfo[3]="-"+Integer.toString(_amount);
				out_txinfo[4]=fromname;
				transactions.add(out_txinfo);
			case'5':
				System.out.println("Username: ");
				String tx_username=Utility.readString();
				for(int i=0;i<transactions.size();i++) {
					if(transactions.get(i)[0].equals(tx_username)) {
						System.out.println(Arrays.toString(transactions.get(i)));
					}
				}
			case'6':
				System.out.print("Confirm(Y/N):");
				char isExist=Utility.readConfirmSelection();
				if(isExist=='Y') {
					isFlag=false;
				}
			}
		}
	}
}
