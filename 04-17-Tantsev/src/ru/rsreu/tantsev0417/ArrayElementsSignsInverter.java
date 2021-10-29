package ru.rsreu.tantsev0417;

import com.prutzkow.twodimarray.TwoDimArray;

public class ArrayElementsSignsInverter extends TwoDimArray {

	/**
	 * A constructor that creates a two-dimensional array with variable length rows.
	 * 
	 * @param sizes the sizes of the two-dimensional array being created.
	 */
	public ArrayElementsSignsInverter(int... sizes) {
		super(sizes);
	}

	/**
	 * Calculates the sum of the elements to the left of the considered element.
	 * 
	 * @param arrayRowIndex             the index of the considered row of the
	 *                                  array.
	 * @param rowConsideredElementIndex index of the row element in question.
	 * @return the sum of elements located to the left of the considered element.
	 */
	private int calculateElementsSumOnLeft(int arrayRowIndex, int rowConsideredElementIndex) {
		int elementsSumOnLeft = 0;
		for (int i = 0; i < rowConsideredElementIndex; i++) {
			elementsSumOnLeft += this.arrayBody[arrayRowIndex][i];
		}
		return elementsSumOnLeft;
	}

	/**
	 * Calculates the sum of the elements to the right of the considered element.
	 * 
	 * @param arrayRowIndex             the index of the considered row of the
	 *                                  array.
	 * @param rowConsideredElementIndex index of the row element in question.
	 * @return the sum of elements located to the right of the considered element.
	 */
	private int calculateElementsSumOnRight(int arrayRowIndex, int rowConsideredElementIndex) {
		int elementsSumOnRight = 0;
		for (int i = rowConsideredElementIndex + 1; i < super.getRowLength(arrayRowIndex); i++) {
			elementsSumOnRight += this.arrayBody[arrayRowIndex][i];
		}
		return elementsSumOnRight;
	}

	/**
	 * For each element of the row, it calculates the difference between the sum of
	 * the elements located to the left of this element and the sum of elements
	 * located to the right. All elements of the row except the first and the last
	 * are considered.
	 * 
	 * @param arrayRowIndex the index of the considered row of the array.
	 * @return an array of differences.
	 */
	private int[] calculateDifferenceBetweenSumsForEachConsideredRowElement(int arrayRowIndex) {
		int rowConsideredElementsNumber = super.getRowLength(arrayRowIndex) - 2;
		int[] differences = new int[rowConsideredElementsNumber];
		for (int i = 1; i < super.getRowLength(arrayRowIndex) - 1; i++) {
			int elementsSumOnLeft = calculateElementsSumOnLeft(arrayRowIndex, i);
			int elementsSumOnRight = calculateElementsSumOnRight(arrayRowIndex, i);
			differences[i - 1] = Math.abs(elementsSumOnLeft - elementsSumOnRight);
		}
		return differences;
	}

	/**
	 * Searches for the element for which difference of the sum of elements located
	 * to the left of this element and the sum of elements located to the right is
	 * minimal.
	 * 
	 * @param differences array of all differences.
	 * @return the index of an element for which difference between the sums is
	 *         minimal.
	 */
	private int getElementIndexWithMinimumDifferenceBetweenSums(int[] differences) {
		int minimumDifferenceBetweenSums = differences[0];
		int elementIndexWithMinimumDifferenceBetweenSums = 1;
		for (int i = 0; i < differences.length; i++) {
			if (minimumDifferenceBetweenSums > differences[i]) {
				minimumDifferenceBetweenSums = differences[i];
				elementIndexWithMinimumDifferenceBetweenSums = i + 1;
			}
		}
		return elementIndexWithMinimumDifferenceBetweenSums;
	}

	/**
	 * In each row of the array changes to the opposite sign the element of the row,
	 * for which the difference in the sum of the elements located to the left of
	 * this element and the sum of the elements located to the right is minimal. All
	 * elements of the row except the first and the last are considered.
	 */
	public void changeElementSignToOppositeInEachArrayRow() {
		for (int i = 0; i < super.getRowCount(); i++) {
			int[] differencesArray = calculateDifferenceBetweenSumsForEachConsideredRowElement(i);
			int rowSearchedElementIndex = getElementIndexWithMinimumDifferenceBetweenSums(differencesArray);
			this.arrayBody[i][rowSearchedElementIndex] *= -1;
		}
	}

	/**
	 * Fills array fields with random numbers.
	 * 
	 * @param generatedRandomNumbersRangeLowerLimit the lower limit of the range of
	 *                                              values of generated random
	 *                                              numbers.
	 * @param generatedRandomNumbersRangeUpperLimit the upper limit of the range of
	 *                                              values of generated random
	 *                                              numbers.
	 */
	public void fill(int generatedRandomNumbersRangeLowerLimit, int generatedRandomNumbersRangeUpperLimit) {
		for (int i = 0; i < super.getRowCount(); i++) {
			for (int j = 0; j < super.getRowLength(i); j++) {
				this.arrayBody[i][j] = (int) (Math.random()
						* (generatedRandomNumbersRangeUpperLimit - generatedRandomNumbersRangeLowerLimit + 1)
						+ generatedRandomNumbersRangeLowerLimit);
			}
		}
	}

	/**
	 * Returns the array elements and the sum of the first and last elements of the
	 * array.
	 */
	@Override
	public String toString() {
		int lastRowIndex = super.getRowCount() - 1;
		int lastElementIndexInLastRow = super.getRowLength(lastRowIndex) - 1;
		int arrayFirstAndLastElementsSum = this.arrayBody[0][0]
				+ this.arrayBody[lastRowIndex][lastElementIndexInLastRow];
		StringBuilder stringWithDataToOutput = new StringBuilder();
		stringWithDataToOutput.append(super.toString())
				.append(Resourcer.getString("message.array.first.and.last.elements.sum"))
				.append(arrayFirstAndLastElementsSum);
		return stringWithDataToOutput.toString();
	}
}
