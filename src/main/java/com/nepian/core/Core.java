package com.nepian.core;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	private static Core core;
	
	@Override
	public void onEnable() {
		core = this;
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Core getCore() {
		return core;
	}
}
