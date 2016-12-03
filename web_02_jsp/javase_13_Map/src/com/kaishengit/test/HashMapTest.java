package com.kaishengit.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap �洢��ֵ��,����ֵ����һһ��Ӧ�Ĺ�ϵ,�������ظ�,����ֵ�����ظ� �洢����ͬ��ʱ��,�Ὣǰ�渲��
 * 
 * @author loveoh
 *
 */
public class HashMapTest {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("K001", "����");
		map.put("k002", "���޼�");
		// ����ͬ��ʱ��,ֵ�Ḳ��
		map.put("k003", "�Ŵ�ɽ");
		map.put("k003", "������");
		String s = map.put("K007", "JamsBonde");
		System.out.println(s);
		// ���ݼ���ֵ
		// String value = map.get("k003");
		// System.out.println(value);

		// ����ȡ��,��ʽһ
		// ��ȡ���ļ���,������Ȼ��ͨ������ֵ
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(key + "----" + value);
		}

		// ��ʽ��
		Set<Entry<String, String>> entryset = map.entrySet();

		for (Entry<String, String> entry : entryset) {

			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "------" + value);
		}
	}
}
