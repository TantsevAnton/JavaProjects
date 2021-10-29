package ru.rsreu.tantsev0517.travelvouchers;

import ru.rsreu.tantsev0517.Resourcer;

public class TherapeuticTour extends TravelVoucher {

	private static final double DRY_CARBONIC_BATH_SESSION_COST = 1000;
	private static final double NANUAL_MASAGE_SESSION_COST = 2000;

	private int dryCarbonicBathSessionsNumber;
	private int manualMassageSessionsNumber;

	public TherapeuticTour(TravelAgency travelAgency, String name, int daysNumber, Transport transport,
			Nutrition nutrition, int dryCarbonicBathSessionsNumber, int manualMassageSessionsNumber) {
		super(travelAgency, name, daysNumber, transport, nutrition);
		this.dryCarbonicBathSessionsNumber = dryCarbonicBathSessionsNumber;
		this.manualMassageSessionsNumber = manualMassageSessionsNumber;
	}

	public TherapeuticTour(int daysNumber) {
		super(daysNumber);
	}

	public int getDryCarbonicBathSessionsNumber() {
		return this.dryCarbonicBathSessionsNumber;
	}

	public int getManualMassageSessionsNumber() {
		return this.manualMassageSessionsNumber;
	}

	@Override
	public double calculateCostTour() {
		Transport transportCost = getTransport();
		Nutrition nutritionCost = getNutrition();
		double costTour = this.dryCarbonicBathSessionsNumber * DRY_CARBONIC_BATH_SESSION_COST
				+ this.manualMassageSessionsNumber * NANUAL_MASAGE_SESSION_COST + transportCost.getCost()
				+ nutritionCost.getCostPerDay() * getDaysNumber();
		return costTour;
	}

	@Override
	public String toString() {
		StringBuilder stringWithDataToOutput = new StringBuilder();
		stringWithDataToOutput.append(super.toString()).append("\n")
				.append(Resourcer.getString("message.dry.carbonic.bath.sessions.number"))
				.append(this.dryCarbonicBathSessionsNumber).append("\n")
				.append(Resourcer.getString("message.manual.massage.sessions.number"))
				.append(this.manualMassageSessionsNumber).append("\n").append(Resourcer.getString("message.cost.tour"))
				.append(calculateCostTour());
		return stringWithDataToOutput.toString();
	}
}
