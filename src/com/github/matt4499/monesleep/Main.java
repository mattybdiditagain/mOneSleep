package com.github.matt4499.monesleep;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static JavaPlugin plugin;
	public static Boolean SkipWeather;
	public void onEnable() {
		plugin = this;
		Bukkit.getServer().getConsoleSender().sendMessage("Thanks for using mOneSleep!");
		Bukkit.getServer().getPluginManager().registerEvents(new BedEnterListener(), this);
		loadConfig();
	}
	private void loadConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
                setSkipWeather();
                getLogger().info("Skip Weather is set to: " + getConfig().getBoolean("skip-weather"));
            } else {
            	setSkipWeather();
                getLogger().info("Config.yml found, loaded!");
                getLogger().info("Skip Weather is set to: " + getConfig().getBoolean("skip-weather"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
	
	private void setSkipWeather() {
		SkipWeather = getConfig().getBoolean("skip-weather");
	}

}
