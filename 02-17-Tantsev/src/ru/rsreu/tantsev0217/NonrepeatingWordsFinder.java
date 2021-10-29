package ru.rsreu.tantsev0217;

public class NonrepeatingWordsFinder {
	private static final String DELIMITER = " ";

	private NonrepeatingWordsFinder() {

	}

	public static String getNonrepeatingWords(String trimmedString) {
		String stringInLowerCase = trimmedString.toLowerCase();
		String[] words = stringInLowerCase.split(DELIMITER);
		StringBuilder wordsFoundOnce = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			int numberOccurrences = countNumberOccurrences(words, words[i]);
			if (numberOccurrences == 1) {
				wordsFoundOnce.append(words[i]).append(DELIMITER);
			}
		}

		String stringWithWordsFoundOnce = wordsFoundOnce.toString();
		return stringWithWordsFoundOnce.trim();
	}

	private static int countNumberOccurrences(String[] wordArray, String word) {
		int number = 0;
		for (int i = 0; i < wordArray.length; i++) {
			if (word.equals(wordArray[i])) {
				number++;
			}
		}
		return number;
	}
}
