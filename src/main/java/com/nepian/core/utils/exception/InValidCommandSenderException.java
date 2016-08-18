package com.nepian.core.utils.exception;

import org.bukkit.command.CommandSender;

public class InValidCommandSenderException extends Exception {
	private static final long serialVersionUID = 1L;
	private CommandSender sender;
	
	public InValidCommandSenderException(CommandSender sender) {
		super("コマンドの送信者が不適正です");
		this.sender = sender;
	}
	
	public CommandSender getCommandSender() {
		return sender;
	}
}
