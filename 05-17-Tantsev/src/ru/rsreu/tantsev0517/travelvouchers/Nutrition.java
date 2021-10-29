package ru.rsreu.tantsev0517.travelvouchers;

public enum Nutrition {
	FB(1500), HB(1000), BB(500), AI(3000), UAI(5500);

	private double costPerDay;

	Nutrition(double cost) {
		this.costPerDay = cost;
	}

	public double getCostPerDay() {
		return this.costPerDay;
	}
}
