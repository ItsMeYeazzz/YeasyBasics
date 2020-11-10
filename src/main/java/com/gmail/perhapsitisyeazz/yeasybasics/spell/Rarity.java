package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import net.md_5.bungee.api.ChatColor;

public enum Rarity {
	LEGENDARY(ChatColor.GOLD),
	EPIC(ChatColor.DARK_PURPLE),
	RARE(ChatColor.BLUE),
	UNCOMMON(ChatColor.GRAY),
	COMMON(ChatColor.WHITE);

	final ChatColor color;

	Rarity(ChatColor color) {
		this.color = color;
	}
}
