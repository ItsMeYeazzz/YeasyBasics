package com.gmail.perhapsitisyeazz.yeasybasics.command;

import com.gmail.perhapsitisyeazz.yeasybasics.manager.Message;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class TimeCommand implements CommandExecutor {

	private final Message message = new Message();
	private final Utils utils = new Utils();

	private final List<String> timeNames = Arrays.asList("sunrise", "day", "noon", "sunset", "night", "midnight");

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		String logo = message.logo;
		if(args.length > 0) {
			long time;
			switch (args[0]) {
				case "sunrise":
					time=23000;
				case "day":
					time=1000;
				case "noon":
					time=6000;
				case "sunset":
					time=12000;
				case "night":
					time=13000;
				case "midnight":
					time=18000;
				default:
					try {
						long l = Long.parseLong(args[0]);
						if(l >= 0L && l <= 60000L) {
							if(sender instanceof Player) {
								Player player = (Player) sender;
								World world = player.getWorld();
								world.setTime(l);
								player.sendActionBar(utils.getColMsg(logo + "&b" + world.getName() + "&a's time has been set to &b" + l + "&a."));
							}
						}
					} catch (NumberFormatException e) {
						if(sender instanceof Player) {
							Player player = (Player) sender;
							player.sendActionBar(utils.getColMsg(logo + "&cError : Invalid number/string : '&5" + args[0] + "&c'."));
						} else {
							sender.sendMessage(utils.getColMsg(logo + "&cError : Invalid number/string : '&5" + args[0] + "&c'."));
						}
					}
			}
		} else {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				long playerWorldTime = player.getWorld().getTime();
				String playerWorldName = player.getWorld().getName();
				player.sendMessage(utils.getColMsg(logo + "&aYour world:\n&3» &a" + playerWorldName + " &7- &f" + playerWorldTime));
			} else {
				ComponentBuilder builder = new ComponentBuilder();
				builder.append(utils.getColMsg(logo + "&aWorlds list:"));
				for(World world : Bukkit.getWorlds()) {
					builder
							.append("\n » ").color(ChatColor.DARK_AQUA)
							.append(world.getName()).color(ChatColor.GREEN)
							.append(" - ").color(ChatColor.GRAY)
							.append(String.valueOf(world.getTime())).color(ChatColor.WHITE);
				}
			}
		}
		return true;
	}
}
