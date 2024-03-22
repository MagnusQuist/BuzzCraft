package dk.buzzcraft.scoreboard;

import dk.buzzcraft.data.PlayerData;
import dk.buzzcraft.utils.PlayerDataUtility;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Board implements Runnable {
    private final static Board instance = new Board();

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerData data = PlayerDataUtility.loadPlayerData(player);
            if (data.isShowScoreboard()) {
                if (player.getScoreboard() != null && player.getScoreboard().getObjective("BuzzCraft") != null) {
                    updateScoreboard(player);
                } else {
                    createNewScoreboard(player);
                }
            } else {
                player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
            }
        }
    }

    private void createNewScoreboard(Player player) {
        PlayerData data = PlayerDataUtility.loadPlayerData(player);
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("BuzzCraft", "dummy", ChatColor.AQUA + "" + ChatColor.BOLD+ "BuzzCraft");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(ChatColor.WHITE + " ").setScore(8);
        objective.getScore(ChatColor.WHITE + " ").setScore(5);
        objective.getScore(ChatColor.AQUA + "Buffs").setScore(4);
        objective.getScore(ChatColor.WHITE + "Strength II").setScore(3);
        objective.getScore(ChatColor.WHITE + " ").setScore(2);

        // Snus Taken
        Team snusTaken = scoreboard.registerNewTeam("snusTaken");
        // Needs to be unique in the scoreboard
        String snusTakenTeamKey = ChatColor.GOLD.toString();

        snusTaken.addEntry(snusTakenTeamKey);
        snusTaken.setPrefix("Snus taken: ");
        // this should be the players snus count from playerdata
        snusTaken.setSuffix(ChatColor.YELLOW + "" + data.getSnusTaken());

        objective.getScore(snusTakenTeamKey).setScore(7);

        // Snus Health
        Team snusHealth = scoreboard.registerNewTeam("snusHealth");
        // Needs to be unique in the scoreboard
        String snusHealthTeamKey = ChatColor.GREEN.toString();

        snusTaken.addEntry(snusHealthTeamKey);
        snusTaken.setPrefix("Snus health: ");
        // this should be the players snus count from playerdata
        snusTaken.setSuffix(ChatColor.LIGHT_PURPLE + "" + data.getSnusHealth());

        objective.getScore(snusHealthTeamKey).setScore(6);
        player.setScoreboard(scoreboard);
    }

    private void updateScoreboard(Player player) {
        PlayerData data = PlayerDataUtility.loadPlayerData(player);
        Scoreboard scoreboard = player.getScoreboard();
        Team snusTaken = scoreboard.getTeam("snusTaken");
        snusTaken.setSuffix(ChatColor.YELLOW + "" + (data.getSnusTaken()));
    }
    public static Board getInstance() {
        return instance;
    }
}
