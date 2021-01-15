package com.hypews.simplestaffchat.Utils;

import com.hypews.simplestaffchat.SimpleStaffChat;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.scanner.ScannerImpl;

public class UtilUtilities {

    public static void announce(String s) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void msg(Player p, String s) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void msg(CommandSender cs, String s) {
        cs.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }}
