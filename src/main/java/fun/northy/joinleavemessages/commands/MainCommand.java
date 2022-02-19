package fun.northy.joinleavemessages.commands;

import fun.northy.joinleavemessages.configs.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static fun.northy.joinleavemessages.utils.util.color;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission(ConfigManager.getConfig().getString("permissions.reload"))) {
            if (args.length == 1 && args[0].equals("reload")) {
                ConfigManager.get().create();
                sender.sendMessage(color(ConfigManager.getConfig().getString("messages.reloaded")));
            } else {
                sender.sendMessage(color(ConfigManager.getConfig().getString("messages.mainCommand.correctUsage")));
            }
        } else {
            sender.sendMessage(color(ConfigManager.getConfig().getString("messages.nopermission")));
        }
        return false;
    }
}
