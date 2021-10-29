package ru.rsreu.tantsev0717.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.rsreu.tantsev0717.commercialenterprises.CommercialEnterprise;
import ru.rsreu.tantsev0717.commercialenterprises.OwnershipForm;

public class ListHandler {

	private ListHandler() {

	}

	public static String getCommercialEnterprises(List<CommercialEnterprise> commercialEnterprisesList) {
		CommercialEnterprise[] commercialEnterprisesArray = new CommercialEnterprise[commercialEnterprisesList.size()];
		commercialEnterprisesArray = commercialEnterprisesList.toArray(commercialEnterprisesArray);
		String stringWithDataToOutput = TableCreater.createCommercialEnterprisesTable(commercialEnterprisesArray);
		return stringWithDataToOutput;
	}

	public static String getInhabitedLocalitiesWithoutRepeating(List<CommercialEnterprise> commercialEnterprisesList) {
		Set<String> inhabitedLocalitiesSet = new HashSet<String>();
		for (CommercialEnterprise commercialEnterprise : commercialEnterprisesList) {
			inhabitedLocalitiesSet.add(commercialEnterprise.getInhabitedLocality());
		}
		String stringWithDataToOutput = TableCreater.createInhabitedLocalitiesTable(inhabitedLocalitiesSet);
		return stringWithDataToOutput;
	}

	public static List<CommercialEnterprise> removeCommercialEnterprisesWithSpecifiedOwnershipForm(
			List<CommercialEnterprise> commercialEnterprisesList, OwnershipForm ownershipForm) {
		Iterator<CommercialEnterprise> iterator = commercialEnterprisesList.iterator();
		while (iterator.hasNext()) {
			CommercialEnterprise commercialEnterprise = iterator.next();
			if (commercialEnterprise.getOwnershipForm() == ownershipForm) {
				iterator.remove();
			}
		}
		return commercialEnterprisesList;
	}

	public static String findCommercialEnterprise(Map<String, CommercialEnterprise> commercialEnterprisesMap,
			String commercialEnterpriseName) {
		CommercialEnterprise[] foundCommercialEnterprise = { commercialEnterprisesMap.get(commercialEnterpriseName) };
		StringBuilder stringWithDataToOutput = new StringBuilder();
		if (foundCommercialEnterprise[0] != null) {
			stringWithDataToOutput.append(Resourcer.getString("message.commercial.enterprise.found")).append("\n")
					.append(TableCreater.createCommercialEnterprisesTable(foundCommercialEnterprise));
		} else {
			stringWithDataToOutput.append(Resourcer.getString("message.commercial.enterprise.not.found"));
		}
		return stringWithDataToOutput.toString();
	}

	public static Map<String, CommercialEnterprise> createCommercialEnterprisesMap(
			List<CommercialEnterprise> commercialEnterprisesList) {
		Map<String, CommercialEnterprise> commercialEnterprisesMap = new HashMap<String, CommercialEnterprise>();
		for (CommercialEnterprise commercialEnterprise : commercialEnterprisesList) {
			commercialEnterprisesMap.put(commercialEnterprise.getName(), commercialEnterprise);
		}
		return commercialEnterprisesMap;
	}

}
