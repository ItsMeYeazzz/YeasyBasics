package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.command.*;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gamemode").setExecutor(new GamemodeCmd());
        this.getCommand("heal").setExecutor(new HealCmd());
        this.getCommand("speed").setExecutor(new SpeedCmd());
        this.getCommand("time").setExecutor(new TimeCmd());
        this.getCommand("invsee").setExecutor(new InvSeeCmd());
    }

    @Override
    public void onDisable() {
    }
}
