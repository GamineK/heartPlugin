package pl._matatjahu.heart;

import org.bukkit.plugin.java.JavaPlugin;
import pl._matatjahu.heart.configuration.Configuration;
import pl._matatjahu.heart.listeners.*;

public class Main extends JavaPlugin {
    private static Main instance;
    private Configuration config;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        config = new Configuration();
        config.loadConfiguration();
        registerListeners();
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);
    }

    public static Main getInstance() {
        return instance;
    }

    public Configuration getConfiguration() {
        return config;
    }
}
