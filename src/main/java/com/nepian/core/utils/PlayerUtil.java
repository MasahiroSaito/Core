package com.nepian.core.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class PlayerUtil {

	/**
	 * UUID で OfflinePlayer を取得する
	 * @param uuid
	 * @return
	 */
	public static OfflinePlayer getOfflinePlayer(UUID uuid) {
		return Bukkit.getServer().getOfflinePlayer(uuid);
	}
	
	/**
	 * UUID でプレイヤー名を取得する
	 * @param uuid
	 * @return
	 */
	public static String getName(UUID uuid) {
		return getOfflinePlayer(uuid).getName();
	}
	
	/**
	 * プレイヤー名から OfflinePlayer を取得する
	 * @param name
	 * @return
	 */
	public static OfflinePlayer getOfflinePlayer(String name) {
		for (OfflinePlayer player : Bukkit.getServer().getOfflinePlayers()) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}
}
