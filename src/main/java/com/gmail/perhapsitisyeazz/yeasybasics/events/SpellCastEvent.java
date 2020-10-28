package com.gmail.perhapsitisyeazz.yeasybasics.events;

import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class SpellCastEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private final Player player;
	private final Spell spell;
	private final int spellLevel;

	public SpellCastEvent(@NotNull Player player, @NotNull Spell spell, int spellLevel) {
		this.player = player;
		this.spell = spell;
		this.spellLevel = spellLevel;
	}

	public Player getPlayer() {
		return player;
	}

	public Spell getSpell() {
		return spell;
	}

	public int getSpellLevel() {
		return spellLevel;
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
