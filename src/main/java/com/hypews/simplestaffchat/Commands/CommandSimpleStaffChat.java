package com.hypews.simplestaffchat.Commands;

import com.hypews.simplestaffchat.SimpleStaffChat;
import com.hypews.simplestaffchat.Utils.UtilMessages;
import com.hypews.simplestaffchat.Utils.UtilUtilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandSimpleStaffChat implements CommandExecutor {
    Plugin plugin = SimpleStaffChat.getPlugin(SimpleStaffChat.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!player.hasPermission("staffchat.reload")) {
                    UtilUtilities.msg(player, UtilMessages.NO_PERMS);
                    return true;
                }
                plugin.reloadConfig();
                UtilUtilities.msg(player, "&aReloaded all configs");
                return true;
            } else if (args[0].equalsIgnoreCase("help")) {
                UtilUtilities.msg(player, "&3SimpleStaffChat Help");
                UtilUtilities.msg(player, "&b/staffchatadmin &7- &bRoot StaffChatAdmin command");
                UtilUtilities.msg(player, "&b/staffchatadmin reload &7- &bReloads all the config files");
                UtilUtilities.msg(player, "&b/staffchatadmin help &7- &bView this");
                UtilUtilities.msg(player, "&b/sc &7- &bThe staff chat channel");
                UtilUtilities.msg(player, "&b/ac &7- &bThe admin chat channel");
                UtilUtilities.msg(player, "&b/oc &7- &bThe other / spare chat channel");
                return true;
            }
            return true;
        }
        if (args.length == 0) {
            UtilUtilities.msg(player, "&3SimpleStaffChat Help");
            UtilUtilities.msg(player, "&b/staffchatadmin &7- &bRoot StaffChatAdmin command");
            UtilUtilities.msg(player, "&b/staffchatadmin reload &7- &bReloads all the config files");
            UtilUtilities.msg(player, "&b/staffchatadmin help &7- &bView this");
            UtilUtilities.msg(player, "&b/sc &7- &bThe staff chat channel");
            UtilUtilities.msg(player, "&b/ac &7- &bThe admin chat channel");
            UtilUtilities.msg(player, "&b/oc &7- &bThe other / spare chat channel");
        }
        return true;

    }
}
