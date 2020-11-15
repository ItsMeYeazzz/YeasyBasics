package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import de.tr7zw.nbtapi.NBTItem;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Spell {
	private final SpellType type;
	private String skinValue;
	private Rarity rarity = Rarity.COMMON;
	private int level = 1;
	private int maxLevel = 3;
	private int manaCost;

	public final static int NBT_TAG = 5;
	public final static String TYPE_KEY = "type", RARITY_KEY = "rarity", LEVEL_KEY = "level", MAX_LEVEL_KEY = "max-level", MANA_COST_KEY = "mana-cost";
	public final static String spellLogo = Util.getColMsg("&8[&3Spell&8] ");

	public Spell(@NotNull SpellType type) {
		this.type = type;
	}

	public Spell(@NotNull SpellType type, int level) {
		this.type = type;
		this.level = level;
	}

	public Spell(@NotNull ItemStack item) {
		Validate.isTrue(SpellManager.isSpell(item), "ItemStack must be a spell");
		NBTItem nbtItem = new NBTItem(item);
		String type = nbtItem.getString(Spell.TYPE_KEY), rarity = nbtItem.getString(Spell.RARITY_KEY);
		int level = nbtItem.getInteger(Spell.LEVEL_KEY), maxLevel = nbtItem.getInteger(Spell.MAX_LEVEL_KEY), manaCost = nbtItem.getInteger(Spell.MANA_COST_KEY);
		this.type = SpellType.valueOf(type);
		this.skinValue = SpellManager.getSkinValue(nbtItem);
		this.rarity = Rarity.valueOf(rarity);
		this.level = level;
		this.maxLevel = maxLevel;
		this.manaCost = manaCost;
	}

	@NotNull
	public SpellType getType() {
		return this.type;
	}

	@NotNull
	public String getName() {
		return this.type.color+" "+this.type.toString()+" &3[&bLvl. "+this.level+"&3]";
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
		return this.rarity;
	}

	public void setLevel(int level) {
		if(level < 0) return;
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getMaxLevel() {
		return (Math.max(this.maxLevel, 3));
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public int getManaCost() {
		return (Math.max(this.manaCost, 0));
	}
}
