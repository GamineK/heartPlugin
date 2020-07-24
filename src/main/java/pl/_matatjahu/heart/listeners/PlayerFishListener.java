package pl._matatjahu.heart.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import pl._matatjahu.heart.utils.ChatUtil;

public class PlayerFishListener implements Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (event.getCaught != null && event.getCaught().getType().equals(EntityType.PLAYER)) {
            Player playerTo = (Player)event.getCaught();
            if (playerTo != null) {
                ChatUtil.sendMessage(player, "&8*** &6" + playerTo.getName() + " &Eposiada: &6" + Math.floor((playerTo.getHealth() / 2)) + "HP");
            }
        }
    }
}
