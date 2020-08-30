package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.command.GamemodeCmd;
import com.gmail.perhapsitisyeazz.yeasybasics.command.HealCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gamemode").setExecutor(new GamemodeCmd());
        this.getCommand("heal").setExecutor(new HealCmd());
    }

    @Override
    public void onDisable() {}
}
