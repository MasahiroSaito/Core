package com.nepian.core.utils.config;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

import com.nepian.core.utils.FileUtil;
import com.nepian.core.utils.Util;

public class ConfigLoader {
	private File folder;
	private Map<Class<?>, Config> configs;

	public ConfigLoader(JavaPlugin plugin, String folderName, Class<? extends Configs> clazzs) {
		this.folder = FileUtil.loadFolder(plugin.getDataFolder(), folderName);
		this.configs = Util.newMap();
		this.putConfigs(clazzs);
		this.readAll();
		this.writeAll();
	}

	/**
	 * 設定を全て書き込む
	 */
	public void writeAll() {
		for (Config config : configs.values()) {
			config.write();
		}
	}

	/**
	 * 設定を全て読み込む
	 */
	public void readAll() {
		for (Config config : configs.values()) {
			config.read();
		}
	}

	/**
	 * 設定をまとめたクラスから設定を読み込む
	 * @param clazzs
	 */
	private void putConfigs(Class<? extends Configs> clazzs) {
		for (Field field : clazzs.getFields()) {
			try {
				Class<?> clazz = (Class<?>) field.get(null);
				configs.put(clazz, new Config(clazz, field.getName(), folder));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
