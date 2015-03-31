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
                        for (String arg : args) {
                            text += arg.replace(command, "") + " ";
                        }

                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', text));
                        return true;
                    }

                    /*
                    Set a players health:
                   TODO: Bug #1. Error when not following syntax.
                     */
                    if(command.equalsIgnoreCase("sethealth")) {
                        Player t = Bukkit.getServer().getPlayer(command2);

                        if(t != null) {
                            if(args[2] != null) {
                                int health = Integer.parseInt(args[2]);
                                if(health > 20) return true;
                                p.sendMessage(plugin.prefix + ChatColor.GOLD + "Set players health to: " + health);
                                t.setHealth(health);
                                return true;
                            } else {
                                p.sendMessage(plugin.prefix + ChatColor.RED + "Error, Please read Plugin syntax! " + plugin.website);
                                return true;
                            }
                        } else {
                            p.sendMessage(plugin.prefix + ChatColor.RED + "Error, Please read Plugin syntax! " + plugin.website);
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
