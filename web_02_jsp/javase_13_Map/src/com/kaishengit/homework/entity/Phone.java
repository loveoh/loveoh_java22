package com.kaishengit.homework.entity;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Phone {

	private HashMap<String, String> hm = new HashMap<String, String>();
	private Scanner input = new Scanner(System.in);

	public void Start() {
		System.out.println("1.添加");
		System.out.println("2.查询");
		System.out.println("3.删除");
		System.out.println("4.退出");
		System.out.println("请选择");
		int index = input.nextInt();

		if (1 == index) {
			System.out.println("请输入电话号码");
			String number = input.next();
			String key = findByNumber(number);
			if (key == null) {
				System.out.println("请输入姓名");
				String name = input.next();
				hm.put(number, name);
			} else {
				System.out.println("该电话已存在");
			}
			Start();

		} else if (2 == index) {
			System.out.println("请输入电话号码");
			String number = input.next();
			String key = findByNumber(number);
			if (key == null) {
				System.out.println("查无此人");
			} else {
				String value = hm.get(number);
				System.out.println("电话号码:" + key + ",姓名: " + value);
			}
			Start();
		} else if (3 == index) {
			System.out.println("请输入电话号码");
			String number = input.next();
			String key = findByNumber(number);
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
