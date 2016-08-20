package com.nepian.core.utils.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class GetOfflinePlayer {

	/**
	 * UUIDからOfflinePlayerを取得する
	 * @param uuid
	 * @return OfflinePlayer
	 */
	public static OfflinePlayer fromUUID(UUID uuid) {
		return Bukkit.getServer().getOfflinePlayer(uuid);
	}
	
	/**
	 * プレイヤー名からOfflinePlayerを取得する
	 * @param name
	 * @return OfflinePlayer
	 */
	public static OfflinePlayer fromPlayerName(String name) {
		for (OfflinePlayer player : Bukkit.getServer().getOfflinePlayers()) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}
}
