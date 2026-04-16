package automation_basics;

import java.util.Scanner;

public class task3{
	public static void main(String[] args) {
		Scanner ab = new Scanner(System.in);
		
		System.out.println("enter your number");
		int num = ab.nextInt();
		
		System.out.println("sqaure:" + num*num);
		System.out.println("cube:" + num*num*num);
		
	}
}