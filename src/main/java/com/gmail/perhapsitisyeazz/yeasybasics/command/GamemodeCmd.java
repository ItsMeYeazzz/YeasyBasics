package com.gmail.perhapsitisyeazz.yeasybasics.command;

import com.gmail.perhapsitisyeazz.yeasybasics.manager.Message;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCmd implements CommandExecutor {

    private final Message message = new Message();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(message.helpMessage());
        } else {
            Player playerArg = Bukkit.getPlayer(args[1]);
            if (sender instanceof Player) {
                Player player = (Player) sender;
                setGamemode(args[0], playerArg != null ? playerArg : player);
            } else if (playerArg == null) {
                sender.sendMessage(message.helpMessage());
            } else {
                setGamemode(args[0], playerArg);
            }
        }
        return true;
    }

    private void setGamemode(String arg, Player player) {
        String logo = TextComponent.toLegacyText(message.logo);
        GameMode gm;
        if (match(arg, "survival", "s", "0")) gm = GameMode.SURVIVAL;
        else if (match(arg, "creative", "c", "1")) gm = GameMode.CREATIVE;
        else if (match(arg, "adventure", "a", "2")) gm = GameMode.ADVENTURE;
        else if (match(arg, "spectator", "s", "3")) gm = GameMode.SPECTATOR;
        else {
            player.sendActionBar(ChatColor.RED + "Error : Argument 2");
            return;
        }
        if (gm == player.getGameMode()) {
            player.sendActionBar(logo + ChatColor.DARK_GREEN + "You are already in " + gm.name() + ".");
        } else {
            player.setGameMode(gm);
            player.sendActionBar(logo + ChatColor.GREEN + "Your gamemode has been set to survival " + gm.name() + ".");
        }
    }

    private boolean match(String arg, String... str) {
        for (String m : str) {
            if (m.equalsIgnoreCase(arg)) return true;
        }
        return false;
    }
}
