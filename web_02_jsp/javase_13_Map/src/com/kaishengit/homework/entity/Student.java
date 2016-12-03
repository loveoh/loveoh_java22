package com.kaishengit.homework.entity;

public class Student {

	private String number;
	
	private String name;
	private int age;
	private int score;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String number, String name, int age, int score) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + score;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "学号:" + number + ", 姓名:" + name + ", 年龄:" + age + ", 分数:" + score;
	}
	
	
}
