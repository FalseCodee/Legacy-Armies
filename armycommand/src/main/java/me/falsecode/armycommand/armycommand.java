package me.falsecode.armycommand;

import org.bukkit.plugin.java.JavaPlugin;

public class armycommand extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        new commandpart(this);
    }
}
