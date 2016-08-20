package com.nepian.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandUtil {

	/**
	 * コマンドを登録する
	 * @param plugin
	 * @param name
	 * @param command
	 */
	public static void registerCommand(JavaPlugin plugin,
			String name, CommandExecutor command) {
		Bukkit.getPluginCommand(name).setExecutor(command);
//		plugin.getCommand(name).setExecutor(command);
	}
}
