package dk.buzzcraft;

import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class BuzzCraft extends JavaPlugin {
    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        // Save the default config.yml
        saveDefaultConfig();

        // Show Ascii Title
        logger.log(Level.INFO, "  ____                 _____            __ _");
        logger.log(Level.INFO, "  |  _ \\               / ____|          / _| |");
        logger.log(Level.INFO, "  | |_) |_   _ _______| |     _ __ __ _| |_| |_");
        logger.log(Level.INFO, "  |  _ <| | | |_  /_  / |    | '__/ _` |  _| __|");
        logger.log(Level.INFO, "  | |_) | |_| |/ / / /| |____| | | (_| | | | |_");
        logger.log(Level.INFO, "  |____/ \\__,_/___/___|\\_____|_|  \\__,_|_|  \\__|");

        // Register commands

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
