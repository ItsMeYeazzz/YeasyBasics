package com.gmail.perhapsitisyeazz.yeasybasics.listeners;

import com.gmail.perhapsitisyeazz.yeasybasics.YeasyBasics;
import com.gmail.perhapsitisyeazz.yeasybasics.events.SpellCastEvent;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CastSpellEvent implements Listener {

	public YeasyBasics main;
	public CastSpellEvent(YeasyBasics main) {
		this.main = main;
	}

	@EventHandler
	private void onCastSpell(SpellCastEvent event) {
		if(event.getSpell() == SpellType.BUBBLE) {
			event.getPlayer().getName();
		}
	}
}
