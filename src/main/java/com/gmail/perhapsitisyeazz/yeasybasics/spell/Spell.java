package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import org.jetbrains.annotations.NotNull;

public class Spell {
	private String name;
	private final SpellType type;
	private String skinValue;
	private Rarity rarity;
	private int level;
	private int maxLevel;
	private int manaCost;

	public final static int NBT_TAG = 5;
	public final static String TYPE_KEY = "type", RARITY_KEY = "rarity", LEVEL_KEY = "level", MAX_LEVEL_KEY = "max-level", MANA_COST_KEY = "mana-cost";

	public Spell(@NotNull SpellType type) {
		this.type = type;
	}

	public Spell(@NotNull SpellType type, int level) {
		this.type = type;
		this.level = level;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	@NotNull
	public String getName() {
		return (this.name != null ? this.name : this.type.toString());
	}

	@NotNull
	public SpellType getType() {
		return this.type;
	}

	public void setSkinValue(String id) {
		this.skinValue = id;
	}

	@NotNull
	public String getSkinValue() {
		return this.skinValue;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	@NotNull
	public Rarity getRarity() {
		return (this.rarity != null ? this.rarity : Rarity.COMMON);
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return (this.level > 0 ? this.level : 1);
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getMaxLevel() {
		return (Math.max(this.maxLevel, 0));
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public int getManaCost() {
		return (Math.max(this.manaCost, 0));
	}
}
