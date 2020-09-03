package com.gmail.perhapsitisyeazz.yeasybasics.listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UtilsEvt implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        String player = event.getPlayer().getDisplayName();
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "+" + ChatColor.GRAY + "] " + player);
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        String player = event.getPlayer().getDisplayName();
        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "-" + ChatColor.GRAY + "] " + player);
    }


    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
    }
}
