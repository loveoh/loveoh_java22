package com.kaishengit.work;

import java.util.HashMap;
import java.util.Scanner;

public class Phone {
	
	private HashMap<String ,String> map = new HashMap<String,String>();
	
	Scanner input = new Scanner(System.in);
	
	
	public void Start(){
		System.out.println("1.��Ӻ���");
		System.out.println("2.ɾ������");
		System.out.println("3.��ѯ����");
		System.out.println("��ѡ��");
		
		int index = input.nextInt();
		if(1 == index) {
			add();
				
		}else if(2 == index) {
			remove();
			
		}else if(3 == index) {
			inquire();
		}else{
			System.out.println("�������");
			System.exit(0);
		}
		
	}

	private void inquire() {
		System.out.println("������绰����");
		String phoneNumber = input.next();
		String name = map.get(phoneNumber);
		System.out.println("��ѯ���û�Ϊ:" + name);
		Start();
		
	}

	private void remove() {
		System.out.println("������绰����");
		String phoneNumber = input.next();
		map.remove(phoneNumber);
		Start();
	}

	//����绰����
	private void add() {
		System.out.println("����������");
		String name = input.next();
		System.out.println("������绰����");
		String phoneNumber = input.next();
		
		map.put(phoneNumber,name);
		Start();
	}
}
