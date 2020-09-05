package com.gmail.perhapsitisyeazz.yeasybasics.manager;

import com.gmail.perhapsitisyeazz.yeasybasics.util.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class Message {

    private final Utils utils = new Utils();

    public final String logo = "&8[&3Basics&8] ";

    private final List<String> subCmd = Arrays.asList("survival", "creative", "adventure", "spectator");

    private final List<String> aliasCmd = Arrays.asList("s, 0", "c, 1", "a, 2", "s, 3");

    private final List<String> descCmd = Arrays.asList(
            "Survival gamemode",
            "Creative gamemode",
            "Adventure gamemode",
            "Spectator gamemode"
    );

    public void sendMessage(CommandSender sender, String msg) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.sendActionBar(msg);
        } else {
            sender.sendMessage(msg);
        }
    }

    @SuppressWarnings("deprecation")
    public BaseComponent[] helpMessage(){
        ComponentBuilder builder = new ComponentBuilder();
        builder
                .append(logo)
                .append(" Correct usage:").color(ChatColor.DARK_GREEN);
        for(int i = 0; i < 4; i++) {
            String sub = subCmd.get(i), desc = descCmd.get(i);
            String arg = sub.split(" ")[0].substring(0, 1).toUpperCase() + sub.split(" ")[0].substring(1);
            String alias = aliasCmd.get(i);
            builder
                    .append("\n» ").color(ChatColor.DARK_AQUA)
                    .append("/gamemode " + sub).color(ChatColor.GREEN)
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(utils.getColMsg(
                            "&2Command: &b" + arg +
                                    "\n&2Description: &b" + desc +
                                    "\n&2Usage: &b/gamemode" + sub + "[<player>]" +
                                    "\n&2Aliases: &b" + alias +
                                    "\n\n&7Click to execute."))))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gamemode " + sub))
                    .append("").retain(ComponentBuilder.FormatRetention.NONE).reset();
        }
        return builder.create();
    }
}
