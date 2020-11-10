package com.gmail.perhapsitisyeazz.yeasybasics.spell;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class SpellManager {

	protected final List<Spell> spellList = Arrays.asList(
			bunnyHop(), bubble(), giftOfRage(), royalDinner(), vitalDischarge(),
			solarGlow(), nocturnalHymn(), flash(), pyroWave(), levitation(),
			yumYum(), ninja(), shockWave(), ironSkin(), mortalPoison(),
			metallicBurst(), revitalization());

	public String sendSpellMessage(Spell spell) {
		return Spell.spellLogo + Util.getColMsg("You have used " + spell.getName() + ".");
	}

	public static boolean isSpell(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		return meta.hasCustomModelData() && meta.getCustomModelData() == Spell.NBT_TAG;
	}

	public static void setSpellToItem(ItemStack item, Spell spell) {
		ItemMeta meta = item.getItemMeta();
		if(!meta.hasDisplayName())
			meta.setDisplayName(spell.getName());
		meta.setCustomModelData(Spell.NBT_TAG);
		item.setItemMeta(meta);
		NBTItem nbtItem = new NBTItem(item);
		if(item.getType() == Material.PLAYER_HEAD)
			setSkinNBT(nbtItem, spell.getSkinValue());
		nbtItem.setString(Spell.TYPE_KEY, spell.getType().name());
		nbtItem.setString(Spell.RARITY_KEY, spell.getRarity().name());
		nbtItem.setInteger(Spell.LEVEL_KEY, spell.getLevel());
		nbtItem.setInteger(Spell.MAX_LEVEL_KEY, spell.getMaxLevel());
		nbtItem.setInteger(Spell.MANA_COST_KEY, spell.getManaCost());
		nbtItem.applyNBT(item);
	}

	public static Spell getSpellFromItem(ItemStack item) {
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

	public final Inventory spellMenu() {
		Inventory inv = Bukkit.createInventory(null, 36, "Spell menu !");
		for(Spell spell : spellList) {
			Rarity r = spell.getRarity();
			ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
			NBTItem nbtItem = new NBTItem(item);
			setSkinNBT(nbtItem, spell.getSkinValue());
			inv.addItem(Util.createGuiItem(item, spell.getName(), "", ChatColor.AQUA + "Mana cost : " + spell.getManaCost(), "", r.color + r.toString() + " SPELL"));
		}
		return inv;
	}

	protected static void setSkinNBT(NBTItem nbtItem, String skinValue) {
		NBTCompound skull = nbtItem.addCompound("SkullOwner");
		skull.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
		NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
		texture.setString("Value", skinValue);
	}

	public final Spell bunnyHop() {
		Spell spell = new Spell(SpellType.BUNNY_HOP);
		spell.setRarity(Rarity.UNCOMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjFhOTFmMWZhYjlhNWMzMDQ3Mzg3NTg2OTc4ZDI5MTljOWY1NGQ4OGYzZTYxNDU4YWJlYzE2OTRkOTYxNzY5ZCJ9fX0=");
		spell.setName(Util.getColMsg("&aBunny Hop &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(50);
		return spell;
	}

	public final Spell bubble() {
		Spell spell = new Spell(SpellType.BUBBLE);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzI0NTIwOGQ0ZjQzZGUxMzY3ZjcyOGU0YjkxNTg2NjI2ZDk1NzEwY2VlZDc0YTUxYTRjZGExYWM3Y2EyZmI2In19fQ==");
		spell.setName(Util.getColMsg("&dBubulle &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(20);
		return spell;
	}

	public final Spell giftOfRage() {
		Spell spell = new Spell(SpellType.GIFT_OF_RAGE);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM0MjVlYTljNGE0Y2JkMTIzYTlmZmQ0YTBiYTc0ODBlN2M1MTU0MjNkZDczMGZiOWZiNjQzYzE4NDkwMTA3ZiJ9fX0=");
		spell.setName(Util.getColMsg("&5Don de Rage &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(40);
		return spell;
	}

	public final Spell royalDinner() {
		Spell spell = new Spell(SpellType.ROYAL_DINNER);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWFlNWQ2NTZjNjM1Mjc4MjJjMjE3ZjQyNjdkYTBiNzUyNmU2NTQyNTRiNDFlNDA3N2VhNjc3YmM3Nzg2M2M1YiJ9fX0=");
		spell.setName(Util.getColMsg("&6Dîner Royal &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(25);
		return spell;
	}

	public final Spell vitalDischarge() {
		Spell spell = new Spell(SpellType.VITAL_DISCHARGE);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWIxNWNlODIzNzcwZDlhMjY5YzFlYmY1ODNkM2U0OTMyNzQ3YTEzZWY0MzYxM2NkNGY3NWY4MDRjYTQifX19");
		spell.setName(Util.getColMsg("&dDécharge Vitale &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public final Spell solarGlow() {
		Spell spell = new Spell(SpellType.SOLAR_GLOW, 1);
		spell.setRarity(Rarity.EPIC);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODI5Y2EzY2VjODQwMWNhZmUyN2EzN2ZlNjAxZWUwZTMzM2IwZjUyMWI2NWI5YTczMWU0MjRmZjZhYTFhNGI0NCJ9fX0=");
		spell.setName(Util.getColMsg("&eÉclat Solaire &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(60);
		return spell;
	}

	public final Spell nocturnalHymn() {
		Spell spell = new Spell(SpellType.NOCTURNAL_HYMN);
		spell.setRarity(Rarity.UNCOMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE1OGJmN2E3MTQ2ZGFhYjczNDgzNWJiNDZkNDNiODZiNTRiYjVhMzJiZWQyODY4YzJmNzk2NjE0MTgwZTEifX19");
		spell.setName(Util.getColMsg("&3Hymne Nocturne &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public final Spell flash() {
		Spell spell = new Spell(SpellType.FLASH);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRkYzM2ZWIwYTVlMzFmZDBjOWRkYTM1YWI2ZDI2ODExY2RkYWMyMTc5YTkxOWRjNGQ0NzdlMDljZjgxZTY1YSJ9fX0=");
		spell.setName(Util.getColMsg("&cFlash &3[&bLvl." + spell.getLevel() + "&3]"));
		spell.setManaCost(30);
		return spell;
	}

	public final Spell pyroWave() {
		Spell spell = new Spell(SpellType.PYRO_WAVE);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDA4MGJiZWZjYTg3ZGMwZjM2NTM2YjY1MDg0MjVjZmM0Yjk1YmE2ZThmNWU2YTQ2ZmY5ZTljYjQ4OGE5ZWQifX19");
		spell.setName(Util.getColMsg("&4Vague Pyro &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(40);
		return spell;
	}

	public final Spell levitation() {
		Spell spell = new Spell(SpellType.LEVITATION);
		spell.setRarity(Rarity.LEGENDARY);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDkzNmJiMWNjNGFiNmVjY2U2NWI2NDI5ODM5NGZhZmM1ZmUzZjc4NzZkN2M5NDFkMDVhOTI5NGZhMzkyYjdjIn19fQ==");
		spell.setName(Util.getColMsg("&1Lévitation &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(80);
		return spell;
	}

	public final Spell yumYum() {
		Spell spell = new Spell(SpellType.YUM_YUM);
		spell.setRarity(Rarity.UNCOMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjNlMDIwNzI0ZWYwYWJmZjcyNTc2YjE4ZWZlOTkwNzI2MGQ4NjJmYTE4ODY3YzNlM2VkOWZkMzhhZGU5MTkwIn19fQ==");
		spell.setName(Util.getColMsg("&6Miam Miam &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(15);
		return spell;
	}

	public final Spell ninja() {
		Spell spell = new Spell(SpellType.NINJA);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmY3MzMyNjk2MTRmZThhOWFlODlmNWM1ODI4NmFhNTNiOWUzODNmYzRkYzU3ZTM3ZWNiZmE1ZTkzYSJ9fX0=");
		spell.setName(Util.getColMsg("&9Ninja &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public final Spell shockWave() {
		Spell spell = new Spell(SpellType.SHOCK_WAVE);
		spell.setRarity(Rarity.EPIC);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTY3OTliZmFhM2EyYzYzYWQ4NWRkMzc4ZTY2ZDU3ZDlhOTdhM2Y4NmQwZDlmNjgzYzQ5ODYzMmY0ZjVjIn19fQ==");
		spell.setName(Util.getColMsg("&4Onde de Choc &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public final Spell ironSkin() {
		Spell spell = new Spell(SpellType.IRON_SKIN);
		spell.setRarity(Rarity.RARE);
		spell.setSkinValue("");
		spell.setName(Util.getColMsg("&bPeau de Fer &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public final Spell mortalPoison() {
		Spell spell = new Spell(SpellType.MORTAL_POISON);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQ5ZThkZTFmZTE3NjA4Mzg2OWUzMDI1MjRjNjUwMTBkN2NmMmUzMWIwNjNlYmI4YmM3NmI3OWQxNDEzMCJ9fX0=");
		spell.setName(Util.getColMsg("&2Poison Mortel &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(40);
		return spell;
	}

	public final Spell metallicBurst() {
		Spell spell = new Spell(SpellType.METALLIC_BURST);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY5ZDBkNDcxMTE1M2EwODljNTU2N2E3NDliMjc4NzljNzY5ZDNiZGNlYTZmZGE5ZDZmNjZlOTNkZDhjNDUxMiJ9fX0=");
		spell.setName(Util.getColMsg("&7Salve Métallique &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(35);
		return spell;
	}

	public final Spell revitalization() {
		Spell spell = new Spell(SpellType.REVITALIZATION);
		spell.setRarity(Rarity.COMMON);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYyY2ZhOWNkMDY4NTZjZDk0N2VhY2FiNzBjYjQ1OWUzYjE3YTIxY2E0NDc1NTVhYmNiNzczOWJlN2Y1M2UzMiJ9fX0=");
		spell.setName(Util.getColMsg("&2Revitalisation &3[&bLvl. " + spell.getLevel() + "&3]"));
		spell.setManaCost(30);
		return spell;
	}

	public final Spell rageOfTheWarrior() {
		Spell spell = new Spell(SpellType.RAGE_OF_THE_WARRIOR);
		spell.setRarity(Rarity.EPIC);
		spell.setSkinValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODMxNTJiMzhkYzE0MjU4OGQxNGZkZDM4YWFhMGI1NGU2MTM4NjBmN2QxNTM5NTM1YjMyYzAxZWIyMjBmZTY3YiJ9fX0=");
		spell.setName(Util.getColMsg("&dWarrior &3[&bLvl." + spell.getLevel() + "&3]"));
		spell.setManaCost(45);
		return spell;
	}
}
