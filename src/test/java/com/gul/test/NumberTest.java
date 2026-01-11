package com.gul.test;

public class NumberTest {
	public static void main(String[] args) {
		int x = 10;
		int y = 12;
		if (x + y < 20) {
			System.out.println("x + y is greater than 20");
		} else if (x + y == 22) {
			System.out.println("yes");
		} else {
			System.out.println("Not");
		}

		for (int i = 0; i < 20; i++) {

//			System.out.println("Count: "+i);

		}

		for (int i = 0; i < 5; i++) {

//			System.out.println("Count: " + i);
			for (int j = 0; j < 4; j++) {

//				System.out.println(i + " : Count: " + j);

			}

		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();// new line
		}

	}

}
