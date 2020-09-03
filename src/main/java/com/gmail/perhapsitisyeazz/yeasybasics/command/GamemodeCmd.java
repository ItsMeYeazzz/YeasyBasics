package com.gmail.perhapsitisyeazz.yeasybasics.command;

import com.gmail.perhapsitisyeazz.yeasybasics.manager.Message;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Utils;
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
    private final Utils utils = new Utils();

    private final String logo = TextComponent.toLegacyText(message.logo);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0) {
            GameMode gm;
            if (match(args[0], "survival", "s", "0")) gm = GameMode.SURVIVAL;
            else if (match(args[0], "creative", "c", "1")) gm = GameMode.CREATIVE;
            else if (match(args[0], "adventure", "a", "2")) gm = GameMode.ADVENTURE;
            else if (match(args[0], "spectator", "s", "3")) gm = GameMode.SPECTATOR;
            else {
                utils.sendMessage(sender, logo + ChatColor.RED + "Error : Invalid argument : '" + ChatColor.DARK_PURPLE + args[0] + ChatColor.RED + "'.");
                sender.sendMessage(message.helpMessage());
                return true;
            }
            if (args.length > 1) {
                Player target = Bukkit.getPlayer(args[1]);
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    Player finalTarget = target != null ? target : player;
                    setGamemode(gm, sender, finalTarget);
                    return true;
                } else if (target != null) {
                    setGamemode(gm, sender, target);
                    return true;
                }
            } else if (sender instanceof Player) {
                Player target = (Player) sender;
                setGamemode(gm, sender, target);
                return true;
            }
        }
        sender.sendMessage(message.helpMessage());
        return true;
    }

    private void setGamemode(GameMode gm, CommandSender sender, Player target) {
        String gamemode = gm.name().toLowerCase();
        if (target.getGameMode() != gm) {
            if(sender instanceof Player) {
                if (sender != target) {
                    ((Player) sender).sendActionBar(logo + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " has set your gamemode to " + ChatColor.AQUA + gamemode+ChatColor.RED + ".");
                }
            } else {
                target.sendMessage(logo + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " has set your gamemode to " + ChatColor.AQUA + gamemode + ChatColor.GREEN + ".");
            }
            utils.sendMessage(sender, logo + ChatColor.AQUA + target.getName() + ChatColor.GREEN + "'s gamemode has been set to " + ChatColor.GREEN + gamemode + ChatColor.RED + ".");
            target.setGameMode(gm);
        } else {
            utils.sendMessage(sender, logo + ChatColor.DARK_AQUA + target.getName() + ChatColor.DARK_GREEN + " is already in " + ChatColor.DARK_AQUA + gamemode + ChatColor.DARK_GREEN + ".");
        }
    }

    private boolean match(String arg, String... str) {
        for (String m : str) {
            if (m.equalsIgnoreCase(arg)) return true;
        }
        return false;
    }
}
