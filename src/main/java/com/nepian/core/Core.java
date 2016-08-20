package com.nepian.core;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		enableMessage();
	}
	
	private void enableMessage() {
		String v = this.getDescription().getVersion();
		Messenger mes = new Messenger(this);
		
		mes.log("&d----------------------------------------------");
		mes.log("&d Enabling Core version " + v );
		mes.log("&d----------------------------------------------");
	}
}
