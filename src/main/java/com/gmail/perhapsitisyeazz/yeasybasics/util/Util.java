package com.gmail.perhapsitisyeazz.yeasybasics.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Util {

	public void sendMessage(CommandSender sender, String message) {
		if(sender instanceof Player) {
			((Player) sender).sendActionBar(message);
		} else {
			sender.sendMessage(message);
		}
	}

	public boolean match(String arg, String... str) {
		for (String m : str) {
			if (m.equalsIgnoreCase(arg)) return true;
		}
		return false;
	}

	public String getColMsg(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
