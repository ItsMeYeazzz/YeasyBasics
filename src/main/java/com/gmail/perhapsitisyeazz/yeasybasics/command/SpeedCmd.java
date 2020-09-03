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
				try {
					float f = Float.parseFloat(args[0].replace(',', '.'));
					if (f >= 0f && f <= 10f) {
						f = f / 10;
						String str;
						float speed;
						if (player.isFlying()) {
							player.setFlySpeed(f);
							str = " fly ";
							speed = player.getFlySpeed();
						} else {
							player.setWalkSpeed(f);
							str = " walk ";
							speed = player.getWalkSpeed();
						}
						if(f != speed) {
							player.sendActionBar(logo + ChatColor.GREEN + "Your" + ChatColor.BLUE + str + ChatColor.GREEN + "speed has been set to " + ChatColor.BLUE + args[0] + ChatColor.GREEN + ".");
						} else {
							player.sendActionBar(logo + ChatColor.DARK_GREEN + "Your" + ChatColor.BLUE + str + ChatColor.GREEN + "speed is already " + ChatColor.BLUE + args[0] + ChatColor.GREEN + ".");
						}
					} else {
						player.sendActionBar(logo + ChatColor.RED + "Error : Invalid number : '" + ChatColor.DARK_PURPLE + args[0] + ChatColor.RED +"', it must be between 0 and 10.");
					}
				} catch (NumberFormatException e) {
					player.sendActionBar(logo + ChatColor.RED + "Error : Invalid number : '" + ChatColor.DARK_PURPLE + args[0] + "'.");
				}
			} else {
				player.sendActionBar(logo + ChatColor.RED + "Error : Missing number argument.");
			}
		} else {
			sender.sendMessage(logo + ChatColor.RED + "Error : Player-only command.");
		}
		return true;
	}
}
