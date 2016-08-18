package com.nepian.core.utils.exception;

import java.io.File;

public class SaveYamlConfigurationException extends Exception {
	private static final long serialVersionUID = 1L;

	public SaveYamlConfigurationException(File file) {
		super("ファイルの書き込み失敗しました（" + file.getName() + "）");
	}
}
