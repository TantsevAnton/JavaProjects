package ru.rsreu.tantsev0517.travelvouchers;

import ru.rsreu.tantsev0517.Resourcer;

public class TravelAgency {

	private String name;
	private String address;
	private String phone;

	public TravelAgency(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPhone() {
		return this.phone;
	}

	@Override
	public String toString() {
		StringBuilder stringWithDataToOutput = new StringBuilder();
		stringWithDataToOutput.append(Resourcer.getString("message.travel.agency.name")).append(this.name).append("\n")
				.append(Resourcer.getString("message.travel.agency.address")).append(this.address).append("\n")
				.append(Resourcer.getString("message.travel.agency.phone")).append(this.phone);
		return stringWithDataToOutput.toString();
	}
}
