package com.gmail.perhapsitisyeazz.yeasybasics.listeners;

import com.gmail.perhapsitisyeazz.yeasybasics.YeasyBasics;
import com.gmail.perhapsitisyeazz.yeasybasics.events.SpellCastEvent;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.Spell;
import com.gmail.perhapsitisyeazz.yeasybasics.spell.SpellManager;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Message;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UtilsEvt implements Listener {

	public YeasyBasics main;
	public UtilsEvt(YeasyBasics main) {
		this.main = main;
	}

    private final Util util = new Util();
    private final Message message = new Message();

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        String player = event.getPlayer().getDisplayName();
        event.setJoinMessage(util.getColMsg("&7[&a&l+&7] " + player));
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        String player = event.getPlayer().getDisplayName();
        event.setQuitMessage(util.getColMsg("&7[&ac&l-&7] " + player));
    }

    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {
        String newMessage = event.getMessage();
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player == event.getPlayer()) continue;
            if(event.getMessage().contains(player.getName())) {
                ChatColor color = ChatColor.of(ChatColor.of(event.getMessage()).getColor());
                newMessage = newMessage.replaceAll(player.getName(), ChatColor.AQUA + player.getName() + color);
                player.sendActionBar(message.logo + util.getColMsg("&b" + event.getPlayer().getName() + " &7has pinged you in the chat."));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
            }
        }
        event.setMessage(ChatColor.translateAlternateColorCodes('&', newMessage));
    }

    @EventHandler
    private void onCastSpellFireEvent(PlayerInteractEvent event) {
        Action action = event.getAction();
        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if(item == null) return;
            if(SpellManager.isSpell(item)) {
                Spell spell = SpellManager.getSpellFromItem(item);
                if (spell == null) return;
                Bukkit.getPluginManager().callEvent(new SpellCastEvent(event.getPlayer(), spell));
            }
        }
    }

    @EventHandler
    private void onPlaceSpell(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if(item.getType() == Material.PLAYER_HEAD || item.getType() == Material.PLAYER_WALL_HEAD) {
            ItemMeta meta = item.getItemMeta();
            if(meta.hasDisplayName() && meta.hasLore()) {
                event.setCancelled(true);
            }
        }
    }
}
