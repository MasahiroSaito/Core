package com.nepian.core.utils.exception;

public class NotFoundKeyException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotFoundKeyException(String key) {
		super("キーが存在しません（" + key + "）");
	}
}
