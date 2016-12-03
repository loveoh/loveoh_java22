package com.kaishengit.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap 存储键值对,键和值都是一一对应的关系,键不能重复,但是值可以重复 存储键相同的时候,会将前面覆盖
 * 
 * @author loveoh
 *
 */
public class HashMapTest {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("K001", "张三");
		map.put("k002", "张无忌");
		// 键相同的时候,值会覆盖
		map.put("k003", "张翠山");
		map.put("k003", "张三丰");
		String s = map.put("K007", "JamsBonde");
		System.out.println(s);
		// 根据键找值
		// String value = map.get("k003");
		// System.out.println(value);

		// 遍历取出,方式一
		// 获取键的集合,遍历键然后通过键找值
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(key + "----" + value);
		}

		// 方式二
		Set<Entry<String, String>> entryset = map.entrySet();

		for (Entry<String, String> entry : entryset) {

			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "------" + value);
		}
	}
}
