package ru.rsreu.tantsev0517.initializer;

import ru.rsreu.tantsev0517.travelvouchers.*;

public class TravelVouchersInitializer {

	private TravelVouchersInitializer() {

	}

	public static TravelVoucher[] initializeTravelVouchers() {
		TherapeuticTour therapeuticTour = new TherapeuticTour(new TravelAgency("ToBeAmerica",
				"475 River Bend road, Naperville area, Chicago. USA", "8-930-783-33-62"), "Magnat Resort & Spa", 20,
				Transport.AIRCRAFT, Nutrition.HB, 8, 10);
		SportsTour sportsTour = new SportsTour(
				new TravelAgency("OstraBusinessTravel", "Winterbergerstr.17, 51109 Koln Germany", "491796835908"),
				"Abkhazia Kodorske gorge", 10, Transport.TRAIN, Nutrition.AI, 17, 10);
		EducationalTour educationalTour = new EducationalTour(
				new TravelAgency("TIT Group", "Jugoslavska 320/21, 12000- Praha 2, Czech Republic", "420-773175773"),
				"England London", 30, Transport.AUTOBUS, Nutrition.FB, StudySubject.FOREIGN_LANGUAGE,
				SuitableAgeCategory.STUDENT);
		TravelVoucher[] travelVouchers = { therapeuticTour, sportsTour, educationalTour };
		return travelVouchers;
	}
}
