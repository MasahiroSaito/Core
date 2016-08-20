package com.nepian.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Messenger {
	private final String PREFIX;
	private final boolean DEBUG;
	
	public Messenger(JavaPlugin plugin, boolean debug) {
		this.PREFIX = "&d[" + plugin.getName() + "]&r ";
		this.DEBUG = debug;
	}
	
	public Messenger(JavaPlugin plugin) {
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
		send(Bukkit.getConsoleSender(), obj);
	}
	
	public void error(Object obj) {
		log("&4ERROR:&r " + obj);
	}
	
	public void success(Object obj) {
		log("&9SUCCESS:&r " + obj);
	}
	
	public void failed(Object obj) {
		log("&4FAILED:&r " + obj);
	}
	
	public void debug(Object obj) {
		if (DEBUG) {
			log("&eDEBUG:&r " + obj);
		}
	}
}
