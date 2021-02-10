package com.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	
	private int maxSize;

	public LRULinkedHashMap(int maxSize) {
		super(maxSize, 0.75f, true);
		this.maxSize = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxSize;
	}

	public static void main(String[] args) {
		Map<Integer,Integer> map = new LRULinkedHashMap<>(3);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(2, 5);
		System.out.println(map);
	}
}
