package fun.northy.joinleavemessages.events;

import fun.northy.joinleavemessages.configs.ConfigManager;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static fun.northy.joinleavemessages.utils.util.color;

public class PlayerQuitHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(ConfigManager.getConfig().getBoolean("leaveMessage.enabled")) {
            if(ConfigManager.getConfig().getBoolean("leaveMessage.custom")) {
                e.setQuitMessage(null);
                Bukkit.getServer().broadcastMessage(color(PlaceholderAPI.setPlaceholders(p, ConfigManager.getConfig().getString("leaveMessage.customMessage"))));
            } else {
                return;
            }
        } else {
            e.setQuitMessage(null);
        }
    }
}
