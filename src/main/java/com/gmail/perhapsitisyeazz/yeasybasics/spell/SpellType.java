package com.gmail.perhapsitisyeazz.yeasybasics.spell;

// There is a total of 18 Spells

public enum SpellType {
	BUNNY_HOP {
		@Override
		public String toString() {
			return "Bunny Hop";
		}
	},
	BUBBLE {
		@Override
		public String toString() { return "Bubulle"; }
	},
	GIFT_OF_RAGE {
		@Override
		public String toString() { return "Don de rage"; }
	},
	ROYAL_DINNER {
		@Override
		public String toString() {
			return "Dîner Royal";
		}
	},
	VITAL_DISCHARGE {
		@Override
		public String toString() {
			return "Décharge vitale";
		}
	},
	SOLAR_GLOW {
		@Override
		public String toString() {
			return "Éclat solaire";
		}
	},
	FLASH {
		@Override
		public String toString() {
			return "Flash";
		}
	},
	NOCTURNAL_HYMN {
		@Override
		public String toString() {
			return "Hymne Nocturne";
		}
	},
	PYRO_WAVE {
		@Override
		public String toString() {
			return "Vague Pyro";
		}
	},
	LEVITATION {
		@Override
		public String toString() {
			return "Lévitation";
		}
	},
	YUM_YUM {
		@Override
		public String toString() {
			return "Miam Miam";
		}
	},
	NINJA {
		@Override
		public String toString() {
			return "Ninja";
		}
	},
	SHOCK_WAVE {
		@Override
		public String toString() {
			return "Onde de choc";
		}
	},
	IRON_SKIN {
		@Override
		public String toString() {
			return "Peau de fer";
		}
	},
	MORTAL_POISON {
		@Override
		public String toString() {
			return "Poison mortel";
		}
	},
	METALLIC_BURST {
		@Override
		public String toString() {
			return "Salve métallique";
		}
	},
	REVITALIZATION {
		@Override
		public String toString() {
			return "Revitalisation";
		}
	},
	RAGE_OF_THE_WARRIOR {
		@Override
		public String toString() {
			return "Rage du guerrier";
		}
	}
}
