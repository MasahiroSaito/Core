package com.nepian.core;

import java.io.File;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.nepian.core.utils.FileUtil;
import com.nepian.core.utils.Util;

public class ConfigCore {
	protected static final String FOLDER_NAME = "configs";
	protected static File folder;
	protected File file;
	protected YamlConfiguration yaml;
	protected Map<String, Object> configs;
	
	public ConfigCore(JavaPlugin plugin, String name) {
		folder = FileUtil.loadFolder(plugin.getDataFolder(), FOLDER_NAME);
		file = FileUtil.loadFile(folder, name);
		yaml = FileUtil.getYml(file);
		configs = Util.newMap();
		read();
	}
	
	public Object get(String key) {
		return configs.get(key);
	}
	
	public void update(String key, Object value) {
		if (configs.containsKey(key)) {
			write(key, value);
			configs.put(key, value);
		}
	}
	
	private void read() {
		for (String key : yaml.getKeys(true)) {
			configs.put(key, yaml.get(key));
		}
	}
	
	private void write(String key, Object value) {
		yaml.set(key, value);
		FileUtil.saveYml(file, yaml);
	}
}
