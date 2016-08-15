package com.nepian.core.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;

public abstract class ConfigBase {
	protected File configFile;
	protected Map<String, Object> configs;
	
	public ConfigBase(File configFile) {
		this.configFile = configFile;
		this.configs = Util.newMap();
		this.setConfigs();
		this.read();
	}
	
	/**
	 * 設定を取得する
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return configs.get(key);
	}
	
	/**
	 * 設定を更新する
	 * @param key
	 * @param value
	 */
	public void update(String key, Object value) {
		if (configs.containsKey(key)) {
			write(key, value);
			configs.put(key, value);
		}
	}
	
	/**
	 * 設定を追加する
	 * @param key
	 * @param value
	 */
	protected void add(String key, Object value) {
		configs.put(key, value);
	}
	
	protected abstract void setConfigs();
	
	/**
	 * 設定をファイルから読み込む
	 */
	private void read() {
		YamlConfiguration data = FileUtil.getYml(configFile);
		
		for (String key : configs.keySet()) {
			if (!data.contains(key)) {
				write(key, configs.get(key));
			}
		}
	}
	
	/**
	 * 設定をファイルへ書き込む
	 * @param key
	 * @param value
	 */
	private void write(String key, Object value) {
		YamlConfiguration data = FileUtil.getYml(configFile);
		data.set(key, value);
		save(data);
	}
	
	/**
	 * 設定を保存する
	 * @param data
	 */
	private void save(YamlConfiguration data) {
		try {
			data.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
