package tk.pluginmaker.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.pluginmaker.Core;

public class PluginMaker implements CommandExecutor {

    Core plugin;

    public PluginMaker(Core instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            // TODO: Handle restricted Console usage;
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("plmaker.make")) {
            if(cmd.getLabel().equalsIgnoreCase("makepl")) {
                if(args.length == 0) {
                    p.sendMessage(plugin.prefix + ChatColor.GRAY + "Error; Please follow syntax. Syntax information: " + ChatColor.GOLD + plugin.website);
                    return true;
                } else {
                    String command = args[0];
                    String command2 = args[1];

                    /*
                    Null checks:
                     */
                    if(command == null) return true;
                    if(command2 == null) return true;

                    /*
                    Print a message;
                     */
                    String print = ChatColor.translateAlternateColorCodes('&', command2);

                    if(command.equalsIgnoreCase("print")) {
                        p.sendMessage(print);
                        return true;
                    }

                    /*
                    Broadcast a message;
                     */
                    if(command.equalsIgnoreCase("broadcast")) {
                        String text = "";
                        for (int i = 0; i < args.length; i++) {
                            text += args[i].replace(command, "") + " ";
                        }

                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', text));
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
