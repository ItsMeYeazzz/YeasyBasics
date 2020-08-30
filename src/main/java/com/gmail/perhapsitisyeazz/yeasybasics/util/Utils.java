package com.gmail.perhapsitisyeazz.yeasybasics.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {

	public void sendMessage(CommandSender sender, String message) {
		if(sender instanceof Player) {
			((Player) sender).sendActionBar(message);
		} else {
			sender.sendMessage(message);
		}
	}
}
