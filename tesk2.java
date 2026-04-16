package automation_basics;

import java.util.Scanner;

public class tesk2 {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number");
		int num1 = sc.nextInt();
		
		System.out.println("enter second number");
		int num2 = sc.nextInt();
		
		System.out.println("Addition:" + (num1 + num2));
		System.out.println("multi:" + (num1 - num2));
		System.out.println("sub:"+ (num1 * num2));
		System.out.println("div:" + (num1 / num2));
		
	}

}
