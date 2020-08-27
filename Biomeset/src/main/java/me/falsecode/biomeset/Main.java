package me.falsecode.biomeset;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new me.falsecode.biomeset.Listener(), this);
    }
}
