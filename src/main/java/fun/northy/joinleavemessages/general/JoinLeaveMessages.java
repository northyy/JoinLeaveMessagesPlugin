package fun.northy.joinleavemessages.general;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static fun.northy.joinleavemessages.utils.util.color;

public final class JoinLeaveMessages extends JavaPlugin {
    private static JoinLeaveMessages instance;
    private static JoinLeaveMessages plugin;
    public static JoinLeaveMessages getInstance() {
        return instance;
    }
    public static JoinLeaveMessages getPlugin() {
        return plugin;
    }
    public JoinLeaveMessages() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Load.configs();
            Load.events();
            Load.commands();
        } else {
            Bukkit.getConsoleSender().sendMessage(color("&cNie wykryto pluginu PlaceholderAPI, ktory jest wymagany do dzialania pluginu JoinLeaveMessages!"));
            this.getPluginLoader().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
    }
}
