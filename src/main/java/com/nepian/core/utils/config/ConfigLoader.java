package com.nepian.core.utils.config;

import java.io.File;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

import com.nepian.core.utils.FileUtil;
import com.nepian.core.utils.Util;

public class ConfigLoader {
	private File folder;
	private Map<Class<?>, Config> configs;

	public ConfigLoader(JavaPlugin plugin, String folderName) {
		this.folder = FileUtil.loadFolder(plugin.getDataFolder(), folderName);
		this.configs = Util.newMap();
	}

	public ConfigLoader(JavaPlugin plugin, String folderName, Map<String, Class<?>> clazzs) {
		this(plugin, folderName);
		this.putConfigs(clazzs);
	}

	public ConfigLoader write(Class<?> clazz) {
		configs.get(clazz).write();
		return this;
	}

	public ConfigLoader read(Class<?> clazz, String name) {
		configs.put(clazz, new Config(clazz, name, folder).read());
		return this;
	}

	public ConfigLoader writeAll() {
		for (Config config : configs.values()) {
			config.write();
		}
		return this;
	}

	public ConfigLoader readAll() {
		for (Config config : configs.values()) {
			config.read();
		}
		return this;
	}

	private void putConfigs(Map<String, Class<?>> clazzs) {
		for (String name : clazzs.keySet()) {
			Class<?> clazz = clazzs.get(name);
			configs.put(clazz, new Config(clazz, name, folder));
		}
	}
}
