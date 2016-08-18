package com.nepian.core.utils.config;

public enum ClassType {
	STRING(String.class),
	CHAR(char.class),
	BOOLEAN(boolean.class),
	INT(int.class),
	DOUBLE(double.class),
	FLOAT(float.class);
	
	private Class<?> clazz;
	
	ClassType(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public static ClassType get(Class<?> clazz) {
		for (ClassType type : values()) {
			if (clazz == type.clazz) return type;
		}
		return null;
	}
}
