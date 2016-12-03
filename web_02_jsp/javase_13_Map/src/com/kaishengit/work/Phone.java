package com.kaishengit.work;

import java.util.HashMap;
import java.util.Scanner;

public class Phone {
	
	private HashMap<String ,String> map = new HashMap<String,String>();
	
	Scanner input = new Scanner(System.in);
	
	
	public void Start(){
		System.out.println("1.添加号码");
		System.out.println("2.删除号码");
		System.out.println("3.查询号码");
		System.out.println("请选择");
		
		int index = input.nextInt();
		if(1 == index) {
			add();
				
		}else if(2 == index) {
			remove();
			
		}else if(3 == index) {
			inquire();
		}else{
			System.out.println("输入错误");
			System.exit(0);
		}
		
	}

	private void inquire() {
		System.out.println("请输入电话号码");
		String phoneNumber = input.next();
		String name = map.get(phoneNumber);
		System.out.println("查询的用户为:" + name);
		Start();
		
	}

	private void remove() {
		System.out.println("请输入电话号码");
		String phoneNumber = input.next();
		map.remove(phoneNumber);
		Start();
	}

	//储存电话号码
	private void add() {
		System.out.println("请输入姓名");
		String name = input.next();
		System.out.println("请输入电话号码");
		String phoneNumber = input.next();
		
		map.put(phoneNumber,name);
		Start();
	}
}
