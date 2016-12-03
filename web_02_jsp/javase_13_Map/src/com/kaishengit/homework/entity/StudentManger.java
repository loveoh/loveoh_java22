package com.kaishengit.homework.entity;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentManger {

	private Scanner input = new Scanner(System.in);
	private ArrayList<Student> list = new ArrayList<Student>();

	public void start() {
		System.out.println("1.录入");
		System.out.println("2.查询");
		System.out.println("3.修改");
		System.out.println("4.删除");
		System.out.println("5.统计");
		System.out.println("6.退出");
		System.out.println("请选择");
		int index = input.nextInt();

		if (1 == index) {
			System.out.println("请输入学号");
			String number = input.next();
			// 调用方法,判断学号是否存在
			Student s = findByName(number);
			if (s == null) {
				add(number);
				System.out.println("添加成功");
			} else {
				System.out.println("该学号已被占用");
			}
			start();

		} else if (2 == index) {
			System.out.println("请输入学号");
			String number = input.next();
			Student s = findByName(number);

			if (s == null) {
				System.out.println("查无此人");
			} else {
				System.out.println(s);
			}
			start();
		} else if (3 == index) {
			System.out.println("请输入学号");
			String number = input.next();
			Student s = findByName(number);
			boolean flag = false;
			if (s == null) {
				System.out.println("查无此人");
			} else {
				System.out.println("你要修改姓名吗?Y|N?");
				String answer = input.next();
				if ("y".equalsIgnoreCase(answer)) {
					System.out.println("请输入新姓名");
					String newName = input.next();
					s.setName(newName);
					flag = true;
				}

				System.out.println("你要修改年龄吗?Y|N?");
				answer = input.next();
				if ("y".equalsIgnoreCase(answer)) {
					System.out.println("请输入新年龄");
					int newAge = input.nextInt();
					s.setAge(newAge);
					flag = true;
				}

				System.out.println("你要修改成绩吗?Y|N?");
				answer = input.next();
				if ("y".equalsIgnoreCase(answer)) {
					System.out.println("请输入新成绩");
					int newScore = input.nextInt();
					s.setScore(newScore);
					flag = true;
				}
				if (flag) {
					System.out.println("修改成功");
				}
			}
			start();
		} else if (4 == index) {
			System.out.println("请输入学号");
			String number = input.next();
			Student s = findByName(number);

			if (s == null) {
				System.out.println("查无此人");
			} else {
				list.remove(s);
				System.out.println("删除成功");
			}
			start();

		} else if (5 == index) {
			double sum = 0.0;
			for (Student s : list) {
				sum += s.getScore();
			}
			double ave = sum / list.size();
			System.out.println("学生的平均成绩为:" + ave);
			start();
		} else if (6 == index) {
			System.exit(0);
		} else {
			System.out.println("输出错误");
			start();
		}
	}

	/**
	 * 添加方法
	 * 
	 * @param number
	 */
	private void add(String number) {
		System.out.println("请输入姓名");
		String name = input.next();
		System.out.println("请输入年龄");
		int age = input.nextInt();
		System.out.println("请输入成绩");
		int score = input.nextInt();

		Student s = new Student(number, name, age, score);

		list.add(s);

	}

	/**
	 * 判断学号是否存在
	 * 
	 * @param number
	 */
	private Student findByName(String number) {
		for (Student stu : list) {
			if (number.equals(stu.getNumber())) {
				return stu;
			}
		}
		return null;
	}

}
