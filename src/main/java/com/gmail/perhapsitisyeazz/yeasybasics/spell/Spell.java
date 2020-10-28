package com.gmail.perhapsitisyeazz.yeasybasics.spell;

@SuppressWarnings("unused")
public enum Spell {
	BUNNY_HOPE("Bunny Hop", 3, 65),
	BUBBLE("Bubulle" ,3, 30),
	GIFT_OF_RAGE("Don de rage", 3, 30),
	ROYAL_DINNER("Dîner Royal", 3, 30),
	VITAL_DISCHARGE("Décharge vitale", 3, 30),
	SOLAR_GLOW("Éclat solaire", 3, 30),
	FLASH("Flash", 3, 30),
	NOCTURNAL_HYMN("Hymne Nocturne", 3, 30),
	PYRO_WAVE("Vague Pyro", 3, 30),
	LEVITATION("Lévitation", 3, 30),
	YUM_YUM("Miam Miam", 3, 30),
	NINJA("Ninja", 3 ,30),
	SHOCK_WAVE("Onde de choc", 3, 30),
	IRON_SKIN("Peau de fer", 3, 30),
	DEADLY_POISON("Poison mortel", 3, 30),
	METALLIC_BURST("Salve métallique", 3, 30),
	REVITALIZATION("Revitalisation", 3, 30),
	RAGE_OF_THE_WARRIOR("Rage du guerrier", 3, 30);

	private final String name;
	private final int spellMaxLevel;
	private final int manaCost;

	Spell(String name, Integer spellMaxLevel, Integer manaCost) {
		this.name = name;
		this.spellMaxLevel = spellMaxLevel;
		this.manaCost = manaCost;
	}

	private String getName() {
		return this.name;
	}

	private int getSpellLevel() {
		return this.spellMaxLevel;
	}

	private int getManaCost() {
		return this.manaCost;
	}
}
