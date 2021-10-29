package ru.rsreu.tantsev0717.utils;

import java.util.Set;

import ru.rsreu.tantsev0717.commercialenterprises.CommercialEnterprise;

public class TableCreater {

	private static final int ELEMENTS_COUNT_IN_COMMERCIAL_ENTERPRISE_TABLE_HORIZONTAL_BORDER = 89;
	private static final int ELEMENTS_COUNT_IN_INHABITED_LOCALITIES_TABLE_HORIZONTAL_BORDER = 27;

	private TableCreater() {

	}

	public static String createInhabitedLocalitiesTable(Set<String> inhabitedLocalitiesSet) {
		StringBuilder stringWithInhabitedLocalitiesTable = new StringBuilder();

		stringWithInhabitedLocalitiesTable
				.append(createHorizontalBorder(ELEMENTS_COUNT_IN_INHABITED_LOCALITIES_TABLE_HORIZONTAL_BORDER))
				.append(String.format("%1$s%2$-25s%1$s", Resourcer.getString("table.vertical.boreder.element"),
						Resourcer.getString("table.header.inhabited.locality")))
				.append(String.format("%n"))
				.append(createHorizontalBorder(ELEMENTS_COUNT_IN_INHABITED_LOCALITIES_TABLE_HORIZONTAL_BORDER));

		for (String inhabitedLocality : inhabitedLocalitiesSet) {
			stringWithInhabitedLocalitiesTable
					.append(String.format("%1$s%2$-25s%1$s", Resourcer.getString("table.vertical.boreder.element"),
							inhabitedLocality))
					.append(String.format("%n"))
					.append(createHorizontalBorder(ELEMENTS_COUNT_IN_INHABITED_LOCALITIES_TABLE_HORIZONTAL_BORDER));
		}

		return stringWithInhabitedLocalitiesTable.toString();
	}

	public static String createCommercialEnterprisesTable(CommercialEnterprise[] dataArray) {
		StringBuilder stringWithCommercialEnterprisesTable = new StringBuilder();

		stringWithCommercialEnterprisesTable
				.append(createHorizontalBorder(ELEMENTS_COUNT_IN_COMMERCIAL_ENTERPRISE_TABLE_HORIZONTAL_BORDER))
				.append(String.format("%1$s%2$-25s%1$s%3$-25s%1$s%4$-35s%1$s",
						Resourcer.getString("table.vertical.boreder.element"), Resourcer.getString("table.header.name"),
						Resourcer.getString("table.header.inhabited.locality"),
						Resourcer.getString("table.header.ownership.form")))
				.append(String.format("%n"))
				.append(createHorizontalBorder(ELEMENTS_COUNT_IN_COMMERCIAL_ENTERPRISE_TABLE_HORIZONTAL_BORDER));

		for (CommercialEnterprise commercialEnterprise : dataArray) {
			stringWithCommercialEnterprisesTable
					.append(String.format("%1$s%2$-25s%1$s%3$-25s%1$s%4$-35s%1$s",
							Resourcer.getString("table.vertical.boreder.element"), commercialEnterprise.getName(),
							commercialEnterprise.getInhabitedLocality(), commercialEnterprise.getOwnershipForm()))
					.append(String.format("%n"))
					.append(createHorizontalBorder(ELEMENTS_COUNT_IN_COMMERCIAL_ENTERPRISE_TABLE_HORIZONTAL_BORDER));
		}

		return stringWithCommercialEnterprisesTable.toString();
	}

	private static String createHorizontalBorder(int tableHorizontalBorderElementsCount) {
		StringBuilder stringWithHorizontalBorder = new StringBuilder();
		for (int i = 0; i < tableHorizontalBorderElementsCount; i++) {
			stringWithHorizontalBorder
					.append(String.format("%s", Resourcer.getString("table.horizontal.border.element")));
		}
		stringWithHorizontalBorder.append(String.format("%n"));
		return stringWithHorizontalBorder.toString();
	}
}
