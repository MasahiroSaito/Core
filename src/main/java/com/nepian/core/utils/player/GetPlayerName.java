package com.nepian.core.utils.player;

import java.util.UUID;

public class GetPlayerName {

	/**
	 * プレイヤー名をUUIDから取得する
	 * @param uuid
	 * @return String
	 */
	public static String fromUUID(UUID uuid) {
		return GetOfflinePlayer.fromUUID(uuid).getName();
	}
}
