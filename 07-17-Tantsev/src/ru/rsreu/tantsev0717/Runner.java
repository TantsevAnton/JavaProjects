package ru.rsreu.tantsev0717;

import ru.rsreu.tantsev0717.utils.ListHandler;
import ru.rsreu.tantsev0717.utils.InhabitedLocalitiesAndOwnershipFormsComparator;
import ru.rsreu.tantsev0717.utils.Resourcer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import ru.rsreu.tantsev0717.commercialenterprises.CommercialEnterprise;
import ru.rsreu.tantsev0717.commercialenterprises.CommercialEnterprisesInitializer;
import ru.rsreu.tantsev0717.commercialenterprises.OwnershipForm;

public class Runner {

	private Runner() {

	}

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();

		CommercialEnterprise[] commercialEnterprisesArray = CommercialEnterprisesInitializer
				.initializeCommercialEnterprises();
		List<CommercialEnterprise> commercialEnterprisesList = new ArrayList<CommercialEnterprise>(
				Arrays.asList(commercialEnterprisesArray));
		result.append(Resourcer.getString("message.commercial.enterprises.list")).append("\n")
				.append(ListHandler.getCommercialEnterprises(commercialEnterprisesList)).append("\n");

		Collections.sort(commercialEnterprisesList);
		result.append(Resourcer.getString("message.commercial.enterprises.list.sorted.by.default")).append("\n")
				.append(ListHandler.getCommercialEnterprises(commercialEnterprisesList)).append("\n");

		Collections.sort(commercialEnterprisesList, new InhabitedLocalitiesAndOwnershipFormsComparator());
		result.append(
				Resourcer.getString("message.commercial.enterprises.list.sorted.simultaneously.by.two.parameters"))
				.append("\n").append(ListHandler.getCommercialEnterprises(commercialEnterprisesList)).append("\n");

		result.append(Resourcer.getString("message.inhabited.localities.without.repeats")).append("\n")
				.append(ListHandler.getInhabitedLocalitiesWithoutRepeating(commercialEnterprisesList)).append("\n");

		commercialEnterprisesList = ListHandler
				.removeCommercialEnterprisesWithSpecifiedOwnershipForm(commercialEnterprisesList, OwnershipForm.JSC);
		result.append(Resourcer.getString("message.commercial.enterprises.table.after.elements.removal")).append("\n")
				.append(ListHandler.getCommercialEnterprises(commercialEnterprisesList)).append("\n");

		Map<String, CommercialEnterprise> commercialEnterprisesMap = ListHandler
				.createCommercialEnterprisesMap(commercialEnterprisesList);
		result.append(ListHandler.findCommercialEnterprise(commercialEnterprisesMap,
				Resourcer.getString("commercial.enterprise.name.presenting.in.list"))).append("\n");
		result.append(ListHandler.findCommercialEnterprise(commercialEnterprisesMap,
				Resourcer.getString("commercial.enterprise.name.not.presenting.in.list"))).append("\n");

		System.out.println(result);
	}

}
