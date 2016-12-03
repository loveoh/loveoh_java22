package com.kaishengit.homework.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Phone1 {

	private HashMap<String, ArrayList> hm = new HashMap<String, ArrayList>();
	private ArrayList<String> list = new ArrayList<String>();

	private Scanner input = new Scanner(System.in);

	public void Start() {
		System.out.println("1.���");
		System.out.println("2.��ѯ");
		System.out.println("3.ɾ��");
		System.out.println("4.�˳�");
		System.out.println("��ѡ��");
		int index = input.nextInt();

		if (1 == index) {
			System.out.println("����������");
			String name = input.next();
			String key = findByName(name);
			if (key == null) {
				String answer;
				// ���ٿ������һ�ε绰,���������Y��N���ж��Ƿ���Ӻ���
				do {
					System.out.println("������绰����");
					String number = input.next();
					System.out.println("�Ƿ��������绰����?Y|N?");
					answer = input.next();
					list.add(number);
				} while ("y".equalsIgnoreCase(answer));

				hm.put(name, list);

			} else {
				System.out.println("���û��Ѵ���");
			}
			Start();

		} else if (2 == index) {
			System.out.println("����������");
			String name = input.next();
			String key = findByName(name);
			if (key == null) {
				System.out.println("���޴���");
			} else {
				ArrayList<String> value = hm.get(name);
				for (String s : value) {
					System.out.println("����:" + key + "�绰: " + s);
				}

			}
			Start();
		} else if (3 == index) {
			System.out.println("����������");
			String name = input.next();
			String key = findByName(name);
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
	private String findByName(String name) {
		Set<String> set = hm.keySet();
		for (String key : set) {
			if (name.equals(key)) {
				return key;
			}
		}
		return null;
	}
}
