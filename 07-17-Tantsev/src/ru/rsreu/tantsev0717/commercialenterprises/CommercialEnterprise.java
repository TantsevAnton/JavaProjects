package ru.rsreu.tantsev0717.commercialenterprises;

import java.io.Serializable;

import ru.rsreu.tantsev0717.utils.Resourcer;

public class CommercialEnterprise implements Serializable, Comparable<CommercialEnterprise> {

	private static final long serialVersionUID = 2300874993567407820L;

	private String name;
	private String inhabitedLocality;
	private OwnershipForm ownershipForm;

	public CommercialEnterprise(String name, String inhabitedLocality, OwnershipForm ownershipForm) {
		this.name = name;
		this.inhabitedLocality = inhabitedLocality;
		this.ownershipForm = ownershipForm;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInhabitedLocality() {
		return this.inhabitedLocality;
	}

	public void setInhabitedLocality(String inhabitedLocality) {
		this.inhabitedLocality = inhabitedLocality;
	}

	public OwnershipForm getOwnershipForm() {
		return this.ownershipForm;
	}

	public void setOwnershipForm(OwnershipForm ownershipForm) {
		this.ownershipForm = ownershipForm;
	}

	@Override
	public String toString() {
		StringBuilder stringWithData = new StringBuilder();
		stringWithData.append(this.name).append(Resourcer.getString("message.separator")).append(this.inhabitedLocality)
				.append(Resourcer.getString("message.separator")).append(this.ownershipForm).append("\n");
		return stringWithData.toString();
	}

	@Override
	public int compareTo(CommercialEnterprise commercialEnterprise) {
		return name.compareTo(commercialEnterprise.getName());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CommercialEnterprise other = (CommercialEnterprise) obj;
		if (inhabitedLocality == null) {
			if (other.inhabitedLocality != null) {
				return false;
			}
		} else if (!inhabitedLocality.equals(other.inhabitedLocality)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (ownershipForm != other.ownershipForm) {
			return false;
		}
		return true;
	}
}
