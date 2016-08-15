package com.nepian.core.utils;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

/**
 * ファイルまわりのメソッド群
 */
public class FileUtil {
	
	/**
	 * ファイルを読み込む
	 * @param folder
	 * @param fileName
	 * @return
	 */
	public static File loadFile(File folder, String fileName) {
		return load(folder, fileName, FileType.FILE);
	}
	
	/**
	 * フォルダを読み込む
	 * @param folder
	 * @param fileName
	 * @return
	 */
	public static File loadFolder(File folder, String fileName) {
		return load(folder, fileName, FileType.FOLDER);
	}
	
	/**
	 * ロードするファイルの種類
	 * @author codepro2014MBA02
	 *
	 */
	public enum FileType { FILE, FOLDER }
	
	/**
	 * ファイルかフォルダをロードする
	 * @param folder
	 * @param fileName
	 * @param type
	 * @return
	 */
	public static File load(File folder, String fileName, FileType type) {
		File file = new File(folder, fileName);
		if (!file.exists()) {
			try {
				if (file.getParent() != null) {
					file.getParentFile().mkdirs();
				}

				switch (type) {
				case FILE:
					file.createNewFile();
					break;
				case FOLDER:
					file.mkdir();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	/**
	 * YamlConfigurationを取得する
	 * @param file
	 * @return
	 */
	public static YamlConfiguration getYml(File file) {
		return YamlConfiguration.loadConfiguration(file);
	}
}
