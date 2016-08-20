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
	 * @return HashMapで生成したMap
	 */
	public static <T, V> Map<T, V> newHashMap() {
		return new HashMap<T, V>();
	}
	
	/**
	 * HashSetを生成する
	 * @return HashSetで生成したSet
	 */
	public static <T> Set<T> newHashSet() {
		return new HashSet<T>();
	}
	
	/**
	 * ArrayListを生成する
	 * @return ArrayListで生成したList
	 */
	public static <T> List<T> newArrayList() {
		return new ArrayList<T>();
	}
}
