package com.nepian.core;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Messenger {
	private final String PREFIX;
	private final boolean DEBUG;
	private final ConsoleCommandSender CONSOLE_SENDER;
	
	public Messenger(JavaPlugin plugin, boolean debug) {
		this.PREFIX = "&d[" + plugin.getName() + "]&r ";
		this.DEBUG = debug;
		this.CONSOLE_SENDER = plugin.getServer().getConsoleSender();
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
		send(CONSOLE_SENDER, obj);
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
