package com.kaishengit.work.student;

import java.util.Scanner;

/**
 * 系统管理菜单
 * @author loveoh
 *
 */
public class Computer {
	
	private DataBase data = DataBase.getInstance();
	private Scanner input = new Scanner(System.in);

	
	 public void start(){
		System.out.println("1.录入");
		System.out.println("2.查询");
		System.out.println("3.修改");
		System.out.println("4.删除");
		System.out.println("5.统计");
		System.out.println("6.退出");
		System.out.println("请选择");
		int index = input.nextInt();
		if(1 == index) {
			add();
		}else if(2 == index) {
			inquire();
		}else if(3 == index) {
			mofifation();
		}else if(4 == index) {
			remove();
		}else if(5 == index) {
			avgScore();
		}else if(6 == index) {
			System.exit(0);
		}else{
			System.out.println("输入错误,请重新输入");
			start();
		}
		
		
	}
	 
	 /**
	  * 统计
	  */
	 private void avgScore() {
		 data.avgScore();
		
	}

	/**
	  * 删除
	  */
	 private void remove() {
		System.out.println("请输入要删除的学号");
		String number = input.next();
		data.remove(number);
		
		
	}

	/**
	  * 修改
	  */
	private void mofifation() {
		System.out.println("请输入学号");
		String number = input.next();
		data.mofifation(number);
		start();
		
	}

	private void inquire() {
		System.out.println("请输入查询的学号");
		String number = input.next();
		
		data.inquire(number);
		start();
	}

	private void add() {
		System.out.println("请输入学号");
		String number = input.next();
		System.out.println("请输入姓名");
		String name = input.next();
		System.out.println("请输入年龄");
		int age = input.nextInt();
		System.out.println("请输入成绩");
		int score = input.nextInt();
		
		Student s = new Student();
		
		s.setName(name);
		s.setNumber(number);
		s.setAge(age);
		s.setScore(score);
		
		data.add(s);
		
		start();
	}
}
