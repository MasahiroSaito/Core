package com.nepian.core.utils.command;

import java.util.List;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import com.nepian.core.utils.Util;

public abstract class SubCommand {
	private String name;
	private String permission;
	private String[] aliases;
	private List<CommandSenderType> senderTypes;
	
	public SubCommand(String name, String...aliases) {
		this.name = name;
		this.aliases = aliases;
		this.senderTypes = Util.newList();
	}
	
	public SubCommand(String name) {
		this(name, new String[0]);
	}
	
	protected void setPermission(String permission) {
		this.permission = permission;
	}
	
	protected void setSenderType(CommandSenderType type) {
		this.senderTypes.add(type);
	}
	
	/**
	 * コマンドを実行する
	 * @param sender コマンド送信者
	 * @param label  入力したコマンド名
	 * @param args   コマンドの引数
	 * @throws CommandException
	 */
	public abstract void execute(CommandSender sender,
			String label, String[] args) throws CommandException;
	
	/**
	 * コマンドで最低限必要な引数の長さを取得する
	 * @return
	 */
	public abstract int getMinimumArguments();
	
	/**
	 * コマンド送信者の権限を確認する
	 * @param sender コマンド送信者
	 * @return
	 */
	protected final boolean hasPermission(CommandSender sender) {
		if (permission == null) return true;
		return sender.hasPermission(permission);
	}
	
	/**
	 * 指定した文字列がコマンドとして適正か判断する
	 * @param name コマンド名
	 * @return
	 */
	protected final boolean isValidTrigger(String name) {
		if (name.equalsIgnoreCase(this.name)) return true;
		if (aliases != null) {
			for (String alias : aliases) {
				if (name.equalsIgnoreCase(alias)) return true;
			}
		}
		return false;
	}
	
	/**
	 * コマンド送信者が適正か判断する
	 * @param sender コマンド送信者
	 * @return
	 */
	protected final boolean isValidCommandSender(CommandSender sender) {
		if (senderTypes.isEmpty()) return true;
		for (CommandSenderType type : senderTypes) {
			if (type.isValid(sender)) return true;
		}
		return false;
	}
	
	public String getPermission() {
		return permission;
	}
}
