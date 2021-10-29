package ru.rsreu.tantsev0717.commercialenterprises;

public class CommercialEnterprisesInitializer {

	private CommercialEnterprisesInitializer() {

	}

	public static CommercialEnterprise[] initializeCommercialEnterprises() {
		CommercialEnterprise[] commercialEnterprises = {
				new CommercialEnterprise("GAZPROM", "Moscow", OwnershipForm.PJSC),
				new CommercialEnterprise("Agrotekhmash", "Ryazan", OwnershipForm.LLC),
				new CommercialEnterprise("URALCHEM", "Moscow", OwnershipForm.JSC),
				new CommercialEnterprise("Lenta", "St. Petersburg", OwnershipForm.PJSC) };
		return commercialEnterprises;
	}
}
