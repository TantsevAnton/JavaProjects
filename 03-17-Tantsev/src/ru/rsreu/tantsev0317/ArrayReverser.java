package ru.rsreu.tantsev0317;

import java.util.Arrays;

public class ArrayReverser {
	private int[] arrayBody;

	public ArrayReverser(int... args) {
		this.arrayBody = new int[args.length];
		setArrayElements(args);
	}

	public final void setArrayElements(int... args) {
		int length = args.length;
		for (int i = 0; i < length; i++) {
			this.arrayBody[i] = args[i];
		}
	}

	private int countNumberOfPositiveElements() {
		int numberOfPositiveElements = 0;
		int length = this.arrayBody.length;
		for (int i = 0; i < length; i++) {
			if (this.arrayBody[i] > 0) {
				numberOfPositiveElements++;
			}
		}
		return numberOfPositiveElements;
	}

	private int countNumberOfNonpositiveElements() {
		int numberOfNonpositiveElements = 0;
		int length = this.arrayBody.length;
		for (int i = 0; i < length; i++) {
			if (this.arrayBody[i] <= 0) {
				numberOfNonpositiveElements++;
			}
		}
		return numberOfNonpositiveElements;
	}

	private void reverse() {
		int length = this.arrayBody.length;
		for (int i = 0; i < length / 2; i++) {
			int temp = this.arrayBody[i];
			this.arrayBody[i] = this.arrayBody[length - i - 1];
			this.arrayBody[length - i - 1] = temp;
		}
	}

	public void reverseWithPredominanceOfPositiveElements() {
		int positiveElementsCount = countNumberOfPositiveElements();
		int nonpositiveElementsCount = countNumberOfNonpositiveElements();
		if (positiveElementsCount > nonpositiveElementsCount) {
			reverse();
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(this.arrayBody);
	}
}
