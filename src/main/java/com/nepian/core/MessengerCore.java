package com.nepian.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MessengerCore {
	protected final JavaPlugin PLUGIN;
	protected final String PREFIX;
	protected final boolean DEBUG;
	
	public MessengerCore(JavaPlugin plugin, boolean debug) {
		this.PLUGIN = plugin;
		this.PREFIX = "&d" + plugin.getName() + ":&r";
		this.DEBUG = debug;
	}
	
	public MessengerCore(JavaPlugin plugin) {
		this(plugin, false);
	}
	
	public void sendNoPre(CommandSender sender, Object obj) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', obj.toString()));
	}
	
	public void send(CommandSender sender, Object obj) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PREFIX + obj.toString()));
	}
	
	public void sendFailed(CommandSender sender, Object obj) {
		send(sender, "&4FAILED:&r " + obj);
	}
	
	public void sendSuccess(CommandSender sender, Object obj) {
		send(sender, "&9SUCCESS:&r " + obj);
	}
	
	public void log(Object obj) {
		send(Bukkit.getServer().getConsoleSender(), obj);
	}
	
	public void error(Object obj) {
		log("&4ERROR:&r " + obj);
	}
	
	public void debug(Object obj) {
		if (DEBUG) {
			log("&eDEBUG:&r " + obj);
		}
	}
	
	public void success(Object obj) {
		debug("&9SUCCESS:&r " + obj);
	}
	
	public void failed(Object obj) {
		debug("&4FAILED:&r " + obj);
	}
}
