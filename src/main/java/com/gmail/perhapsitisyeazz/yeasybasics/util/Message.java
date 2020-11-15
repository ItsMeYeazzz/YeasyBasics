package com.gmail.perhapsitisyeazz.yeasybasics.util;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class Message {

    public static final String logo = Util.getColMsg("&8[&3Basics&8] ");

    public final List<String> gmSubCmd = Arrays.asList("survival", "creative", "adventure", "spectator");
    private final List<String> gmAliasCmd = Arrays.asList("s, 0", "c, 1", "a, 2", "s, 3");
    private final List<String> gmDescCmd = Arrays.asList(
            "Set the gamemode of a player to Survival",
            "Set the gamemode of a player to Creative",
            "Set the gamemode of a player to Adventure",
            "Set the gamemode of a player to Spectator"
    );
    public final List<String> timeSubCmd = Arrays.asList("set", "add", "remove");
    private final List<String> timeDescCmd = Arrays.asList(
            "Set the time of a world",
            "Add ticks to a time of a world",
            "Remove ticks from a time of a world"
    );

    public BaseComponent[] gmHelpMessage(){
        ComponentBuilder builder = new ComponentBuilder();
        builder
                .append(logo)
                .append("Correct usage:").color(ChatColor.DARK_GREEN);
        for(int i = 0; i < 4; i++) {
            String sub = gmSubCmd.get(i), desc = gmDescCmd.get(i), alias = gmAliasCmd.get(i);
            String arg = sub.split(" ")[0].substring(0, 1).toUpperCase() + sub.split(" ")[0].substring(1);
            builder
                    .append(" \n» ").color(ChatColor.DARK_AQUA)
                    .append("/gamemode " + sub).color(ChatColor.GREEN)
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Util.getColMsg(
                            "&2Command: &b" + arg +
                                    "\n&2Description: &b" + desc +
                                    "\n&2Usage: &b/gm " + sub + " [<player>]" +
                                    "\n&2Aliases: &b" + alias +
                                    "\n\n&7Click to execute"))))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gamemode " + sub))
                    .append("").retain(ComponentBuilder.FormatRetention.NONE).reset();
        }
        return builder.create();
    }

    public BaseComponent[] timeHelpMessage() {
        ComponentBuilder builder = new ComponentBuilder();
        builder
                .append(logo)
                .append("Correct usage:").color(ChatColor.DARK_GREEN);
        for(int i = 0; i < 3; i++) {
            String sub = timeSubCmd.get(i), desc = timeDescCmd.get(i);
            String arg = sub.split(" ")[0].substring(0, 1).toUpperCase() + sub.split(" ")[0].substring(1);
            builder
                    .append(" \n» ").color(ChatColor.DARK_AQUA)
                    .append("/time " + sub).color(ChatColor.GREEN)
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Util.getColMsg(
                            "&2Command: &b" + arg +
                                    "\n&2Description: &b" + desc +
                                    "\nUsage: &b/time " + sub + " [<world>] <string/long>" +
                                    "\n\n&7Click to execute"))))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/time " + sub))
                    .append("").retain(ComponentBuilder.FormatRetention.NONE).reset();
        }
        return builder.create();
    }
}
