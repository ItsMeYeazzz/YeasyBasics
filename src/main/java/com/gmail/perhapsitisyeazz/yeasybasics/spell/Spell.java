package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import org.jetbrains.annotations.NotNull;

public class Spell {
	private String name;
	private final SpellType type;
	private int level;
	private int maxLevel;
	private int manaCost;

	public Spell(@NotNull SpellType type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@NotNull
	public SpellType getType() {
		return this.type;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public int getSpellMaxLevel() {
		return this.maxLevel;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public int getManaCost() {
		return this.manaCost;
	}
}
