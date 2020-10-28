package com.gmail.perhapsitisyeazz.yeasybasics.commands;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Message;
import com.gmail.perhapsitisyeazz.yeasybasics.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCmd implements CommandExecutor {

    private final Message message = new Message();
    private final Util util = new Util();

    private final String logo = message.logo;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length > 0) {
            GameMode gm;
            if (util.match(args[0], "survival", "s", "0")) gm = GameMode.SURVIVAL;
            else if(util.match(args[0], "creative", "c", "1")) gm = GameMode.CREATIVE;
            else if(util.match(args[0], "adventure", "a", "2")) gm = GameMode.ADVENTURE;
            else if(util.match(args[0], "spectator", "s", "3")) gm = GameMode.SPECTATOR;
            else {
                util.sendMessage(sender, util.getColMsg(logo + "&cError : Invalid argument : '&5" + args[0] + "&c'."));
                sender.sendMessage(message.gmHelpMessage());
                return true;
            }
            if(args.length > 1) {
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
            } else if(sender instanceof Player) {
                Player target = (Player) sender;
                setGamemode(gm, sender, target);
                return true;
            }
        }
        sender.sendMessage(message.gmHelpMessage());
        return true;
    }

    private void setGamemode(GameMode gm, CommandSender sender, Player target) {
        String gamemode = gm.name().toLowerCase();
        if(target.getGameMode() != gm) {
            if(sender instanceof Player) {
                if(sender != target) {
                    ((Player) sender).sendActionBar(logo + util.getColMsg("&b" + sender.getName() + "&a has set your gamemode to &b" + gamemode + "&a."));
                }
            } else {
                target.sendMessage(logo + util.getColMsg("&b" + sender.getName() + "&a has set your gamemode to &b" + gamemode + "&a."));
            }
            util.sendMessage(sender, logo + util.getColMsg("&b" + target.getName() + "&a's gamemode has been set to &b" + gamemode +"&a."));
            target.setGameMode(gm);
        } else {
            util.sendMessage(sender, logo + util.getColMsg("&3" + target.getName() + "&2 is already in &3" + gamemode + "&2."));
        }
    }
}
