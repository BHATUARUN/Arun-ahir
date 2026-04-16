	package automation_basics;
	
	import java.util.Scanner;
	
	public class task5 {
		public static void main(String[] args) {
			Scanner ab = new Scanner(System.in);
			
			System.out.println("enter first number");
			int num = ab.nextInt();
			
			System.out.println("enter second number");
			int num2 = ab.nextInt();
			
			double ans = (num * num2)/2;
			System.out.println("area of tringles:" + ans);
			
			
		}
	
	}
