package com.gmail.perhapsitisyeazz.yeasybasics.events;

import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class SpellCastEvent extends Event implements Cancellable {

	private final Player player;
	private final Spell spell;
	private boolean isCancelled;

	public SpellCastEvent(@NotNull Player player, @NotNull Spell spell) {
		this.player = player;
		this.spell = spell;
		this.isCancelled = false;
	}

	public Player getPlayer() {
		return player;
	}

	public Spell getSpell() {
		return spell;
	}

	private static final HandlerList handlers = new HandlerList();

	@SuppressWarnings("NullableProblems")
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
}
