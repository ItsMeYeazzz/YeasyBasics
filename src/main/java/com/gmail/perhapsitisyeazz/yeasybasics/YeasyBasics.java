package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.command.GamemodeCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    private static YeasyBasics instance;

    public static YeasyBasics getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("gamemode").setExecutor(new GamemodeCmd(this));
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
