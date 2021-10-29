package ru.rsreu.tantsev0617.utils;

import ru.rsreu.tantsev0617.commercialenterprises.CommercialEnterprise;

public class TableCreater {

	private static final int TABLE_HORIZONTAL_BORDER_ELEMENTS_COUNT = 89;

	private TableCreater() {

	}

	public static void createTable(CommercialEnterprise[] dataArray) {
		createHorizontalBorder();
		System.out.printf("%1$s%2$-25s%1$s%3$-25s%1$s%4$-35s%1$s",
				Resourcer.getString("table.vertical.boreder.element"), Resourcer.getString("table.header.name"),
				Resourcer.getString("table.header.inhabited.locality"),
				Resourcer.getString("table.header.ownership.form"));
		System.out.printf("%n");
		createHorizontalBorder();

		for (CommercialEnterprise commercialEnterprise : dataArray) {
			System.out.printf("%1$s%2$-25s%1$s%3$-25s%1$s%4$-35s%1$s",
					Resourcer.getString("table.vertical.boreder.element"), commercialEnterprise.getName(),
					commercialEnterprise.getInhabitedLocality(), commercialEnterprise.getOwnershipForm());
			System.out.printf("%n");
			createHorizontalBorder();
		}
	}

	private static void createHorizontalBorder() {
		for (int i = 0; i < TABLE_HORIZONTAL_BORDER_ELEMENTS_COUNT; i++) {
			System.out.printf("%s", Resourcer.getString("table.horizontal.border.element"));
		}
		System.out.printf("%n");
	}
}
