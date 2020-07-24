package pl._matatjahu.heart;

import org.bukkit.plugin.java.JavaPlugin;
import pl._matatjahu.heart.listeners.*;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        registerListeners();
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);
    }
}
