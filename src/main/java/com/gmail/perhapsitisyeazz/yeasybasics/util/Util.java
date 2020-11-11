package com.gmail.perhapsitisyeazz.yeasybasics.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Util {

	public static void sendMessage(CommandSender sender, String message) {
		if(sender instanceof Player) {
			((Player) sender).sendActionBar(message);
		} else {
			sender.sendMessage(message);
		}
	}

	public static boolean match(String arg, String... str) {
		for (String m : str) {
			if (m.equalsIgnoreCase(arg))
				return true;
		}
		return false;
	}

	public static String getColMsg(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static ItemStack createGuiItem(ItemStack item, String name, final String... lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return item;
	}
}
