package com.nepian.core.utils.player;

import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

public class GetPlayerName {

	/**
	 * プレイヤー名をUUIDから取得する
	 * @param uuid
	 * @param plugin
	 * @return String
	 */
	public static String fromUUID(UUID uuid, JavaPlugin plugin) {
		return GetOfflinePlayer.fromUUID(uuid, plugin).getName();
	}
}
