package com.nepian.core.utils.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.nepian.core.Messenger;
import com.nepian.core.utils.Util;
import com.nepian.core.utils.exception.InValidCommandArgsException;
import com.nepian.core.utils.exception.InValidCommandSenderException;
import com.nepian.core.utils.exception.NotHasCommandPermissionException;

public abstract class MainCommand extends SubCommand implements CommandExecutor {
	/**
	 * 継承先から利用できるMessenger<br>
	 * MainCommandのインスタンス生成時に自動で生成される
	 */
	protected Messenger messenger;
	private List<SubCommand> subCommands;
	
	/**
	 * 指定した名前と別名でインスタンスを生成する
	 * @param plugin コマンドを実行するプラグイン
	 * @param name コマンド名
	 * @param names コマンドの別名(複数可)
	 */
	public MainCommand(JavaPlugin plugin, String name, String...names) {
		super(name, names);
		this.subCommands = Util.newArrayList();
		this.messenger = new Messenger(plugin, false);
	}
	
	/**
	 * サブコマンドを設定する
	 * @param subCommand
	 */
	protected void setSubCommand(SubCommand subCommand) {
		subCommands.add(subCommand);
	}

	@Override
	public boolean onCommand(CommandSender sender,
			Command command, String label, String[] args) {
		
		try {
			if (onSubCommand(sender, label, args)) return true;
			if (onMainCommand(sender, label, args)) return true;
		} catch (Exception e) {
			messenger.sendFailed(sender, e.getMessage());
		}
		
		return true;
	}
	
	private boolean onMainCommand(CommandSender sender, String label, String[] args)
			throws CommandException, InValidCommandSenderException,
			NotHasCommandPermissionException, InValidCommandArgsException {
		
		if (!isValidTrigger(label)) {
			return false;
		}
		
		if (!isValidCommandSender(sender)) {
			throw new InValidCommandSenderException(sender);
		}
		
		if (!hasPermission(sender)) {
			throw new NotHasCommandPermissionException(this);
		}
		
		if (getMinimumArguments() <= args.length) {
			execute(sender, label, args);
			return true;
		} else {
			throw new InValidCommandArgsException(this, label, args);
		}
	}
	
	private boolean onSubCommand(CommandSender sender, String label, String[] args)
			throws InValidCommandSenderException, NotHasCommandPermissionException,
			InValidCommandArgsException {
		
		if (args.length <= 0) {
			return false;
		}
		
		for (SubCommand subCommand : subCommands) {
			if (!subCommand.isValidTrigger(args[0])) {
				continue;
			}
			
			if (!subCommand.isValidCommandSender(sender)) {
				throw new InValidCommandSenderException(sender);
			}
			
			if (!subCommand.hasPermission(sender)) {
				throw new NotHasCommandPermissionException(subCommand);
			}
			
			if (subCommand.getMinimumArguments() <= args.length - 1) {
				subCommand.execute(sender, label, Arrays.copyOfRange(args, 1, args.length));
				return true;
			} else {
				throw new InValidCommandArgsException(subCommand, label, args);
			}
		}
		
		return false;
	}
}
