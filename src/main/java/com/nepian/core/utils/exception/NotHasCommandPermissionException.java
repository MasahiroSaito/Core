package com.nepian.core.utils.exception;

import com.nepian.core.utils.command.SubCommand;

public class NotHasCommandPermissionException extends Exception {
	private static final long serialVersionUID = 1L;
	private SubCommand subCommand;
	
	public NotHasCommandPermissionException(SubCommand subCommand) {
		super("コマンドを実行する権限がありません");
		this.subCommand = subCommand;
	}
	
	public String getPermission() {
		return subCommand.getPermission();
	}
}
