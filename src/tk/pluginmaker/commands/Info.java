package tk.pluginmaker.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.pluginmaker.Core;

public class Info implements CommandExecutor {

    Core plugin;

    public Info(Core instance) {
        plugin = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("plmaker.info")) {
            if(cmd.getName().equalsIgnoreCase("plmaker")) {
                sender.sendMessage(ChatColor.GOLD + "-=========== " + ChatColor.GREEN + "Plugin maker" + ChatColor.GOLD + " ===========-");
                sender.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.BLUE + plugin.version);
                sender.sendMessage(ChatColor.GRAY + "Author[s]: " + ChatColor.BLUE + plugin.author);
                sender.sendMessage(ChatColor.GRAY + "Info: " + ChatColor.BLUE + plugin.website);
                return true;
            }
        }
        return false;
    }
}
