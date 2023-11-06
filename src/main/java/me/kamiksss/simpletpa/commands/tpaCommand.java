package me.kamiksss.simpletpa.commands;

import me.kamiksss.simpletpa.Hash;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class tpaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s,
            @NotNull String[] strings) {

        if (commandSender instanceof ConsoleCommandSender || commandSender instanceof BlockCommandSender) {
            Bukkit.getLogger().info("This command is for player only");
            return true;
        } else {
            Player player = (Player) commandSender;
            if (strings.length != 1) {
                return false;
            } else {

                Player target = Bukkit.getPlayer(strings[0]);

                if (target == player) {
                    player.sendMessage(ChatColor.RED + "You cannot teleport to yourself!");
                } else {

                    Hash.put(target, player);

                    player.sendMessage(
                            ChatColor.GRAY + "You have sent teleport request to " + ChatColor.GOLD + target.getName());
                    TextComponent accept = new TextComponent("ACCEPT ");
                    accept.setColor(net.md_5.bungee.api.ChatColor.GREEN);
                    accept.setBold(true);
                    accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));

                    TextComponent deny = new TextComponent(" DECLINE");
                    deny.setColor(net.md_5.bungee.api.ChatColor.RED);
                    deny.setBold(true);
                    deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpadeny"));
                    target.sendMessage(ChatColor.GRAY
                            + "You have received teleport request from " + ChatColor.GOLD + player.getName()
                            + ChatColor.GRAY + "! Click to answer: "/*
                                                                     * " type " +ChatColor.GREEN + message +
                                                                     * ChatColor.GRAY + "or " + ChatColor.RED +
                                                                     * "/tpadeny"
                                                                     */ );
                    target.spigot().sendMessage(accept, deny);
                    accept.setClickEvent(null);
                    deny.setClickEvent(null);

                }
                return true;
            }
        }
    }
}
