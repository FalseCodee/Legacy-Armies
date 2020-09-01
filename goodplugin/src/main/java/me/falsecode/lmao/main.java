package me.falsecode.lmao;

import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;


public class main extends JavaPlugin implements CommandExecutor {

    final Map<Player, Player> people = Maps.newHashMap();


    @Override
    public void onEnable() {
        this.getCommand("sex").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = null;
        if (sender instanceof Player) {
            p = (Player) sender;
        }
        if(args.length == 0){
            p.sendMessage(	"§c /sex <accept/deny/%player%>");
            return true;
        }
        if(args[0].equalsIgnoreCase("accept")){
            if (people.containsKey(sender)){
                Player send = people.get(p);
                people.remove(p);
                if (!(p == send)) {
                    Bukkit.broadcastMessage("§c" + p.getName() + " and " + send.getName() + " just had sex!");
                } else{
                    p.sendMessage("§cYou just fucked yourself.. nice.");
                }
            } else {
                sender.sendMessage("§cYou do not have any current sex requests!");
            }
        } else if(args[0].equalsIgnoreCase("deny")){
            if (people.containsKey(p)){
                Player send = people.get(p);
                people.remove(p);

                send.sendMessage("§c" + p.getName() + " denied your sex request...");
                p.sendMessage("§cYou have denied " + send.getName() + "'s sex request.");
            } else{
                sender.sendMessage("§cYou do not have any current sex requests!");
            }
        } else{
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if(target != null){
                people.put(target, p);
                p.sendMessage("§aSent sex request to " + target.getName());
                target.sendMessage("§a" + p.getName() + " sent you a sex request! do /sex accept to have sex! Or do /sex deny to not have sex.");
            } else{
                sender.sendMessage("§c Player is not online.");
            }
        }
        return true;
    }
}
