package pl._matatjahu.heart.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl._matatjahu.heart.Main;
import pl._matatjahu.heart.utils.ChatUtil;

public class EntityDamageByEntityListener implements Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity().getType().equals(EntityType.PLAYER)) {
            if (event.getDamager().getType().equals(EntityType.ARROW) || event.getDamager().getType().equals(EntityType.SNOWBALL)) {
                Player player = (Player) event.getEntity();
                Arrow arrow = null;
                if (event.getDamager().getType().equals(EntityType.ARROW)) {
                    arrow = (Arrow) event.getDamager();
                }
                if (arrow != null && arrow.getShooter() instanceof Player) {
                    ChatUtil.sendMessage((Player)arrow.getShooter(), Main.getInstance().getConfiguration().getMessageBow().replace("{PLAYER}", player.getName()).replace("{HEALTH}", Math.floor(((player.getHealth() - event.getFinalDamage())/ 2)) + ""));
                    return;
                }
                Snowball snowball = (Snowball) event.getDamager();
                if (snowball != null && snowball.getShooter() instanceof Player) {
                    ChatUtil.sendMessage((Player)snowball.getShooter(), Main.getInstance().getConfiguration().getMessageSnowball().replace("{PLAYER}", player.getName()).replace("{HEALTH}", Math.floor((player.getHealth() / 2)) + ""));
                }
            }
        }
    }
}
