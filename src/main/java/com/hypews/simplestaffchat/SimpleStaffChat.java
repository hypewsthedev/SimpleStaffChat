package com.hypews.simplestaffchat;

import com.hypews.simplestaffchat.Commands.Channels.ChannelAdmin;
import com.hypews.simplestaffchat.Commands.Channels.ChannelSpare;
import com.hypews.simplestaffchat.Commands.Channels.ChannelStaff;
import com.hypews.simplestaffchat.Commands.CommandSimpleStaffChat;
import com.hypews.simplestaffchat.Utils.UtilLogger;
import com.hypews.simplestaffchat.Utils.UtilSettings;
import com.hypews.simplestaffchat.Utils.UtilUpdateChecker;
import jdk.incubator.jpackage.main.Main;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleStaffChat extends JavaPlugin {
    private static Plugin instance;
    public static SimpleStaffChat plugin;
    Server server = getServer();

    @Override
    public void onEnable() {
        instance = this;
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Start update checking
        // Update checker
        new UtilUpdateChecker(this, 87881).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                UtilLogger.log(UtilLogger.LogLevel.SUCCESS, ("OnePlayerSleep is up to date!"));
            } else {
                UtilLogger.log(UtilLogger.LogLevel.OUTLINE, "*********************************************************************");
                UtilLogger.log(UtilLogger.LogLevel.WARNING, ("SimpleStaffChat is outdated!"));
                UtilLogger.log(UtilLogger.LogLevel.WARNING, ("Newest version: " + version));
                UtilLogger.log(UtilLogger.LogLevel.WARNING, ("Your version: " + UtilSettings.VERSION));
                UtilLogger.log(UtilLogger.LogLevel.WARNING, ("Please Update Here: " + UtilSettings.PLUGIN_URL));
                UtilLogger.log(UtilLogger.LogLevel.OUTLINE, "*********************************************************************");
            }
        });
        // End update checker


        // Start commands
        // StaffChat Command
        getCommand("staffchatadmin").setExecutor(new CommandSimpleStaffChat());
        // Staff Channel
        getCommand("sc").setExecutor(new ChannelStaff());
        getCommand("ac").setExecutor(new ChannelAdmin());
        getCommand("oc").setExecutor(new ChannelSpare());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
