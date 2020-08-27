package me.falsecode.armycommand;

import com.gmail.nossr50.datatypes.party.Party;
import com.gmail.nossr50.party.PartyManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.util.List;

public class commandpart implements CommandExecutor {
    private armycommand plugin;

    public commandpart(armycommand plugin){
        this.plugin = plugin;
        plugin.getCommand("army").setExecutor(this);
        plugin.getCommand("armys").setExecutor(this);
        plugin.getCommand("armies").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        List L = PartyManager.getParties();
        Party[] myArray = new Party[L.size()];
        L.toArray(myArray);
        int[] partyLevel = new int[L.size()];
        for(int i=0; i < myArray.length; i++){
            partyLevel[i] = myArray[i].getLevel();
        }
        Party temp;
        for (int i = 1; i < myArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (myArray[j].getLevel() < myArray[j - 1].getLevel()) {
                    temp = myArray[j];
                    myArray[j] = myArray[j - 1];
                    myArray[j - 1] = temp;
                }
            }
        }
        int e = 0;

        if(L.size() != 0){
            for(int i=myArray.length-1;i>=0;i--){
                e++;
                sender.sendMessage(plugin.getConfig().getString("Message").replace("%num%",String.valueOf(e)).replace("%army%",myArray[i].getName()).replace("%lvl%",String.valueOf(myArray[i].getLevel())).replace("%leader%",myArray[i].getLeader().getPlayerName()).replace("&", "§"));

            }
        }else{
            sender.sendMessage("There are no parties.");
        }
        return true;
    }
}
