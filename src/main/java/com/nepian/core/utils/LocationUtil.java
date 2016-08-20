package com.nepian.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtil {
	
	/**
	 * Locationを文字列に変換する際、データを切り分ける文字列
	 */
	public static final String SPLIT = "__";
	
	/**
	 * 文字列からLocationインスタンスを作成する
	 * @param string locationから取得した文字列
	 * @return 文字列から生成したLocationインスタンス
	 */
	public static Location fromString(String string) {
		String[] data = string.split(SPLIT);
		
		UUID worldUid = UUID.fromString(data[0]);
		World world = Bukkit.getWorld(worldUid);
		double x = Double.valueOf(data[1]);
		double y = Double.valueOf(data[2]);
		double z = Double.valueOf(data[3]);
		float yaw = Float.valueOf(data[4]);
		float pitch = Float.valueOf(data[5]);
		
		return new Location(world, x, y, z, yaw, pitch);
	}
	
	/**
	 * Locationを文字列として取得する
	 * @param location Locationのインスタンス
	 * @return Locationの文字列
	 */
	public static String asString(Location location) {
		StringBuilder data = new StringBuilder("");
		
		World world = location.getWorld();
		double x = location.getX();
		double y = location.getY();
		double z = location.getZ();
		float yaw = location.getYaw();
		float pitch = location.getPitch();
		
		data.append(world.getUID().toString()).append(SPLIT);
		data.append(x).append(SPLIT);
		data.append(y).append(SPLIT);
		data.append(z).append(SPLIT);
		data.append(yaw).append(SPLIT);
		data.append(pitch);
		
		return data.toString();
	}
	
	/**
	 * Locationをバイト配列として取得する
	 * @param location 対象のロケーション
	 * @return Locationのバイト配列
	 */
	public static byte[] asByteArray(final Location location) {
		try {
			ByteArrayOutputStream byteos = new ByteArrayOutputStream();
			ObjectOutputStream objos = new ObjectOutputStream(byteos);
			objos.writeObject(new LocationSerializable(location));
			objos.close();
			byteos.close();
			return byteos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * byte配列からLocationのインスタンスを生成する
	 * @param bytes 読み込みたいLocationのbyte配列
	 * @return 読み込んだLocationをインスタンスとして返す
	 */
	public static Location fromByteArray(final byte[] bytes) {
		try {
			ByteArrayInputStream byteis = new ByteArrayInputStream(bytes);
			ObjectInputStream objis = new ObjectInputStream(byteis);
			LocationSerializable ls = (LocationSerializable) objis.readObject();
			byteis.close();
			objis.close();
			return ls.getLocation();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static class LocationSerializable implements Serializable {
		private static final long serialVersionUID = 1L;
		private UUID worldUid;
		private int x;
		private int y;
		private int z;
		private float yaw;
		private float pitch;

		private LocationSerializable(Location location) {
			this.worldUid = location.getWorld().getUID();
			this.x = location.getBlockX();
			this.y = location.getBlockY();
			this.z = location.getBlockZ();
			this.yaw = location.getYaw();
			this.pitch = location.getPitch();
		}
		
		private Location getLocation() {
			return new Location(Bukkit.getWorld(worldUid), x, y, z, yaw, pitch);
		}
	}
}
