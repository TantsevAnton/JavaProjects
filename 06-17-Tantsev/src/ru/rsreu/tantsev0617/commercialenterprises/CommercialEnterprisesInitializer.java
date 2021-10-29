package ru.rsreu.tantsev0617.commercialenterprises;

public class CommercialEnterprisesInitializer {

	private CommercialEnterprisesInitializer() {

	}

	public static CommercialEnterprise[] initializeCommercialEnterprises() {
		CommercialEnterprise[] commercialEnterprises = {
				new CommercialEnterprise("URALCHEM", "Moscow", OwnershipForm.JSC),
				new CommercialEnterprise("GAZPROM", "Moscow", OwnershipForm.PJSC),
				new CommercialEnterprise("Agrotekhmash", "Ryazan", OwnershipForm.LLC),
				new CommercialEnterprise("Lenta", "St. Petersburg", OwnershipForm.PJSC) };
		return commercialEnterprises;
	}
}
