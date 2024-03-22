package dk.buzzcraft.commands.subcommands;

import dk.buzzcraft.commands.SubCommand;
import org.bukkit.entity.Player;

public class StatsCommand extends SubCommand {

    @Override
    public String getName() {
        return "stats";
    }

    @Override
    public String getDescription() {
        return "Show stats";
    }

    @Override
    public String getSyntax() {
        return "/snus stats";
    }

    @Override
    public void perform(Player player, String[] args) {
        player.sendMessage("Stats not implemented!");
    }
}
