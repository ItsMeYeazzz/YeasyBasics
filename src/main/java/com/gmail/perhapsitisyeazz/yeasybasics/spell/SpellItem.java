package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpellItem extends ItemStack {

	public SpellItem(Spell spell) {
		ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemMeta meta = item.getItemMeta();
		NBTItem nbtItem = new NBTItem(item);
		meta.setDisplayName(spell.getName());
		meta.setCustomModelData(Spell.NBT_TAG);
		item.setItemMeta(meta);
		SpellManager.setSkinNBT(nbtItem, spell.getSkinValue());
		nbtItem.setString(Spell.TYPE_KEY, spell.getType().name());
		nbtItem.setString(Spell.RARITY_KEY, spell.getRarity().name());
		nbtItem.setInteger(Spell.LEVEL_KEY, spell.getLevel());
		nbtItem.setInteger(Spell.MAX_LEVEL_KEY, spell.getMaxLevel());
		nbtItem.setInteger(Spell.MANA_COST_KEY, spell.getManaCost());
		nbtItem.applyNBT(item);
	}
}
