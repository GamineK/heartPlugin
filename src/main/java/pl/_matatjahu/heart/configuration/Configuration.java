package pl._matatjahu.heart.configuration;

import pl._matatjahu.heart.Main;

public class Configuration {
    private String messageBow, messageSnowball, messageFishingRod;

    public void loadConfiguration() {
        this.messageBow = Main.getInstance().getConfig().getString("messages.bow");
        this.messageSnowball = Main.getInstance().getConfig().getString("messages.snowball");
        this.messageFishingRod = Main.getInstance().getConfig().getString("messages.fishing_rod");
    }

    public String getMessageBow() {
        return messageBow;
    }

    public String getMessageSnowball() {
        return messageSnowball;
    }

    public String getMessageFishingRod() {
        return messageFishingRod;
    }
}
