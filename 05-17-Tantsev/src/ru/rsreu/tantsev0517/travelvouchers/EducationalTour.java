package ru.rsreu.tantsev0517.travelvouchers;

import ru.rsreu.tantsev0517.Resourcer;

public class EducationalTour extends TravelVoucher {

	private StudySubject studySubject;
	private SuitableAgeCategory suitableAgeCategory;

	public EducationalTour(TravelAgency travelAgency, String name, int daysNumber, Transport transport,
			Nutrition nutrition, StudySubject studySubject, SuitableAgeCategory suitableAgeCategory) {
		super(travelAgency, name, daysNumber, transport, nutrition);
		this.studySubject = studySubject;
		this.suitableAgeCategory = suitableAgeCategory;
	}

	public StudySubject getStudySubject() {
		return this.studySubject;
	}

	public SuitableAgeCategory getSuitableAgeCategory() {
		return this.suitableAgeCategory;
	}

	@Override
	public double calculateCostTour() {
		Transport transportCost = getTransport();
		Nutrition nutritionCost = getNutrition();
		double costTour = transportCost.getCost()
				+ (nutritionCost.getCostPerDay() + this.studySubject.getCostPerDay()) * getDaysNumber();
		return costTour;
	}

	@Override
	public String toString() {
		StringBuilder stringWithDataToOutput = new StringBuilder();
		stringWithDataToOutput.append(super.toString()).append("\n")
				.append(Resourcer.getString("message.study.subject")).append(this.studySubject).append("\n")
				.append(Resourcer.getString("message.suitable.age.category")).append(this.suitableAgeCategory)
				.append("\n").append(Resourcer.getString("message.cost.tour")).append(calculateCostTour());
		return stringWithDataToOutput.toString();
	}
}
