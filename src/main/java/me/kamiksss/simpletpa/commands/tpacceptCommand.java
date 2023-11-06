package me.kamiksss.simpletpa.commands;

import me.kamiksss.simpletpa.Hash;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tpacceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender || commandSender instanceof BlockCommandSender) {
            Bukkit.getLogger().warning("This command is only for Players.");
            return true;

        } else {
            Player target = (Player) commandSender;
            if (Hash.containsKey(target)) {
                Player player = Hash.get(target);
                target.sendMessage( ChatColor.GRAY + "Teleporting..");
                player.teleport(target);
                Hash.remove(target);
                player.sendMessage(ChatColor.GREEN + "You have been teleported to " + target.getName());
            } else {
                target.sendMessage(ChatColor.RED + "You don't have any teleport requests");
            }
            return true;
        }


    }
}