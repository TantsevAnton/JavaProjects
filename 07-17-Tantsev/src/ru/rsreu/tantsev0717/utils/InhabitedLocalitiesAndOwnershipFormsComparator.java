package ru.rsreu.tantsev0717.utils;

import java.util.Comparator;

import ru.rsreu.tantsev0717.commercialenterprises.CommercialEnterprise;

public class InhabitedLocalitiesAndOwnershipFormsComparator implements Comparator<CommercialEnterprise> {

	@Override
	public int compare(CommercialEnterprise commercialEnterprise1, CommercialEnterprise commercialEnterprise2) {
		int compareResult = commercialEnterprise1.getInhabitedLocality()
				.compareTo(commercialEnterprise2.getInhabitedLocality());
		if (compareResult == 0) {
			compareResult = commercialEnterprise1.getOwnershipForm()
					.compareTo(commercialEnterprise2.getOwnershipForm());
		}
		return compareResult;
	}
}
