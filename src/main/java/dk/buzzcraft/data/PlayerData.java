package dk.buzzcraft.data;

public class PlayerData {
    private int snusTaken;
    private int snusHealth;
    private boolean showScoreboard;

    public void incrementSnusTaken() {
        snusTaken += snusTaken;
    }
    public int getSnusTaken() {
        return snusTaken;
    }

    public boolean isShowScoreboard() {
        return showScoreboard;
    }

    public void setShowScoreboard(boolean showScoreboard) {
        this.showScoreboard = showScoreboard;
    }

    public void setSnusTaken(int snusTaken) {
        this.snusTaken = snusTaken;
    }

    public int getSnusHealth() {
        return snusHealth;
    }

    public void setSnusHealth(int snusHealth) {
        this.snusHealth = snusHealth;
    }
}
