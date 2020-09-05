package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.command.GamemodeCmd;
import com.gmail.perhapsitisyeazz.yeasybasics.command.HealCmd;
import com.gmail.perhapsitisyeazz.yeasybasics.command.SpeedCmd;
import com.gmail.perhapsitisyeazz.yeasybasics.command.TimeCmd;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand gmCmd = this.getCommand("gamemode"),
                healCmd = this.getCommand("heal") ,
                speedCmd = this.getCommand("speed"),
                timeCmd = this.getCommand("time");
        if(gmCmd != null && healCmd != null && speedCmd != null && timeCmd != null) {
            gmCmd.setExecutor(new GamemodeCmd());
            healCmd.setExecutor(new HealCmd());
            speedCmd.setExecutor(new SpeedCmd());
            timeCmd.setExecutor(new TimeCmd());
        }
    }

    @Override
    public void onDisable() {}
}
