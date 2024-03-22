package dk.buzzcraft.events;

import dk.buzzcraft.utils.PlayerDataUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GeneralEvents implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerDataUtility.createPlayerDataFile(player);
    }
}
