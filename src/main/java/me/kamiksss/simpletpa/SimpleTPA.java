package me.kamiksss.simpletpa;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.kamiksss.simpletpa.commands.tpaCommand;
import me.kamiksss.simpletpa.commands.tpacceptCommand;
import me.kamiksss.simpletpa.commands.tpadenyCommand;

public final class SimpleTPA extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getLogger().info("SimpleTPA has been enabled successfully");

        getCommand("tpa").setExecutor(new tpaCommand());
        getCommand("tpaccept").setExecutor(new tpacceptCommand());
        getCommand("tpadeny").setExecutor(new tpadenyCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("SimpleTPA has been disabled");
    }

}
