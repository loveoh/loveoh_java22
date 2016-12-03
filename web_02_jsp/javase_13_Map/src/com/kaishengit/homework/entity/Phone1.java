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
		System.out.println("1.添加");
		System.out.println("2.查询");
		System.out.println("3.删除");
		System.out.println("4.退出");
		System.out.println("请选择");
		int index = input.nextInt();

		if (1 == index) {
			System.out.println("请输入姓名");
			String name = input.next();
			String key = findByName(name);
			if (key == null) {
				String answer;
				// 最少可以添加一次电话,跟进输入的Y和N来判断是否添加后续
				do {
					System.out.println("请输入电话号码");
					String number = input.next();
					System.out.println("是否继续存入电话号码?Y|N?");
					answer = input.next();
					list.add(number);
				} while ("y".equalsIgnoreCase(answer));

				hm.put(name, list);

			} else {
				System.out.println("该用户已存在");
			}
			Start();

		} else if (2 == index) {
			System.out.println("请输入姓名");
			String name = input.next();
			String key = findByName(name);
			if (key == null) {
				System.out.println("查无此人");
			} else {
				ArrayList<String> value = hm.get(name);
				for (String s : value) {
					System.out.println("姓名:" + key + "电话: " + s);
				}

			}
			Start();
		} else if (3 == index) {
			System.out.println("请输入姓名");
			String name = input.next();
			String key = findByName(name);
			if (key == null) {
				System.out.println("查无此人");
			} else {
				hm.remove(key);
				System.out.println("删除成功");
			}
			Start();
		} else if (4 == index) {
			System.exit(0);
		} else {
			System.out.println("输入有误");
			Start();
		}
	}

	/**
	 * 查找number,看是否存在
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
