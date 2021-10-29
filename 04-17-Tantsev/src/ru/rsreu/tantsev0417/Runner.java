package ru.rsreu.tantsev0417;

import java.util.Locale;

public class Runner {

	/**
	 * Sizes of a two-dimensional array with variable length rows.
	 */
	private static final int[] ARRAY_SIZES = { 4, 5, 3, 6, 4 };

	/**
	 * The lower limit of the range of values of generated random numbers.
	 */
	private static final int ARRAY_ELEMENTS_GENERATED_VALUES_RANGE_LOWER_LIMIT = -10;

	/**
	 * The upper limit of the range of values of generated random numbers.
	 */
	private static final int ARRAY_ELEMENTS_GENERATED_VALUES_RANGE_UPPER_LIMIT = 10;

	/**
	 * Constructor
	 */
	private Runner() {
	}

	/**
	 * The entry point to the program.
	 * 
	 * @param args command line arguments.
	 */
	public static void main(String[] args) {
		ArrayElementsSignsInverter arrayElementsSignsInverter = new ArrayElementsSignsInverter(ARRAY_SIZES);
		arrayElementsSignsInverter.fill(ARRAY_ELEMENTS_GENERATED_VALUES_RANGE_LOWER_LIMIT,
				ARRAY_ELEMENTS_GENERATED_VALUES_RANGE_UPPER_LIMIT);
		StringBuilder result = new StringBuilder();

		Locale.setDefault(Locale.US);

		result.append(Resourcer.getString("message.array.original")).append("\n").append(arrayElementsSignsInverter)
				.append("\n").append("\n");
		arrayElementsSignsInverter.changeElementSignToOppositeInEachArrayRow();
		result.append(Resourcer.getString("message.array.resulting")).append("\n").append(arrayElementsSignsInverter);

		System.out.println(result);
	}
}
