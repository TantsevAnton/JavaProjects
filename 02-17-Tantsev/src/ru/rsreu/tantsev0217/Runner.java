package ru.rsreu.tantsev0217;

import java.util.Scanner;

public class Runner {
	private Runner() {
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter number of strings: n = ");
		int stringCount = Integer.parseInt(in.next());
		in.nextLine();

		String[] stringArray = new String[stringCount];
		for (int i = 0; i < stringArray.length; i++) {
			System.out.printf("Enter %d string:%n", i + 1);
			stringArray[i] = in.nextLine();
		}

		System.out.println();

		for (int i = 0; i < stringArray.length; i++) {
			String[] trimmedStrings = new String[stringCount];
			trimmedStrings[i] = stringArray[i].trim();

			if (!trimmedStrings[i].isEmpty()) {
				String nonrepeatingWords = NonrepeatingWordsFinder.getNonrepeatingWords(trimmedStrings[i]);
				if (!nonrepeatingWords.isEmpty()) {
					System.out.printf("Words found in %d string once: %s%n", i + 1, nonrepeatingWords);
				} else {
					System.out.printf("In string %d there are no words occurring once!%n", i + 1);
				}
			} else {
				System.out.printf("String %d is empty!%n", i + 1);
			}
		}

		in.close();
	}
}
