package fun.northy.joinleavemessages.general;

import fun.northy.joinleavemessages.commands.MainCommand;
import fun.northy.joinleavemessages.configs.ConfigManager;
import fun.northy.joinleavemessages.events.PlayerJoinHandler;
import fun.northy.joinleavemessages.events.PlayerQuitHandler;
import org.bukkit.Bukkit;

import static fun.northy.joinleavemessages.utils.util.color;

public class Load {
    public static void configs() {
        ConfigManager.get().create();
        Bukkit.getConsoleSender().sendMessage(color("&aZaladowano konfiguracje!"));
    }
    public static void events() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinHandler(), JoinLeaveMessages.getPlugin());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuitHandler(), JoinLeaveMessages.getPlugin());
        Bukkit.getConsoleSender().sendMessage(color("&aZaladowano eventy!"));
    }
    public static void commands() {
        JoinLeaveMessages.getPlugin().getCommand("jlm").setExecutor(new MainCommand());
        Bukkit.getConsoleSender().sendMessage(color("&aZaladowano komendy!"));
    }
}
