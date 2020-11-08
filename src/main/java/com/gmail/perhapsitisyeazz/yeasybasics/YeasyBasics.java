package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.commands.*;
import com.gmail.perhapsitisyeazz.yeasybasics.listeners.CastSpellEvent;
import com.gmail.perhapsitisyeazz.yeasybasics.listeners.UtilsEvt;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    private static YeasyBasics instance;

    public static YeasyBasics getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new UtilsEvt(this), this);
        this.getServer().getPluginManager().registerEvents(new CastSpellEvent(this), this);
        this.getCommand("gamemode").setExecutor(new GamemodeCmd());
        this.getCommand("heal").setExecutor(new HealCmd());
        this.getCommand("invsee").setExecutor(new InvSeeCmd());
        this.getCommand("speed").setExecutor(new SpeedCmd());
        this.getCommand("spell").setExecutor(new SpellCommand());
        this.getCommand("time").setExecutor(new TimeCmd());
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
