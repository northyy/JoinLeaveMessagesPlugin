// Upraszczanie obslugi kolorow

package fun.northy.joinleavemessages.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class util {
    public static String color(String message) {
        return (message == null) ? "" : ChatColor.translateAlternateColorCodes('&', message);
    }
    public static List<String> color(List<String> message) {
        return message.stream().map(util::color)
                .collect(Collectors.toList());
    }
}
