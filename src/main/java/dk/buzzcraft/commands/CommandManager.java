package dk.buzzcraft.commands;

import dk.buzzcraft.commands.subcommands.ScoreboardCommand;
import dk.buzzcraft.commands.subcommands.StatsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class CommandManager implements CommandExecutor {
    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager() {
        subcommands.add(new StatsCommand());
        subcommands.add(new ScoreboardCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0) {
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            } else {
                p.sendMessage(ChatColor.DARK_GRAY + "--------------------------------");
                for (int i = 0; i < getSubcommands().size(); i++) {
                    p.sendMessage(ChatColor.LIGHT_PURPLE + getSubcommands().get(i).getSyntax() + ChatColor.GRAY + " - " + getSubcommands().get(i).getDescription());
                }
                p.sendMessage(ChatColor.DARK_GRAY + "--------------------------------");
            }

        }

        return true;
    }

    public ArrayList<SubCommand> getSubcommands(){
        return subcommands;
    }

}
