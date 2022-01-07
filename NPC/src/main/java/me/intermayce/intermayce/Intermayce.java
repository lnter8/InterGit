package me.intermayce.intermayce;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Intermayce extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("NPC create plugin launched!");

        this.getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        System.out.println("Anonymous Player joined");
        event.setJoinMessage("Welcome Bozo. HA");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("createnpc")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player player = (Player) sender;
            NPC.createNPC(player);
            player.sendMessage("NPC created");
        }
        return false;
    }
}
