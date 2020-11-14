package com.github.matt4499.monesleep;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static JavaPlugin plugin;
	public void onEnable() {
		plugin = this;
		Bukkit.getServer().getConsoleSender().sendMessage("Thanks for using mOneSleep!");
		
		Bukkit.getServer().getPluginManager().registerEvents(new BedEnterListener(), this);
	}

}
