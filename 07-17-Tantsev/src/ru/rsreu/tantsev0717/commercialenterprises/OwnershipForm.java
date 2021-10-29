package ru.rsreu.tantsev0717.commercialenterprises;

public enum OwnershipForm {
	JSC {
		@Override
		public String toString() {
			return "Joint stock company (JSC)";
		}
	},
	PJSC {
		@Override
		public String toString() {
			return "Public JSC (PJSC)";
		}
	},
	LLC {
		@Override
		public String toString() {
			return "Limited liability company (LLC)";
		}
	};
}
