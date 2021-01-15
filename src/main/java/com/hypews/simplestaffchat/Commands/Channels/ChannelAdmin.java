package com.hypews.simplestaffchat.Commands.Channels;

import com.hypews.simplestaffchat.SimpleStaffChat;
import com.hypews.simplestaffchat.Utils.UtilMessages;
import com.hypews.simplestaffchat.Utils.UtilUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ChannelAdmin implements CommandExecutor {
    Plugin plugin = SimpleStaffChat.getPlugin(SimpleStaffChat.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.hasPermission("staffchat.adminchannel")) {
            UtilUtilities.msg(p, UtilMessages.NO_PERMS);
        }
        String message = plugin.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "adminChannelPrefix")) + " " + p.getName() + "&7:&r ";
        for (String s : args) {
            message = message + s + " ";
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("staffchat.adminchannel")) {
                UtilUtilities.msg(player, message);
            }
        }
        return true;
    }
}
