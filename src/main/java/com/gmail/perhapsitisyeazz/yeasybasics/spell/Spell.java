package com.gmail.perhapsitisyeazz.yeasybasics.spell;

public class Spell {
	private String name;
	private final SpellType type;
	private int spellMaxLevel;
	private int manaCost;

	Spell(SpellType type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public SpellType getType() {
		return this.type;
	}

	public void setSpellMaxLevel(int spellMaxLevel) {
		this.spellMaxLevel = spellMaxLevel;
	}

	public int getSpellMaxLevel() {
		return this.spellMaxLevel;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public int getManaCost() {
		return this.manaCost;
	}
}
