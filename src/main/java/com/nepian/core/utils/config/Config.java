package com.nepian.core.utils.config;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.bukkit.configuration.file.YamlConfiguration;

import com.nepian.core.utils.FileUtil;
import com.nepian.core.utils.exception.SaveYamlConfigurationException;

public class Config {
	private Class<?> clazz;
	private File file;
	private YamlConfiguration yaml;

	protected Config(Class<?> clazz, String name, File folder) {
		this.clazz = clazz;
		this.file = FileUtil.loadFile(folder, name + ".yml");
		this.yaml = FileUtil.getYml(file);
	}

	protected Config read() {
		for (Field field : clazz.getFields()) {
			if (!isValidModifier(field.getModifiers())) continue;
			String name = field.getName();
			try {
				if (yaml.contains(name)) {
					switch (ClassType.get(field.getType())) {
					case STRING:  field.set(null, yaml.getString(name));  break;
					case CHAR:    field.set(null, (char) yaml.get(name)); break;
					case BOOLEAN: field.set(null, yaml.getBoolean(name)); break;
					case INT:     field.set(null, yaml.getInt(name));     break;
					case DOUBLE:  field.set(null, yaml.getDouble(name));  break;
					case FLOAT:   field.set(null, (float) yaml.getDouble(name));  break;
					default:
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	protected Config write() {
		for (Field field : clazz.getFields()) {
			if (!isValidModifier(field.getModifiers())) continue;
			String name = field.getName();
			try {
				switch (ClassType.get(field.getType())) {
				case STRING:  yaml.set(name, (String) field.get(null)); break;
				case CHAR:    yaml.set(name, field.getChar(null));      break;
				case BOOLEAN: yaml.set(name, field.getBoolean(null));   break;
				case INT:     yaml.set(name, field.getInt(null));       break;
				case DOUBLE:  yaml.set(name, field.getDouble(null));    break;
				case FLOAT:   yaml.set(name, field.getFloat(null));     break;
				default:
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			FileUtil.saveYml(file, yaml);
		} catch (SaveYamlConfigurationException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	private boolean isValidModifier(int modifier) {
		if (!Modifier.isPublic(modifier)) return false;
		if (!Modifier.isStatic(modifier)) return false;
		if (Modifier.isFinal(modifier)) return false;
		return true;
	}
}
