package ru.rsreu.tantsev0517.travelvouchers;

import ru.rsreu.tantsev0517.Resourcer;

public class SportsTour extends TravelVoucher {

	private static final double MOUNTAIN_HIKES_KM_COST = 1000;
	private static final double WATER_HIKES_KM_COST = 2000;

	private double mountainHikesLength;
	private double waterHikesLength;

	public SportsTour(TravelAgency travelAgency, String name, int daysNumber, Transport transport, Nutrition nutrition,
			double mountainHikesLength, double waterHikesLength) {
		super(travelAgency, name, daysNumber, transport, nutrition);
		this.mountainHikesLength = mountainHikesLength;
		this.waterHikesLength = waterHikesLength;
	}

	public double getMountainHikesLength() {
		return this.mountainHikesLength;
	}

	public double getWaterHikesLength() {
		return this.waterHikesLength;
	}

	@Override
	public double calculateCostTour() {
		Transport transportCost = getTransport();
		Nutrition nutritionCost = getNutrition();
		double costTour = this.mountainHikesLength * MOUNTAIN_HIKES_KM_COST
				+ this.waterHikesLength * WATER_HIKES_KM_COST + transportCost.getCost()
				+ nutritionCost.getCostPerDay() * getDaysNumber();
		return costTour;
	}

	@Override
	public String toString() {
		StringBuilder stringWithDataToOutput = new StringBuilder();
		stringWithDataToOutput.append(super.toString()).append("\n")
				.append(Resourcer.getString("message.mountain.hikes.length")).append(this.mountainHikesLength)
				.append("\n").append(Resourcer.getString("message.water.hikes.length")).append(this.waterHikesLength)
				.append("\n").append(Resourcer.getString("message.cost.tour")).append(calculateCostTour());
		return stringWithDataToOutput.toString();
	}
}
