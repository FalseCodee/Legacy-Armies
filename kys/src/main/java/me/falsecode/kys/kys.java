package me.falsecode.kys;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class kys extends JavaPlugin implements Listener {
    String msg = this.getConfig().getString("message").replace("&", "§");
    List<String> list = this.getConfig().getStringList("banned-words");
    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        for(int i = 0; i < list.size(); i++){
            if(e.getMessage().toLowerCase().contains(list.get(i))){
                Player p = e.getPlayer();
                e.setCancelled(true);
                p.sendMessage(msg);
                p.performCommand("suicide");
                return;
            }
        }
    }
}
