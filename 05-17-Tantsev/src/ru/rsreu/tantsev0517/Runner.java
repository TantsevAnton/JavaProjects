package ru.rsreu.tantsev0517;

import java.util.Locale;

import ru.rsreu.tantsev0517.initializer.TravelVouchersInitializer;
import ru.rsreu.tantsev0517.offers_set_for_client.TravelVouchersSet;
import ru.rsreu.tantsev0517.travelvouchers.TravelVoucher;

public class Runner {

	private static final int SEARCHED_DAYS_NUMBER = 20;

	private Runner() {

	}

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Locale.setDefault(Locale.US);
		TravelVouchersSet travelVouchersSet = new TravelVouchersSet(
				TravelVouchersInitializer.initializeTravelVouchers());
		result.append(Resourcer.getString("message.travel.vouchers.original.order")).append("\n")
				.append(travelVouchersSet.toString()).append("\n");
		travelVouchersSet.sortByDaysNumber();
		result.append(Resourcer.getString("message.sorted.travel.vouchers")).append("\n")
				.append(travelVouchersSet.toString()).append("\n");
		TravelVoucher foundtravelVoucher = travelVouchersSet.find(SEARCHED_DAYS_NUMBER);
		if (foundtravelVoucher != null) {
			result.append(Resourcer.getString("message.travel.voucher.found")).append("\n").append("\n")
					.append(foundtravelVoucher);
		} else {
			result.append(Resourcer.getString("message.travel.voucher.not.found"));
		}
		System.out.println(result.toString());
	}
}
