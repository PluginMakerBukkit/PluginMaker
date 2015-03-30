package tk.pluginmaker;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import tk.pluginmaker.commands.Info;
import tk.pluginmaker.commands.PluginMaker;


public class Core extends JavaPlugin {
    /*
         MAIN CLASS;
         ~ Registering Events and Commands
         ~ Main methods
    */

    // TODO: Remember to change these values!
    public String prefix;
    public String website;
    public String version;
    public String author;

    @Override
    public void onEnable() {
        registry();

        /*
        Defining Plugin information;
         */
        prefix = ChatColor.GOLD + "[" + ChatColor.GREEN + "PluginMaker" + ChatColor.GOLD + "] ";
        author = "Mr_Black_Is_Back";
        website = "N / A";
        version = "0.0.1DEV";
    }

    @Override
    public void onDisable() {

    }

    // Registering any commands / events.
    public void registry() {
        getCommand("plmaker").setExecutor(new Info(this));
        getCommand("makepl").setExecutor(new PluginMaker(this));
    }

}
