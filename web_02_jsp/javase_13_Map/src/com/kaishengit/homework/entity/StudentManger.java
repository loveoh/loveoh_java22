package com.kaishengit.homework.entity;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentManger {

	private Scanner input = new Scanner(System.in);
	private ArrayList<Student> list = new ArrayList<Student>();

	public void start() {
		System.out.println("1.¼��");
		System.out.println("2.��ѯ");
		System.out.println("3.�޸�");
		System.out.println("4.ɾ��");
		System.out.println("5.ͳ��");
		System.out.println("6.�˳�");
		System.out.println("��ѡ��");
		int index = input.nextInt();

		if (1 == index) {
			System.out.println("������ѧ��");
			String number = input.next();
			// ���÷���,�ж�ѧ���Ƿ����
			Student s = findByName(number);
			if (s == null) {
				add(number);
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("��ѧ���ѱ�ռ��");
			}
			start();

		} else if (2 == index) {
			System.out.println("������ѧ��");
			String number = input.next();
			Student s = findByName(number);

			if (s == null) {
				System.out.println("���޴���");
			} else {
				System.out.println(s);
			}
			start();
		} else if (3 == index) {
			System.out.println("������ѧ��");
			String number = input.next();
			Student s = findByName(number);
			boolean flag = false;
			if (s == null) {
				System.out.println("���޴���");
			} else {
				System.out.println("��Ҫ�޸�������?Y|N?");
				String answer = input.next();
				if ("y".equalsIgnoreCase(answer)) {
					System.out.println("������������");
					String newName = input.next();
					s.setName(newName);
					flag = true;
				}

				System.out.println("��Ҫ�޸�������?Y|N?");
				answer = input.next();
				if ("y".equalsIgnoreCase(answer)) {
					System.out.println("������������");
					int newAge = input.nextInt();
					s.setAge(newAge);
					flag = true;
				}

				System.out.println("��Ҫ�޸ĳɼ���?Y|N?");
				answer = input.next();
				if ("y".equalsIgnoreCase(answer)) {
					System.out.println("�������³ɼ�");
					int newScore = input.nextInt();
					s.setScore(newScore);
					flag = true;
				}
				if (flag) {
					System.out.println("�޸ĳɹ�");
				}
			}
			start();
		} else if (4 == index) {
			System.out.println("������ѧ��");
			String number = input.next();
			Student s = findByName(number);

			if (s == null) {
				System.out.println("���޴���");
			} else {
				list.remove(s);
				System.out.println("ɾ���ɹ�");
			}
			start();

		} else if (5 == index) {
			double sum = 0.0;
			for (Student s : list) {
				sum += s.getScore();
			}
			double ave = sum / list.size();
			System.out.println("ѧ����ƽ���ɼ�Ϊ:" + ave);
			start();
		} else if (6 == index) {
			System.exit(0);
		} else {
			System.out.println("�������");
			start();
		}
	}

	/**
	 * ��ӷ���
	 * 
	 * @param number
	 */
	private void add(String number) {
		System.out.println("����������");
		String name = input.next();
		System.out.println("����������");
		int age = input.nextInt();
		System.out.println("������ɼ�");
		int score = input.nextInt();

		Student s = new Student(number, name, age, score);

		list.add(s);

	}

	/**
	 * �ж�ѧ���Ƿ����
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
