package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import de.tr7zw.nbtapi.NBTItem;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Spell {
	private final SpellType type;
	private String name;
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
		Spell spell = new Spell(SpellType.valueOf(type), level);
		spell.setName(item.getItemMeta().getDisplayName());
		spell.setRarity(Rarity.valueOf(rarity));
		spell.setMaxLevel(maxLevel);
		spell.setManaCost(manaCost);
		this.type = spell.getType();
		this.name = spell.getName();
		this.skinValue = spell.getSkinValue();
		this.rarity = spell.getRarity();
		this.level = spell.getLevel();
		this.maxLevel = spell.getMaxLevel();
		this.manaCost = spell.getManaCost();
	}

	@NotNull
	public SpellType getType() {
		return this.type;
	}

	public void setName(String name) {
		this.name = name + " &3[&bLvl. "+this.level+"&3]";
	}

	@NotNull
	public String getName() {
		return (this.name != null ? this.name : this.type.toString() + " | " + this.level);
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
