package com.kaishengit.work.student;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {

	// 单例设计模式
	private DataBase() {
	}

	private static DataBase data = new DataBase();

	public static DataBase getInstance() {
		return data;
	}

	private ArrayList<Student> list = new ArrayList<Student>();

	private Scanner input = new Scanner(System.in);

	/**
	 * 添加方法
	 */
	public void add(Student student) {
		if (list.size() == 0) {
			list.add(student);
			System.out.println("添加成功");
		} else {
			for (Student stu : list) {
				if (student.getNumber().equals(stu.getNumber())) {
					System.out.println("该学号已存在,请核对");

				} else {
					list.add(student);
					System.out.println("添加成功");
					break;
				}
			}
		}

	}

	/**
	 * 查询
	 * 
	 * @param number
	 */
	public void inquire(String number) {
		for (Student stu : list) {
			if (number.equals(stu.getNumber())) {
				System.out.println(stu);
				break;
			} else {
				System.out.println("该学生不存在");
			}

		}

	}

	/**
	 * 修改
	 * 
	 * @param number
	 */
	public void mofifation(String number) {
		Student s;
		for (Student stu : list) {
			if (number.equals(stu.getNumber())) {
				s = stu;
				System.out.println("1.修改学号'\\n'2.修改名字\\n3.修改年龄\\n4.修改成绩");
				int index = input.nextInt();
				if (1 == index) {
					System.out.println("请重新输入学号");
					String newNumber = input.next();
					s.setNumber(newNumber);

				} else if (2 == index) {
					System.out.println("请重新输入姓名");
					String name = input.next();
					s.setName(name);
				} else if (3 == index) {
					System.out.println("请重新输入年龄");
					int age = input.nextInt();
					s.setAge(age);
				} else if (4 == index) {
					System.out.println("请重新输入成绩");
					int score = input.nextInt();
					s.setScore(score);

				} else {
					System.out.println("输入有误");
					mofifation(number);
				}
				break;
			} else {
				System.out.println("该学生不存在");
				break;
			}

		}
		
	}

	/**
	 * 删除
	 * 
	 * @param number
	 */
	public void remove(String number) {

		for (Student s : list) {
			if (number.equals(s.getNumber())) {
				list.remove(s);
			} else {
				System.out.println("该学生不存在");
			}
		}
	}

	/**
	 * 求平均成绩
	 */
	public void avgScore() {
		int sum = 0;
		for (Student s : list) {
			int score = s.getScore();
			sum += score;
		}
		int num = list.size();

		int avg = sum / num;
		System.out.println("学生平均成绩为:" + avg);

	}

}
