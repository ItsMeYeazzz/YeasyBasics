package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class SpellManager {

	private final Util util = new Util();
	
	private final List<Spell> spellList = Arrays.asList(
			bunnyHop(), bubble(), giftOfRage(), royalDinner(), vitalDischarge(),
			solarGlow(), nocturnalHymn(), flash(), pyroWave(), levitation(),
			yumYum(), ninja(), shockWave(), ironSkin(), mortalPoison(),
			metallicBurst(), revitalization());

	public static boolean isSpell(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		return item.getType() == Material.PLAYER_HEAD && meta.hasCustomModelData() && meta.getCustomModelData() == Spell.NBT_TAG;
	}

	public static void addSpellToItem(ItemStack item, Spell spell) {
		if(!isSpell(item)) return;
		ItemMeta meta = item.getItemMeta();
		if(!meta.hasDisplayName()) meta.setDisplayName(spell.getName());
		item.setItemMeta(meta);
		NBTItem nbtItem = new NBTItem(item);
		setSkinNBT(nbtItem, spell.getSkinValue());
		nbtItem.setString(Spell.TYPE_KEY, spell.getType().name());
		nbtItem.setString(Spell.RARITY_KEY, spell.getRarity().name());
		nbtItem.setInteger(Spell.LEVEL_KEY, spell.getLevel());
		nbtItem.setInteger(Spell.MAX_LEVEL_KEY, spell.getMaxLevel());
		nbtItem.setInteger(Spell.MANA_COST_KEY, spell.getManaCost());
		nbtItem.applyNBT(item);
	}

	@Nullable
	public static Spell getSpellFromItem(ItemStack item) {
		if(!isSpell(item)) return null;
		NBTItem nbtItem = new NBTItem(item);
		String type = nbtItem.getString(Spell.TYPE_KEY), rarity = nbtItem.getString(Spell.RARITY_KEY);
		int level = nbtItem.getInteger(Spell.LEVEL_KEY), maxLevel = nbtItem.getInteger(Spell.MAX_LEVEL_KEY), manaCost = nbtItem.getInteger(Spell.MANA_COST_KEY);
		Spell spell = new Spell(SpellType.valueOf(type));
		spell.setName(item.getItemMeta().getDisplayName());
		spell.setRarity(Rarity.valueOf(rarity));
		spell.setLevel(level);
		spell.setMaxLevel(maxLevel);
		spell.setManaCost(manaCost);
		return spell;
	}

	protected static void setSkinNBT(NBTItem nbtItem, String skinValue) {
		NBTCompound skull = nbtItem.addCompound("SkullOwner");
		skull.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
		NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
		texture.setString("Value", skinValue);
	}

	public Spell bunnyHop() {
		Spell spell = new Spell(SpellType.BUNNY_HOP);
		spell.setRarity(Rarity.UNCOMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFhOTFmMWZhYjlhNWMzMDQ3Mzg3NTg2OTc4ZDI5MTljOWY1NGQ4OGYzZTYxNDU4YWJlYzE2OTRkOTYxNzY5ZCJ9fX0=");
		spell.setName(util.getColMsg("&aBunny Hop &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(50);
		return spell;
	}

	public Spell bubble() {
		Spell spell = new Spell(SpellType.BUBBLE);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzI0NTIwOGQ0ZjQzZGUxMzY3ZjcyOGU0YjkxNTg2NjI2ZDk1NzEwY2VlZDc0YTUxYTRjZGExYWM3Y2EyZmI2In19fQ==");
		spell.setName(util.getColMsg("&dBubulle &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(20);
		return spell;
	}

	public Spell giftOfRage() {
		Spell spell = new Spell(SpellType.GIFT_OF_RAGE);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM0MjVlYTljNGE0Y2JkMTIzYTlmZmQ0YTBiYTc0ODBlN2M1MTU0MjNkZDczMGZiOWZiNjQzYzE4NDkwMTA3ZiJ9fX0=");
		spell.setName(util.getColMsg("&5Don de Rage &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(40);
		return spell;
	}

	public Spell royalDinner() {
		Spell spell = new Spell(SpellType.ROYAL_DINNER);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWFlNWQ2NTZjNjM1Mjc4MjJjMjE3ZjQyNjdkYTBiNzUyNmU2NTQyNTRiNDFlNDA3N2VhNjc3YmM3Nzg2M2M1YiJ9fX0=");
		spell.setName(util.getColMsg("&6Dîner Royal &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(25);
		return spell;
	}

	public Spell vitalDischarge() {
		Spell spell = new Spell(SpellType.VITAL_DISCHARGE);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWIxNWNlODIzNzcwZDlhMjY5YzFlYmY1ODNkM2U0OTMyNzQ3YTEzZWY0MzYxM2NkNGY3NWY4MDRjYTQifX19");
		spell.setName(util.getColMsg("&dDécharge Vitale &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public Spell solarGlow() {
		Spell spell = new Spell(SpellType.SOLAR_GLOW);
		spell.setRarity(Rarity.EPIC);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODI5Y2EzY2VjODQwMWNhZmUyN2EzN2ZlNjAxZWUwZTMzM2IwZjUyMWI2NWI5YTczMWU0MjRmZjZhYTFhNGI0NCJ9fX0=");
		spell.setName(util.getColMsg("&eÉclat Solaire &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(60);
		return spell;
	}

	public Spell nocturnalHymn() {
		Spell spell = new Spell(SpellType.NOCTURNAL_HYMN);
		spell.setRarity(Rarity.UNCOMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE1OGJmN2E3MTQ2ZGFhYjczNDgzNWJiNDZkNDNiODZiNTRiYjVhMzJiZWQyODY4YzJmNzk2NjE0MTgwZTEifX19");
		spell.setName(util.getColMsg("&3Hymne Nocturne &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public Spell flash() {
		Spell spell = new Spell(SpellType.FLASH);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRkYzM2ZWIwYTVlMzFmZDBjOWRkYTM1YWI2ZDI2ODExY2RkYWMyMTc5YTkxOWRjNGQ0NzdlMDljZjgxZTY1YSJ9fX0=");
		spell.setName(util.getColMsg("&cFlash &3[&bLvl." + spell.getLevel() + "&3]"));
		spell.setManaCost(30);
		return spell;
	}

	public Spell pyroWave() {
		Spell spell = new Spell(SpellType.PYRO_WAVE);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDA4MGJiZWZjYTg3ZGMwZjM2NTM2YjY1MDg0MjVjZmM0Yjk1YmE2ZThmNWU2YTQ2ZmY5ZTljYjQ4OGE5ZWQifX19");
		spell.setName(util.getColMsg("&4Vague Pyro &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(40);
		return spell;
	}

	public Spell levitation() {
		Spell spell = new Spell(SpellType.LEVITATION);
		spell.setRarity(Rarity.LEGENDARY);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDkzNmJiMWNjNGFiNmVjY2U2NWI2NDI5ODM5NGZhZmM1ZmUzZjc4NzZkN2M5NDFkMDVhOTI5NGZhMzkyYjdjIn19fQ==");
		spell.setName(util.getColMsg("&1Lévitation &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(80);
		return spell;
	}

	public Spell yumYum() {
		Spell spell = new Spell(SpellType.YUM_YUM);
		spell.setRarity(Rarity.UNCOMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjNlMDIwNzI0ZWYwYWJmZjcyNTc2YjE4ZWZlOTkwNzI2MGQ4NjJmYTE4ODY3YzNlM2VkOWZkMzhhZGU5MTkwIn19fQ==");
		spell.setName(util.getColMsg("&6Miam Miam &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(15);
		return spell;
	}

	public Spell ninja() {
		Spell spell = new Spell(SpellType.NINJA);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmY3MzMyNjk2MTRmZThhOWFlODlmNWM1ODI4NmFhNTNiOWUzODNmYzRkYzU3ZTM3ZWNiZmE1ZTkzYSJ9fX0=");
		spell.setName(util.getColMsg("&9Ninja &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public Spell shockWave() {
		Spell spell = new Spell(SpellType.SHOCK_WAVE);
		spell.setRarity(Rarity.EPIC);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTY3OTliZmFhM2EyYzYzYWQ4NWRkMzc4ZTY2ZDU3ZDlhOTdhM2Y4NmQwZDlmNjgzYzQ5ODYzMmY0ZjVjIn19fQ==");
		spell.setName(util.getColMsg("&4Onde de Choc &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public Spell ironSkin() {
		Spell spell = new Spell(SpellType.IRON_SKIN);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("");
		spell.setName(util.getColMsg("&bPeau de Fer &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public Spell mortalPoison() {
		Spell spell = new Spell(SpellType.MORTAL_POISON);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQ5ZThkZTFmZTE3NjA4Mzg2OWUzMDI1MjRjNjUwMTBkN2NmMmUzMWIwNjNlYmI4YmM3NmI3OWQxNDEzMCJ9fX0=");
		spell.setName(util.getColMsg("&2Poison Mortel &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(40);
		return spell;
	}

	public Spell metallicBurst() {
		Spell spell = new Spell(SpellType.METALLIC_BURST);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY5ZDBkNDcxMTE1M2EwODljNTU2N2E3NDliMjc4NzljNzY5ZDNiZGNlYTZmZGE5ZDZmNjZlOTNkZDhjNDUxMiJ9fX0=");
		spell.setName(util.getColMsg("&7Salve Métallique &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public Spell revitalization() {
		Spell spell = new Spell(SpellType.REVITALIZATION);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYyY2ZhOWNkMDY4NTZjZDk0N2VhY2FiNzBjYjQ1OWUzYjE3YTIxY2E0NDc1NTVhYmNiNzczOWJlN2Y1M2UzMiJ9fX0=");
		spell.setName(util.getColMsg("&2Revitalisation &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(30);
		return spell;
	}
}
