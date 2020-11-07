package com.gmail.perhapsitisyeazz.yeasybasics.commands;

import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SpellCommand implements CommandExecutor {

	private final SpellManager SM = new SpellManager();

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				ItemStack item = player.getInventory().getItemInMainHand();
				if(item.getType() == Material.AIR)
					return true;
				SpellManager.setSpellToItem(item, SM.solarGlow());
			}
		}
		return true;
	}
}
