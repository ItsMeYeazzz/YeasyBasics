package com.gmail.perhapsitisyeazz.yeasybasics.listeners;

import com.gmail.perhapsitisyeazz.yeasybasics.YeasyBasics;
import com.gmail.perhapsitisyeazz.yeasybasics.events.SpellCastEvent;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellManager;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellType;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class CastSpellEvent implements Listener {

	public YeasyBasics main;
	public CastSpellEvent(YeasyBasics main) {
		this.main = main;
	}

	private final SpellManager SM = new SpellManager();

	@EventHandler
	private void onCastSpell(SpellCastEvent event) {
		Player player = event.getPlayer();
		Spell spell = event.getSpell();
		SpellType type = spell.getType();
		int level = spell.getLevel();
		Location location = player.getLocation();
		if (type == SpellType.BUNNY_HOP) {
			player.sendActionBar(SM.sendSpellMessage(spell));
			int duration = level * 5;
			int amplifier = level - 1;
			PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, duration, amplifier, false, false, false);
			player.addPotionEffect(effect);
			player.playSound(location, Sound.ENTITY_RABBIT_HURT, 1, 1);
		} else if(type == SpellType.BUBBLE) {

		} else if(type == SpellType.GIFT_OF_RAGE) {
			player.sendActionBar(SM.sendSpellMessage(spell));
			int duration = level * 4;
			int amplifier = level - 1;
			PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amplifier, false, false, false);
			player.addPotionEffect(effect);
			player.playSound(location, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
		} else if(type == SpellType.ROYAL_DINNER) {
			player.sendActionBar(SM.sendSpellMessage(spell));
			for(Player loopPlayer : getNearbyPlayers(player, level*6)) {
				loopPlayer.sendActionBar(Util.getColMsg("&2You have been feed by &b" + player.getName()));
				loopPlayer.setFoodLevel(20);
				if(level == spell.getMaxLevel()) loopPlayer.setSaturation(20);
			}
		}
	}

	public ArrayList<Entity> getNearbyMonsters(Player player, double range){
		ArrayList<Entity> nearby = new ArrayList<>();
		for (Entity e : player.getNearbyEntities(range, range, range)){
			if (e instanceof Monster){
				nearby.add(e);
			}
		}
		return nearby;
	}

	public ArrayList<Player> getNearbyPlayers(Player player, double range){
		ArrayList<Player> nearby = new ArrayList<>();
		for (Entity e : player.getNearbyEntities(range, range, range)){
			if (e instanceof Player){
				nearby.add((Player) e);
			}
		}
		return nearby;
	}
}
