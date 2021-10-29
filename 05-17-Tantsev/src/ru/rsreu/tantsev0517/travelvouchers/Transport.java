package ru.rsreu.tantsev0517.travelvouchers;

public enum Transport {
	AIRCRAFT(5000) {
		@Override
		public String toString() {
			return "Aircraft";
		}
	},
	TRAIN(3000) {
		@Override
		public String toString() {
			return "Train";
		}
	},
	SHIP(10000) {
		@Override
		public String toString() {
			return "Ship";
		}
	},
	AUTOBUS(3300) {
		@Override
		public String toString() {
			return "Autobus";
		}
	};

	private double cost;

	Transport(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return this.cost;
	}
}
