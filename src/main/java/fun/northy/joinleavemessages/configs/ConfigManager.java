package fun.northy.joinleavemessages.configs;

import fun.northy.joinleavemessages.general.JoinLeaveMessages;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {
    private static ConfigManager configManager;
    private static YamlConfiguration config;
    private File file;
    private File configFile;

    private ConfigManager() {
        this.file = JoinLeaveMessages.getPlugin().getDataFolder();
        this.configFile = new File(this.file, "config.yml");
        ConfigManager.configManager = this;
    }

    public void create() {
        if (!this.file.exists()) {
            this.file.mkdir();
        }
        if (!this.configFile.exists()) {
            JoinLeaveMessages.getPlugin().saveResource("config.yml", true);
        }
        ConfigManager.config = YamlConfiguration.loadConfiguration(this.configFile);
    }

    public static ConfigManager get() {
        return (ConfigManager.configManager == null) ? new ConfigManager() : ConfigManager.configManager;
    }

    public static YamlConfiguration getConfig() {
        return ConfigManager.config;
    }
}
