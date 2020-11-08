package com.gmail.perhapsitisyeazz.yeasybasics.commands;

import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellManager;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
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
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length > 0) {
				ItemStack item = player.getInventory().getItemInMainHand();
				if (item.getType() == Material.AIR)
					return true;
				SpellManager.setSpellToItem(item, parseSpell(args[0]));
			} else {
				player.sendActionBar(Spell.spellLogo + Util.getColMsg("&cError : You must enter an argument."));
			}
		}
		return true;
	}

	private Spell parseSpell(String spell) {
		if(spell.equalsIgnoreCase("BUNNY_HOP")) return SM.bunnyHop();
		if(spell.equalsIgnoreCase("BUBBLE")) return SM.bubble();
		if(spell.equalsIgnoreCase("GIFT_OF_RAGE")) return SM.giftOfRage();
		if(spell.equalsIgnoreCase("ROYAL_DINNER")) return SM.royalDinner();
		if(spell.equalsIgnoreCase("VITAL_DISCHARGE")) return SM.vitalDischarge();
		if(spell.equalsIgnoreCase("SOLAR_GLOW")) return SM.solarGlow();
		if(spell.equalsIgnoreCase("FLASH")) return SM.flash();
		if(spell.equalsIgnoreCase("NOCTURNAL_HYMN")) return  SM.nocturnalHymn();
		if(spell.equalsIgnoreCase("PYRO_WAVE")) return  SM.pyroWave();
		if(spell.equalsIgnoreCase("LEVITATION")) return SM.levitation();
		if(spell.equalsIgnoreCase("YUM_YUM")) return SM.yumYum();
		if(spell.equalsIgnoreCase("NINJA")) return SM.ninja();
		if(spell.equalsIgnoreCase("SHOCK_WAVE")) return SM.shockWave();
		if(spell.equalsIgnoreCase("IRON_SKIN")) return SM.ironSkin();
		if(spell.equalsIgnoreCase("MORTAL_POISON")) return SM.mortalPoison();
		if(spell.equalsIgnoreCase("METALLIC_BURST")) return SM.metallicBurst();
		if(spell.equalsIgnoreCase("REVITALIZATION")) return SM.revitalization();
		if(spell.equalsIgnoreCase("RAGE_OF_THE_WARRIOR")) return SM.rageOfTheWarrior();
		else return SM.solarGlow();
	}
}
