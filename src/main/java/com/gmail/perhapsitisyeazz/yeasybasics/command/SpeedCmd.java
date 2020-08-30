package com.gmail.perhapsitisyeazz.yeasybasics.command;

import com.gmail.perhapsitisyeazz.yeasybasics.manager.Message;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedCmd implements CommandExecutor {

	private final Message message = new Message();

	private final String logo = TextComponent.toLegacyText(message.logo);

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length > 0) {
				float f = Float.parseFloat(args[0]);
				if(f >= 0 && f <= 10) {
					if(player.isFlying()) {
						player.setFlySpeed(f);
					} else {
						player.setWalkSpeed(f);
					}
				}
			} else {
				player.sendActionBar(logo + ChatColor.RED + "Error : Missing integer argument.");
			}
		} else {
			sender.sendMessage(logo + ChatColor.RED + "Error : Player-only command.");
		}
		return true;
	}
}
