package com.gmail.perhapsitisyeazz.yeasybasics.commands;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Message;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class InvSeeCmd implements CommandExecutor {

	private final Utils utils = new Utils();
	private final Message message = new Message();

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(args.length > 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null || player == target) return true;
				player.openInventory(target.getInventory());
				player.sendActionBar(message.logo + utils.getColMsg("&2You have opened &b" + target.getName() + "&2's inventory"));
			}
		}
		return true;
	}
}
