// Event wejscia gracza na serwer

package fun.northy.joinleavemessages.events;

import fun.northy.joinleavemessages.configs.ConfigManager;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static fun.northy.joinleavemessages.utils.util.color;

public class PlayerJoinHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(ConfigManager.getConfig().getBoolean("joinMessage.enabled")) {
            if(ConfigManager.getConfig().getBoolean("joinMessage.custom")) {
                e.setJoinMessage(null);
                Bukkit.getServer().broadcastMessage(color(PlaceholderAPI.setPlaceholders(p, ConfigManager.getConfig().getString("joinMessage.customMessage"))));
            } else {
                return;
            }
        } else {
            e.setJoinMessage(null);
        }
    }
}
