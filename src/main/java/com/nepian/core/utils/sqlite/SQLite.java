package com.nepian.core.utils.sqlite;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.plugin.java.JavaPlugin;

import com.nepian.core.utils.FileUtil;

public class SQLite {
	private File file;
	private Connection connection;
	
	/**
	 * ファイルで生成する
	 * @param file
	 */
	public SQLite(File file) {
		this.file = file;
		this.connection = connect();
	}
	
	/**
	 * プラグインのフォルダにファイル名で生成する
	 * @param plugin
	 * @param fileName 拡張子(.db)を含めたファイル名
	 */
	public SQLite(JavaPlugin plugin, String fileName) {
		this(FileUtil.loadFile(plugin.getDataFolder(), fileName));
	}
	
	private Connection connect() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + file);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * データベースから切断する
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * PreparedStatement を取得する
	 * @param token
	 * @return PreparedStatement
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(String token) throws SQLException {
		return connection.prepareStatement(token);
	}
	
	/**
	 * Connection を取得する
	 * @return Connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * executeUpdateを実行する
	 * @param token 実行する完全なトークン
	 */
	public void executeUpdate(final String token) {
		try {
			getPreparedStatement(token).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
