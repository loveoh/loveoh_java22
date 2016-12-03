package com.kaishengit.homework.entity;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Phone {

	private HashMap<String, String> hm = new HashMap<String, String>();
	private Scanner input = new Scanner(System.in);

	public void Start() {
		System.out.println("1.���");
		System.out.println("2.��ѯ");
		System.out.println("3.ɾ��");
		System.out.println("4.�˳�");
		System.out.println("��ѡ��");
		int index = input.nextInt();

		if (1 == index) {
			System.out.println("������绰����");
			String number = input.next();
			String key = findByNumber(number);
			if (key == null) {
				System.out.println("����������");
				String name = input.next();
				hm.put(number, name);
			} else {
				System.out.println("�õ绰�Ѵ���");
			}
			Start();

		} else if (2 == index) {
			System.out.println("������绰����");
			String number = input.next();
			String key = findByNumber(number);
			if (key == null) {
				System.out.println("���޴���");
			} else {
				String value = hm.get(number);
				System.out.println("�绰����:" + key + ",����: " + value);
			}
			Start();
		} else if (3 == index) {
			System.out.println("������绰����");
			String number = input.next();
			String key = findByNumber(number);
			if (key == null) {
				System.out.println("���޴���");
			} else {
				hm.remove(key);
				System.out.println("ɾ���ɹ�");
			}
			Start();
		} else if (4 == index) {
			System.exit(0);
		} else {
			System.out.println("��������");
			Start();
		}
	}

	/**
	 * ����number,���Ƿ����
	 * 
	 * @param number
	 * @return
	 */
	private String findByNumber(String number) {
//		Set<String> set = hm.keySet();
//		for (String key : set) {
//			if (number.equals(key)) {
//				return key;
//			}
//	}
		if(hm.containsKey(number)){
			return number;
		}
		return null;
	}
}
