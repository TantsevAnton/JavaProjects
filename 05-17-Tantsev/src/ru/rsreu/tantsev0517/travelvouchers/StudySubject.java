package ru.rsreu.tantsev0517.travelvouchers;

public enum StudySubject {
	FOREIGN_LANGUAGE(4000) {
		@Override
		public String toString() {
			return "Foreign language";
		}
	},
	PHYSICS(3300) {
		@Override
		public String toString() {
			return "Physics";
		}
	},
	MATHS(2900) {
		@Override
		public String toString() {
			return "Maths";
		}
	},
	PROGRAMMING(3800) {
		@Override
		public String toString() {
			return "Programming";
		}
	},
	CHEMISTRY(2500) {
		@Override
		public String toString() {
			return "Chemistry";
		}
	},
	BIOLOGY(2000) {
		@Override
		public String toString() {
			return "Biology";
		}
	},
	PHILOSOPHY(1000) {
		@Override
		public String toString() {
			return "Philosophy";
		}
	};

	private double costPerDay;

	StudySubject(double cost) {
		this.costPerDay = cost;
	}

	public double getCostPerDay() {
		return this.costPerDay;
	}
}
