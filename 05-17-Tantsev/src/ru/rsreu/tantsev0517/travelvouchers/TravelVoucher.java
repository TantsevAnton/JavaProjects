package ru.rsreu.tantsev0517.travelvouchers;

import ru.rsreu.tantsev0517.Resourcer;

public abstract class TravelVoucher implements Comparable<TravelVoucher> {

	private String name;
	private int daysNumber;
	private Transport transport;
	private Nutrition nutrition;
	private TravelAgency travelAgency;

	public TravelVoucher(TravelAgency travelAgency, String name, int daysNumber, Transport transport,
			Nutrition nutrition) {
		this.travelAgency = travelAgency;
		this.name = name;
		this.daysNumber = daysNumber;
		this.transport = transport;
		this.nutrition = nutrition;
	}

	public TravelVoucher(int daysNumber) {
		this.daysNumber = daysNumber;
	}

	public TravelAgency getTravelAgency() {
		return this.travelAgency;
	}

	public String getName() {
		return this.name;
	}

	public int getDaysNumber() {
		return this.daysNumber;
	}

	public void setDaysNumber(int daysNumber) {
		this.daysNumber = daysNumber;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Nutrition getNutrition() {
		return this.nutrition;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	public abstract double calculateCostTour();

	@Override
	public int compareTo(TravelVoucher travelVoucher) {
		return (int) Math.round(this.getDaysNumber() - travelVoucher.getDaysNumber());
	}

	@Override
	public String toString() {
		StringBuilder stringWithDataToOutput = new StringBuilder();
		stringWithDataToOutput.append(travelAgency.toString()).append("\n")
				.append(Resourcer.getString("message.travel.voucher.name")).append(this.name).append("\n")
				.append(Resourcer.getString("message.days.number")).append(this.daysNumber).append("\n")
				.append(Resourcer.getString("message.transport")).append(this.transport).append("\n")
				.append(Resourcer.getString("message.nutrition")).append(this.nutrition);
		return stringWithDataToOutput.toString();
	}
}
