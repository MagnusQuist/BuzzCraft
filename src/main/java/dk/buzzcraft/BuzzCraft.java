package dk.buzzcraft;

import dk.buzzcraft.commands.CommandManager;
import dk.buzzcraft.events.GeneralEvents;
import dk.buzzcraft.scoreboard.Board;
import dk.buzzcraft.utils.PlayerDataUtility;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import java.util.logging.Logger;

public final class BuzzCraft extends JavaPlugin {
    private final Logger logger = getLogger();
    private static BuzzCraft plugin;
    private BukkitTask boardTask;

    @Override
    public void onEnable() {
        plugin = this;
        // Save the default config.yml
        this.saveDefaultConfig();
        PlayerDataUtility.initialize(getDataFolder());

        // Show Ascii Title
        logger.info("   ____                 _____            __ _");
        logger.info("  |  _ \\               / ____|          / _| |");
        logger.info("  | |_) |_   _ _______| |     _ __ __ _| |_| |_");
        logger.info("  |  _ <| | | |_  /_  / |    | '__/ _` |  _| __|");
        logger.info("  | |_) | |_| |/ / / /| |____| | | (_| | | | |_");
        logger.info("  |____/ \\__,_/___/___|\\_____|_|  \\__,_|_|  \\__|");

        // Register event listeners
        getServer().getPluginManager().registerEvents(new GeneralEvents(), this);

        // Register commands
        getCommand("snus").setExecutor(new CommandManager());

        // Register tasks
        boardTask = getServer().getScheduler().runTaskTimer(this, Board.getInstance(), 0, 20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (boardTask != null && !boardTask.isCancelled()) {
            boardTask.cancel();
        }
    }

    public static BuzzCraft getPlugin() {
        return plugin;
    }
}
