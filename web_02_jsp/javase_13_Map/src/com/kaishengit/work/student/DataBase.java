package com.kaishengit.work.student;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {

	// �������ģʽ
	private DataBase() {
	}

	private static DataBase data = new DataBase();

	public static DataBase getInstance() {
		return data;
	}

	private ArrayList<Student> list = new ArrayList<Student>();

	private Scanner input = new Scanner(System.in);

	/**
	 * ��ӷ���
	 */
	public void add(Student student) {
		if (list.size() == 0) {
			list.add(student);
			System.out.println("��ӳɹ�");
		} else {
			for (Student stu : list) {
				if (student.getNumber().equals(stu.getNumber())) {
					System.out.println("��ѧ���Ѵ���,��˶�");

				} else {
					list.add(student);
					System.out.println("��ӳɹ�");
					break;
				}
			}
		}

	}

	/**
	 * ��ѯ
	 * 
	 * @param number
	 */
	public void inquire(String number) {
		for (Student stu : list) {
			if (number.equals(stu.getNumber())) {
				System.out.println(stu);
				break;
			} else {
				System.out.println("��ѧ��������");
			}

		}

	}

	/**
	 * �޸�
	 * 
	 * @param number
	 */
	public void mofifation(String number) {
		Student s;
		for (Student stu : list) {
			if (number.equals(stu.getNumber())) {
				s = stu;
				System.out.println("1.�޸�ѧ��'\\n'2.�޸�����\\n3.�޸�����\\n4.�޸ĳɼ�");
				int index = input.nextInt();
				if (1 == index) {
					System.out.println("����������ѧ��");
					String newNumber = input.next();
					s.setNumber(newNumber);

				} else if (2 == index) {
					System.out.println("��������������");
					String name = input.next();
					s.setName(name);
				} else if (3 == index) {
					System.out.println("��������������");
					int age = input.nextInt();
					s.setAge(age);
				} else if (4 == index) {
					System.out.println("����������ɼ�");
					int score = input.nextInt();
					s.setScore(score);

				} else {
					System.out.println("��������");
					mofifation(number);
				}
				break;
			} else {
				System.out.println("��ѧ��������");
				break;
			}

		}
		
	}

	/**
	 * ɾ��
	 * 
	 * @param number
	 */
	public void remove(String number) {

		for (Student s : list) {
			if (number.equals(s.getNumber())) {
				list.remove(s);
			} else {
				System.out.println("��ѧ��������");
			}
		}
	}

	/**
	 * ��ƽ���ɼ�
	 */
	public void avgScore() {
		int sum = 0;
		for (Student s : list) {
			int score = s.getScore();
			sum += score;
		}
		int num = list.size();

		int avg = sum / num;
		System.out.println("ѧ��ƽ���ɼ�Ϊ:" + avg);

	}

}
