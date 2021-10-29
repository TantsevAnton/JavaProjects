package ru.rsreu.tantsev0317;

import java.util.Locale;

public class Runner {
	private static final int[] INPUT_ARRAY = { 0, 1, 4, -2, 5, 11 };

	private Runner() {
	}

	public static void main(String[] args) {
		ArrayReverser arrayReverser = new ArrayReverser(INPUT_ARRAY);
		StringBuilder result = new StringBuilder();

		Locale.setDefault(Locale.US);

		result.append(Resourcer.getString("message.array.original")).append("\n").append(arrayReverser).append("\n");
		arrayReverser.reverseWithPredominanceOfPositiveElements();
		result.append(Resourcer.getString("message.array.resulting")).append("\n").append(arrayReverser);

		System.out.println(result);
	}
}