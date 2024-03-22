package dk.buzzcraft.utils;

import dk.buzzcraft.BuzzCraft;
import dk.buzzcraft.data.PlayerData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataUtility {
    private static File dataFolder;
    private static FileConfiguration settings;

    public static void initialize(File pluginDataFolder) {
        settings = BuzzCraft.getPlugin().getConfig();
        dataFolder = new File(pluginDataFolder, "playerdata");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
    }

    public static void savePlayerData(Player player, PlayerData data) {
        File playerFile = new File(dataFolder, player.getUniqueId() + ".yml");
        if (!playerFile.exists()) {
            try {
                playerFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
        config.set("snusTaken", data.getSnusTaken());
        config.set("snusHealth", data.getSnusTaken());
        config.set("showScoreboard", data.isShowScoreboard());

        try {
            config.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PlayerData loadPlayerData(Player player) {
        File playerFile = new File(dataFolder, player.getUniqueId() + ".yml");
        if (!playerFile.exists()) {
            return new PlayerData();
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
        // Map config to data file object
        int snusTaken = config.getInt("snusTaken");
        int snusHealth = config.getInt("snusHealth");
        boolean showScoreboard = config.getBoolean("showScoreboard");

        PlayerData data = new PlayerData();
        data.setSnusTaken(snusTaken);
        data.setSnusHealth(snusHealth);
        data.setShowScoreboard(showScoreboard);

        return data;
    }

    public static void createPlayerDataFile(Player player) {
        File playerDataFile = new File(dataFolder, player.getUniqueId() + ".yml");
        if (!playerDataFile.exists()) {
            PlayerData playerData = new PlayerData();
            YamlConfiguration config = new YamlConfiguration();
            config.set("snusTaken", playerData.getSnusTaken());
            config.set("snusHealth", settings.getInt("defaultSnusHealthValue"));
            config.set("showScoreboard", settings.getBoolean("showScoreboard"));
            try {
                playerDataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
