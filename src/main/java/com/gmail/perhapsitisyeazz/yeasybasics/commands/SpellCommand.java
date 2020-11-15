package com.gmail.perhapsitisyeazz.yeasybasics.commands;

import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellManager;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellType;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SpellCommand implements CommandExecutor, TabCompleter {

	private final SpellManager SM = new SpellManager();

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length > 0) {
				ItemStack item = player.getInventory().getItemInMainHand();
				if(args[0].equalsIgnoreCase("nbt")) {
					if(!SpellManager.isSpell(item)) return true;
					NBTItem nbtItem = new NBTItem(item);
					player.sendMessage(nbtItem.toString());
				} else if(args[0].equalsIgnoreCase("menu"))
					player.openInventory(SM.spellMenu());
				else if(args[0].equalsIgnoreCase("level")) {
					if(!SpellManager.isSpell(item)) return true;
					Spell spell = new Spell(item);
					String[] tests = spell.getName().split("([a-zA-Z]+.*)\\[");
					for(String s : tests) {
						player.sendMessage(s);
					}
				} else if(args[0].equalsIgnoreCase("setLevel")) {
					if(!SpellManager.isSpell(item)) return true;
					if(args.length > 1) {
						try {
							int level = Integer.parseInt(args[1]);
							SpellManager.setLevelToItem(item, level);
						} catch (NumberFormatException ignored) {
							player.sendMessage(Spell.spellLogo + Util.getColMsg("&cError : You must enter an integer at argument 2."));
						}
					} else
						player.sendMessage(Spell.spellLogo + Util.getColMsg("&cError : You must enter an integer at argument 2."));
				} else {
					Spell parsedSpell = parseSpell(args[0]);
					ItemStack newItem = SpellManager.getSpellItem(parsedSpell);
					if(item.getType() == Material.AIR)
						player.getInventory().setItemInMainHand(newItem);
					else if(SpellManager.isSpell(item)) {
						Spell spell = new Spell(item);
						if(spell.getType() == parsedSpell.getType())
							player.getInventory().setItemInMainHand(newItem);
					} else
						player.getInventory().addItem(newItem);
				}
			} else
				player.sendActionBar(Spell.spellLogo + Util.getColMsg("&cError : You must enter an argument."));
		}
		return true;
	}

	@Override
	public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if(args.length == 1) {
			ArrayList<String> arrayList = new ArrayList<>();
			for (SpellType type : SpellType.values()) {
				arrayList.add(type.name());
			}
			return arrayList;
		} else return null;
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
