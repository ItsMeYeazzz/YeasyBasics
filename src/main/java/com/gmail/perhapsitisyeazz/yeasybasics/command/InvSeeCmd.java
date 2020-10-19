package com.gmail.perhapsitisyeazz.yeasybasics.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class InvSeeCmd implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(args.length > 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null) return true;
				if(player == target) return true;
				player.openInventory(target.getInventory());
				player.sendActionBar("yes");
			}
		}
		return true;
	}
}
