package com.gmail.perhapsitisyeazz.yeasybasics.manager;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;

import java.util.Arrays;
import java.util.List;

public class Message {

    public final BaseComponent[] logo = new ComponentBuilder()
            .append("[").color(ChatColor.DARK_GRAY)
            .append("Basics").color(ChatColor.DARK_AQUA)
            .append("]").color(ChatColor.DARK_GRAY)
            .create();

    private final List<String> subCmd = Arrays.asList("survival", "creative", "adventure", "spectator");

    private final List<String> aliasCmd = Arrays.asList("s, 0", "c, 1", "a, 2", "s, 3");

    private final List<String> descCmd = Arrays.asList(
            "Survival gamemode",
            "Creative gamemode",
            "Adventure gamemode",
            "Spectator gamemode"
    );

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
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(
                                    ChatColor.DARK_GREEN + "Command: " + ChatColor.AQUA + arg +
                                    ChatColor.DARK_GREEN + "\nDescription: " + ChatColor.AQUA + desc +
                                    ChatColor.DARK_GREEN + "\nUsage: " + ChatColor.AQUA + "gamemode " + sub + "[player]" +
                            ChatColor.DARK_GREEN + "\nAliases: " + ChatColor.AQUA + alias +
                                    "\n\n" + ChatColor.GRAY + "Click to execute.")))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gamemode " + sub))
                    .append("").retain(ComponentBuilder.FormatRetention.NONE).reset();
        }
        return builder.create();
    }
}
