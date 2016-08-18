package com.nepian.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Util {
	
	/**
	 * HashMapを生成する
	 * @return
	 */
	public static <T, V> Map<T, V> newMap() {
		return new HashMap<T, V>();
	}
	
	/**
	 * HashSetを生成する
	 * @return
	 */
	public static <T> Set<T> newSet() {
		return new HashSet<T>();
	}
	
	/**
	 * ArrayListを生成する
	 * @return
	 */
	public static <T> List<T> newList() {
		return new ArrayList<T>();
	}
}
