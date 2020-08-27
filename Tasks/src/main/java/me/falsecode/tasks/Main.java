package me.falsecode.tasks;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;

public class Main extends JavaPlugin {

    String Time = this.getConfig().getString("Schedule.Diamonds.Delay");
    int TimeS = Integer.parseInt(Time);
    int TimeT = TimeS * 20;
    //int PLEASE = TimeT - 1200;

    //String BM = this.getConfig().getString("Schedule.Diamonds.1MinTime").replace("&", "§");
    Long LDIA= new Long(TimeT);
    String TimeOff = this.getConfig().getString("Schedule.Diamonds.Offset");
    int TimeOffS = Integer.parseInt(TimeOff);
    int TimeOffT = TimeOffS * 20;
    Long LMAO= new Long(TimeOffT);
    String TimeA = this.getConfig().getString("Schedule.Announcement.Delay");
    int TimeAS = Integer.parseInt(TimeA);
    int TimeAT = TimeAS * 20;
    Long LDIAA= new Long(TimeAT);
    String TimeAOff = this.getConfig().getString("Schedule.Announcement.Offset");
    int TimeAOffS = Integer.parseInt(TimeAOff);
    int TimeAOffT = TimeAOffS * 20;
    Long LMAAO= new Long(TimeAOffT);
    String Announcement = this.getConfig().getString("Schedule.Announcement.Message").replace("&", "§");
    String DD = this.getConfig().getString("Schedule.Diamonds.DiamondDrop").replace("&", "§");
    //Long PLEEASE = new Long(PLEASE);
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

        public void run() {
            Bukkit.broadcastMessage(DD);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon Item -50 64 50 {Item:{id:\"diamond\",Count:1b}}");


        }}, LMAO, LDIA);
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

        public void run() {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (!player.hasPermission("has.donated")) {
                    player.sendMessage(Announcement);
                }
            }
        }
        }, LMAAO, LDIAA);
    /*Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
        public void run() {
            Bukkit.broadcastMessage(BM);
        }
    }, PLEEASE, LDIA);*/
    }
}
