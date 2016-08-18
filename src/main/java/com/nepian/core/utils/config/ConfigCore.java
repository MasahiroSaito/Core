package com.nepian.core.utils.config;

import java.io.File;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.nepian.core.utils.FileUtil;
import com.nepian.core.utils.Util;
import com.nepian.core.utils.exception.NotFoundKeyException;
import com.nepian.core.utils.exception.SaveYamlConfigurationException;

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
	
	public void update(String key, Object value)
			throws SaveYamlConfigurationException, NotFoundKeyException {
		if (configs.containsKey(key)) {
			write(key, value);
			configs.put(key, value);
		} else {
			throw new NotFoundKeyException(key);
		}
	}
	
	private void read() {
		for (String key : yaml.getKeys(true)) {
			configs.put(key, yaml.get(key));
		}
	}
	
	private void write(String key, Object value)
			throws SaveYamlConfigurationException {
		yaml.set(key, value);
		FileUtil.saveYml(file, yaml);
	}
}
