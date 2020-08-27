package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.command.GamemodeCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gamemode").setExecutor(new GamemodeCmd());
    }

    @Override
    public void onDisable() {}
}
