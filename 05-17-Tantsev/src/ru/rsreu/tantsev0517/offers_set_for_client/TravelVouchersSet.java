package ru.rsreu.tantsev0517.offers_set_for_client;

import java.util.Arrays;

import ru.rsreu.tantsev0517.travelvouchers.TherapeuticTour;
import ru.rsreu.tantsev0517.travelvouchers.TravelVoucher;

public class TravelVouchersSet {

	private TravelVoucher[] travelVouchers;

	public TravelVouchersSet(TravelVoucher[] travelVoucher) {
		this.travelVouchers = travelVoucher;
	}

	public TravelVoucher[] getTravelVoucher() {
		return this.travelVouchers;
	}

	public void sortByDaysNumber() {
		Arrays.sort(this.travelVouchers);
	}

	public TravelVoucher find(int daysNumber) {
		TherapeuticTour key = new TherapeuticTour(daysNumber);
		int index = Arrays.binarySearch(this.travelVouchers, key);
		if (index >= 0) {
			return travelVouchers[index];
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < travelVouchers.length; i++) {
			result.append("\n").append(travelVouchers[i].toString()).append("\n");
		}
		return result.toString();
	}
}
