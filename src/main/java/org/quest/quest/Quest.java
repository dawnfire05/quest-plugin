package org.quest.quest;

import org.bukkit.plugin.java.JavaPlugin;

public final class Quest extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Quest Plugin has been enabled!");
        getCommand("quest").setExecutor(new QuestCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Quest Plugin has been disabled.");
    }
}
