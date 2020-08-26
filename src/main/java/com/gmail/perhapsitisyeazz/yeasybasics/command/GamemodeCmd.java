package com.gmail.perhapsitisyeazz.yeasybasics.command;

import com.gmail.perhapsitisyeazz.yeasybasics.YeasyBasics;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class GamemodeCmd implements CommandExecutor {

    public YeasyBasics main;

    public GamemodeCmd(YeasyBasics main) {
        this.main = main;
    }

    private final List<String> subCmd = Arrays.asList("survival", "creative", "adventure", "spectator");

    private final List<String> descCmd = Arrays.asList(
            "Survival gamemode",
            "Creative gamemode",
            "Adventure gamemode",
            "Spectator gamemode"
    );

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                ComponentBuilder builder = new ComponentBuilder();
                builder
                        .append("[").color(ChatColor.DARK_GRAY)
                        .append("Basics").color(ChatColor.DARK_AQUA)
                        .append("]").color(ChatColor.DARK_GRAY)
                        .append(" Correct usage:").color(ChatColor.DARK_GREEN);
                for (String sub : subCmd) {
                    for (String desc : descCmd) {
                        String arg = sub.split(" ")[0].substring(0, 1).toUpperCase() + sub.split(" ")[0].substring(1);
                        builder
                                .append("\n» ").color(ChatColor.DARK_AQUA)
                                .append("/gamemode " + sub).color(ChatColor.GREEN)
                                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(
                                                ChatColor.DARK_GREEN + "Command: " + ChatColor.AQUA + arg +
                                                ChatColor.DARK_GREEN + "\nDescription: " + ChatColor.AQUA + desc +
                                                ChatColor.DARK_GREEN + "\nUsage: " + ChatColor.AQUA + command.getName() + "" + sub +
                                                "\n\n" + ChatColor.GRAY + "Click to execute.")))
                                .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "gamemode " + sub));
                    }
                }
            }
            Player playerArg = Bukkit.getPlayer(args[2]);
            setGamemode(args[0], playerArg != null ? playerArg : player);
        } else {
            sender.sendMessage(ChatColor.RED + "Player-only commands.");
        }
        return true;
    }

    private void setGamemode(String arg, Player player) {
        GameMode gm;
        if(match(arg, "survival", "s", "0")) gm = GameMode.SURVIVAL;
        else if(match(arg, "creative", "c", "1")) gm = GameMode.CREATIVE;
        else if(match(arg, "adventure", "a", "2")) gm = GameMode.ADVENTURE;
        else if(match(arg, "spectator", "s", "3")) gm = GameMode.SPECTATOR;
        else {
            player.sendActionBar(ChatColor.RED + "Error : Argument 2");
            return;
        }
        if(gm == player.getGameMode()) {
            player.sendActionBar(ChatColor.DARK_GREEN + "You are already in " + gm.name() + ".");
        } else {
            player.setGameMode(gm);
            player.sendActionBar(ChatColor.GREEN + "Your gamemode has been set to survival " + gm.name() + ".");
        }
    }

    private boolean match(String arg, String... str){
        for(String m : str){
            if(m.equalsIgnoreCase(arg)) return true;
        }
        return false;
    }
}
