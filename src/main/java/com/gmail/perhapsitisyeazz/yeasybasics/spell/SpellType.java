package com.gmail.perhapsitisyeazz.yeasybasics.spell;

// There is a total of 18 Spells

import net.md_5.bungee.api.ChatColor;

public enum SpellType {
	BUNNY_HOP(ChatColor.GREEN) {
		@Override
		public String toString() {
			return "Bunny Hop";
		}
	},
	BUBBLE(ChatColor.LIGHT_PURPLE) {
		@Override
		public String toString() { return "Bubulle"; }
	},
	GIFT_OF_RAGE(ChatColor.DARK_PURPLE) {
		@Override
		public String toString() { return "Don de rage"; }
	},
	ROYAL_DINNER(ChatColor.GOLD) {
		@Override
		public String toString() {
			return "Dîner Royal";
		}
	},
	VITAL_DISCHARGE(ChatColor.LIGHT_PURPLE) {
		@Override
		public String toString() {
			return "Décharge vitale";
		}
	},
	SOLAR_GLOW(ChatColor.YELLOW) {
		@Override
		public String toString() {
			return "Éclat solaire";
		}
	},
	FLASH(ChatColor.RED) {
		@Override
		public String toString() {
			return "Flash";
		}
	},
	NOCTURNAL_HYMN(ChatColor.DARK_AQUA) {
		@Override
		public String toString() {
			return "Hymne Nocturne";
		}
	},
	PYRO_WAVE(ChatColor.DARK_RED) {
		@Override
		public String toString() {
			return "Vague Pyro";
		}
	},
	LEVITATION(ChatColor.DARK_BLUE) {
		@Override
		public String toString() {
			return "Lévitation";
		}
	},
	YUM_YUM(ChatColor.GOLD) {
		@Override
		public String toString() {
			return "Miam Miam";
		}
	},
	NINJA(ChatColor.BLUE) {
		@Override
		public String toString() {
			return "Ninja";
		}
	},
	SHOCK_WAVE(ChatColor.DARK_RED) {
		@Override
		public String toString() {
			return "Onde de choc";
		}
	},
	IRON_SKIN(ChatColor.GRAY) {
		@Override
		public String toString() {
			return "Peau de fer";
		}
	},
	MORTAL_POISON(ChatColor.DARK_GREEN) {
		@Override
		public String toString() {
			return "Poison mortel";
		}
	},
	METALLIC_BURST(ChatColor.DARK_GRAY) {
		@Override
		public String toString() {
			return "Salve métallique";
		}
	},
	REVITALIZATION(ChatColor.DARK_GREEN) {
		@Override
		public String toString() {
			return "Revitalisation";
		}
	},
	RAGE_OF_THE_WARRIOR(ChatColor.DARK_PURPLE) {
		@Override
		public String toString() {
			return "Rage du guerrier";
		}
	};

	final ChatColor color;

	SpellType(ChatColor color) {
		this.color = color;
	}
}
