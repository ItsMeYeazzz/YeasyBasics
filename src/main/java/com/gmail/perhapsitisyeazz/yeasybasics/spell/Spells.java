package com.gmail.perhapsitisyeazz.yeasybasics.spell;

public class Spells {

	public Spell BunnyHop() {
		Spell spell = new Spell(SpellType.BUNNY_HOPE);
		spell.setName("Bunny Hop");
		spell.setManaCost(30);
		spell.setSpellMaxLevel(3);
		return spell;
	}

	public Spell Bubble() {
		Spell spell = new Spell(SpellType.BUBBLE);
		spell.setName("Bubulle");
		return spell;
	}
}
