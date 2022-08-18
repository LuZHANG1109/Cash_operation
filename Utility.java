package cash_operations;
import java.util.Scanner;
public class Utility {
	public static Scanner sc = new Scanner(System.in); 
	public static char readMenuSelection() {
		char c;
		for(;;) {
			c = sc.next().charAt(0);
			if(c!='1'&&c!='2'&&c!='3'&&c!='4') {
				System.out.print("Error, please input again：");
			}else break;
		}
		return c;
	}
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			c = sc.next().charAt(0);
			if(c=='Y' || c=='N') {
				break;
			}else {
				System.out.print("Error, please input again：");
			}
		}
		return c;
	}
	public static int readNumber() {
		sc.nextLine();
		String line=sc.nextLine();
		int n=Integer.parseInt(line);
		return(line.length()==0)?666:n;
			
	}
	
	public static String readString() {
		String s = sc.next(); 
		return s;
	}
}

