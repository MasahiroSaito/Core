package com.nepian.core.utils.player;

import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class GetOfflinePlayer {

	/**
	 * UUIDからOfflinePlayerを取得する
	 * @param uuid
	 * @param plugin
	 * @return OfflinePlayer
	 */
	public static OfflinePlayer fromUUID(UUID uuid, JavaPlugin plugin) {
		return plugin.getServer().getOfflinePlayer(uuid);
	}
	
	/**
	 * プレイヤー名からOfflinePlayerを取得する
	 * @param name
	 * @param plugin
	 * @return OfflinePlayer
	 */
	public static OfflinePlayer fromPlayerName(String name, JavaPlugin plugin) {
		for (OfflinePlayer player : plugin.getServer().getOfflinePlayers()) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}
}
