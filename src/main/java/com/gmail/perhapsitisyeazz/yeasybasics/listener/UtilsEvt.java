package com.gmail.perhapsitisyeazz.yeasybasics.listener;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UtilsEvt implements Listener {

    private final Utils utils = new Utils();

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        String player = event.getPlayer().getDisplayName();
        event.setJoinMessage(utils.getColMsg("&7[&a&l+&7] " + player));
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        String player = event.getPlayer().getDisplayName();
        event.setQuitMessage(utils.getColMsg("&7[&ac&l-&7] " + player));
    }


    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
    }
}
