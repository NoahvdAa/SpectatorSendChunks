package me.noahvdaa.spectatorsendchunks;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpectatorSendChunks extends JavaPlugin {

  @Override
  public void onEnable() {
    this.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
      for (Player player : this.getServer().getOnlinePlayers()) {
        Entity camera = player.getSpectatorTarget();
        if (camera == null) continue;

        player.setSpectatorTarget(null);
        player.setSpectatorTarget(camera);
      }
    }, 5L, 5L);
  }

}
