package com.gmail.perhapsitisyeazz.yeasybasics;

import com.gmail.perhapsitisyeazz.yeasybasics.command.GamemodeCmd;
import com.gmail.perhapsitisyeazz.yeasybasics.command.HealCmd;
import com.gmail.perhapsitisyeazz.yeasybasics.command.SpeedCmd;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class YeasyBasics extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginCommand gmCmd = this.getCommand("gamemode"),
                healCmd = this.getCommand("heal") ,
                speedCmd = this.getCommand("speed");
        if(gmCmd != null && healCmd != null && speedCmd != null) {
            gmCmd.setExecutor(new GamemodeCmd());
            healCmd.setExecutor(new HealCmd());
            speedCmd.setExecutor(new SpeedCmd());
        }
    }

    @Override
    public void onDisable() {}
}
