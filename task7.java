package automation_basics;

import java.util.Scanner;

public class task7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter marks of 5 subjects:");

		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int s3 = sc.nextInt();
		int s4 = sc.nextInt();
		int s5 = sc.nextInt();

		int sum = s1 + s2 + s3 + s4 + s5;

		double percentage = sum / 5.0;

		System.out.println("Total: " + sum);
		System.out.println("Percentage: " + percentage);
	}
}