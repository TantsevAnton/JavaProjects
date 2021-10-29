package ru.rsreu.tantsev0517.travelvouchers;

public enum SuitableAgeCategory {
	SCHOOLCHILD {
		@Override
		public String toString() {
			return "Shoolchild";
		}
	},
	STUDENT {
		@Override
		public String toString() {
			return "Student";
		}
	},
	YOUNG_SPECIALIST {
		@Override
		public String toString() {
			return "Young specialist";
		}
	};
}
