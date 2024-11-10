package org.quest.quest;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Quest extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Quest Plugin has been enabled!");
        QuestManager questManager = new QuestManager();
        Objects.requireNonNull(getCommand("quest")).setExecutor(new QuestCommand(questManager));
        getServer().getPluginManager().registerEvents(new QuestListener(questManager), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Quest Plugin has been disabled.");
    }
}
