package automation_basics;

import java.util.Scanner;

public class task6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int amount = 100000;
		float roi = 4.21F;
		int year = 2;
		
		float ans = amount*roi*year/100;
	//	System.out.println(ans);
		float fa = amount+ans;
		System.out.println(fa);
	}

}
