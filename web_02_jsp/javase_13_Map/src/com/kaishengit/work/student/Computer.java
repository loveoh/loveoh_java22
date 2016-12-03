package com.kaishengit.work.student;

import java.util.Scanner;

/**
 * ϵͳ����˵�
 * @author loveoh
 *
 */
public class Computer {
	
	private DataBase data = DataBase.getInstance();
	private Scanner input = new Scanner(System.in);

	
	 public void start(){
		System.out.println("1.¼��");
		System.out.println("2.��ѯ");
		System.out.println("3.�޸�");
		System.out.println("4.ɾ��");
		System.out.println("5.ͳ��");
		System.out.println("6.�˳�");
		System.out.println("��ѡ��");
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
			System.out.println("�������,����������");
			start();
		}
		
		
	}
	 
	 /**
	  * ͳ��
	  */
	 private void avgScore() {
		 data.avgScore();
		
	}

	/**
	  * ɾ��
	  */
	 private void remove() {
		System.out.println("������Ҫɾ����ѧ��");
		String number = input.next();
		data.remove(number);
		
		
	}

	/**
	  * �޸�
	  */
	private void mofifation() {
		System.out.println("������ѧ��");
		String number = input.next();
		data.mofifation(number);
		start();
		
	}

	private void inquire() {
		System.out.println("�������ѯ��ѧ��");
		String number = input.next();
		
		data.inquire(number);
		start();
	}

	private void add() {
		System.out.println("������ѧ��");
		String number = input.next();
		System.out.println("����������");
		String name = input.next();
		System.out.println("����������");
		int age = input.nextInt();
		System.out.println("������ɼ�");
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
