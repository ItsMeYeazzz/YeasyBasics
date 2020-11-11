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
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class CastSpellEvent implements Listener {

	public YeasyBasics main;
	public CastSpellEvent(YeasyBasics main) {
		this.main = main;
	}

	private final SpellManager SM = new SpellManager();

	@EventHandler
	private void onCastSpell(SpellCastEvent event) {
		YeasyBasics instance = YeasyBasics.getInstance();
		Player player = event.getPlayer();
		Spell spell = event.getSpell();
		SpellType type = spell.getType();
		int level = spell.getLevel();
		Location location = player.getLocation();
		player.sendActionBar(SM.sendSpellMessage(spell));
		if (type == SpellType.BUNNY_HOP) {
			int duration = level * 5 * 20;
			int amplifier = level - 1;
			PotionEffect effect = new PotionEffect(PotionEffectType.JUMP, duration, amplifier, false, false, false);
			player.addPotionEffect(effect);
			player.playSound(location, Sound.ENTITY_RABBIT_HURT, 1.0F, 1.0F);
		} else if(type == SpellType.BUBBLE) {
			player.playSound(location, Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, 1.0F, 1.0F);
		} else if(type == SpellType.GIFT_OF_RAGE) {
			int duration = level * 4 * 20;
			int amplifier = level - 1;
			PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, amplifier, false, false, false);
			player.addPotionEffect(effect);
			player.playSound(location, Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 1.0F);
		} else if(type == SpellType.ROYAL_DINNER) {
			for(Player loopPlayer : getNearbyPlayers(player, 8)) {
				loopPlayer.sendActionBar(Util.getColMsg("&2You have been feed by &b" + player.getName()));
				int food = loopPlayer.getFoodLevel() + 5 * (level + 1);
				loopPlayer.setFoodLevel(food);
				if(level == spell.getMaxLevel())
					loopPlayer.setSaturation(food);
				for(int i = 0; i < 3; i++) {
					BukkitRunnable runnable;
					runnable = new BukkitRunnable() {
						@Override
						public void run() {
							player.playSound(location, Sound.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
						}
					};
					runnable.runTaskLater(instance, 5*i);
				}
			}
		} else if(type == SpellType.VITAL_DISCHARGE) {
			ArrayList<Player> nearbyPlayers = getNearbyPlayers(player, 8.0D, 12);
			int size = nearbyPlayers.size();
			for(Player loopPlayer : nearbyPlayers) {
				loopPlayer.sendActionBar(Util.getColMsg("&2You have been heal by &b" + player.getName()));
				double health = loopPlayer.getHealth() + 5 * level * (1 - (size > 2 ? (size-2)/10.0F : 0));
				loopPlayer.setHealth(health);
			}
			player.playSound(location, Sound.ENTITY_SPLASH_POTION_BREAK, 1.0F, 1.0F);
		} else if(type == SpellType.SOLAR_GLOW) {
			ArrayList<Entity> nearbyMonsters = getNearbyMonsters(player, 15.0D, 15);
			if(nearbyMonsters.isEmpty()) {
				player.sendActionBar(Spell.spellLogo + Util.getColMsg("&cError : There are no monster near."));
				return;
			}
			player.playSound(location, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 3.0F, 1.0F);
			for(int i = 0; i < 2; i++) {
				BukkitRunnable runnable;
				runnable = new BukkitRunnable() {
					@Override
					public void run() {
						for (Entity loopMonster : nearbyMonsters) {
							player.getWorld().strikeLightningEffect(loopMonster.getLocation());
							player.damage(5.0D, loopMonster);
						}
					}
				};
				runnable.runTaskLater(instance, 30 + i*5);
			}
		}
	}

	public ArrayList<Entity> getNearbyMonsters(Player player, double range) {
		ArrayList<Entity> nearby = new ArrayList<>();
		for(Entity e : player.getNearbyEntities(range, range, range)){
			if(e instanceof Monster){
				nearby.add(e);
			}
		}
		return nearby;
	}

	public ArrayList<Entity> getNearbyMonsters(Player player, double range, int limit) {
		ArrayList<Entity> nearby = new ArrayList<>();
		for(Entity e : player.getNearbyEntities(range, range, range)){
			if(e instanceof Monster){
				if(nearby.size() < limit)
					nearby.add(e);
				else
					break;
			}
		}
		return nearby;
	}

	public ArrayList<Player> getNearbyPlayers(Player player, double range) {
		ArrayList<Player> nearby = new ArrayList<>();
		for(Entity e : player.getNearbyEntities(range, range, range)) {
			if(e instanceof Player)
				nearby.add((Player) e);
		}
		return nearby;
	}

	public ArrayList<Player> getNearbyPlayers(Player player, double range, int limit) {
		ArrayList<Player> nearby = new ArrayList<>();
		for(Entity e : player.getNearbyEntities(range, range, range)){
			if(e instanceof Player){
				if(nearby.size() < limit)
					nearby.add((Player) e);
				else
					break;
			}
		}
		return nearby;
	}
}
