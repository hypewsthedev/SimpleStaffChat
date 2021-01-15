package com.hypews.simplestaffchat.Utils;

import com.hypews.simplestaffchat.SimpleStaffChat;
import org.bukkit.plugin.Plugin;

public class UtilMessages {
    static Plugin plugin = SimpleStaffChat.getPlugin(SimpleStaffChat.class);
    static String prefix1 = plugin.getConfig().getString("prefix") + " ";
    public static String PREFIX = prefix1;
    public static String NO_PERMS = plugin.getConfig().getString("messageNoPerms");

}
