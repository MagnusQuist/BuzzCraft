package dk.buzzcraft.commands.subcommands;

import dk.buzzcraft.commands.SubCommand;
import dk.buzzcraft.data.PlayerData;
import dk.buzzcraft.utils.PlayerDataUtility;
import org.bukkit.entity.Player;

public class ScoreboardCommand extends SubCommand {
    @Override
    public String getName() {
        return "scoreboard";
    }

    @Override
    public String getDescription() {
        return "Toggle scoreboard";
    }

    @Override
    public String getSyntax() {
        return "/snus scoreboard";
    }

    @Override
    public void perform(Player player, String[] args) {
        PlayerData data = PlayerDataUtility.loadPlayerData(player);
        data.setShowScoreboard(!data.isShowScoreboard());
        PlayerDataUtility.savePlayerData(player, data);
    }
}
