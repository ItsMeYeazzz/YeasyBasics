package com.gmail.perhapsitisyeazz.yeasybasics.listeners;

import com.gmail.perhapsitisyeazz.yeasybasics.YeasyBasics;
import com.gmail.perhapsitisyeazz.yeasybasics.events.SpellCastEvent;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellManager;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellType;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;
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

	private final String levMetaData = SpellType.LEVITATION.name();

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
			nearbyPlayers.add(player);
			int size = nearbyPlayers.size();
			for(Player loopPlayer : nearbyPlayers) {
				loopPlayer.sendActionBar(Util.getColMsg("&2You have been heal by &b" + player.getName()));
				double health = loopPlayer.getHealth() + 5 * level * (1 - (size > 2 ? (size-2)/10.0F : 0));
				loopPlayer.setHealth(health);
			}
			player.playSound(location, Sound.ENTITY_SPLASH_POTION_BREAK, 1.0F, 1.0F);
		} else if(type == SpellType.SOLAR_GLOW) {
			ArrayList<Monster> nearbyMonsters = getNearbyMonsters(player, 15.0D, 15);
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
						for (Monster loopMonster : nearbyMonsters) {
							player.getWorld().strikeLightningEffect(loopMonster.getLocation());
							loopMonster.damage(13.0D*spell.getLevel(), player);
						}
					}
				};
				runnable.runTaskLater(instance, 30 + i*5);
			}
		} else if(type == SpellType.FLASH) {
			int duration = level * 5 * 20;
			int amplifier = level - 1;
			PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, duration, amplifier, false, false, false);
			player.addPotionEffect(effect);
			player.playSound(location, Sound.ITEM_FIRECHARGE_USE, 1.0F, 1.0F);
		} else if(type == SpellType.NOCTURNAL_HYMN) {
			int duration = level^2 * 60 * 20;
			int amplifier = level - 1;
			PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, duration, amplifier, false, false, false);
			player.addPotionEffect(effect);
			player.playSound(location, Sound.ENTITY_PARROT_AMBIENT, 1.0F, 1.0F);
		} else if(type == SpellType.LEVITATION) {
			ArrayList<Monster> nearbyMonsters = getNearbyMonsters(player, 5.0D);
			if(nearbyMonsters.isEmpty()) {
				player.sendActionBar(Spell.spellLogo + Util.getColMsg("&cError : There are no monster near."));
				return;
			}
			player.playSound(location, Sound.ITEM_TRIDENT_RETURN, 1.0F, 1.0F);
			for (Monster monster : nearbyMonsters) {
				monster.setVelocity(BlockFace.UP.getDirection().multiply(1.7));
				monster.setMetadata(levMetaData, new FixedMetadataValue(instance, true));
			}
			for(int i = 0; i < 4; i++) {
				int finalI = i;
				int delay = i == 0 ? 10 : (i == 1 ? 36 : (i == 2 ? 40 : 50)); // wait 10, 26, 4 and 10 ticks
				BukkitRunnable runnable;
				runnable = new BukkitRunnable() {
					@Override
					public void run() {
						for (Monster monster : nearbyMonsters)
							levitation(instance, monster, finalI, player);
					}
				};
				runnable.runTaskLater(instance, delay);
			}
		}
	}

	private void levitation(YeasyBasics instance, Monster m, int i, Player p) {
		if(i == 0) {
			PotionEffect effect = new PotionEffect(PotionEffectType.LEVITATION, 26, 0, false, false, false);
			m.addPotionEffect(effect);
		} else if(i == 1)
			m.setVelocity(BlockFace.DOWN.getDirection().multiply(8));
		else if(i == 2) {
			p.playSound(p.getLocation(), Sound.ITEM_TOTEM_USE, 0.5F, 1.0F);
			m.damage(30, p);
		} else if(m.hasMetadata(levMetaData))
			m.removeMetadata(levMetaData, instance);
	}

	public ArrayList<Monster> getNearbyMonsters(Player player, double range) {
		ArrayList<Monster> nearby = new ArrayList<>();
		for(Entity e : player.getNearbyEntities(range, range, range)){
			if(e instanceof Monster)
				nearby.add((Monster) e);
		}
		return nearby;
	}

	public ArrayList<Monster> getNearbyMonsters(Player player, double range, int limit) {
		ArrayList<Monster> nearby = new ArrayList<>();
		for(Entity e : player.getNearbyEntities(range, range, range)){
			if(e instanceof Monster){
				if(nearby.size() < limit)
					nearby.add((Monster) e);
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
