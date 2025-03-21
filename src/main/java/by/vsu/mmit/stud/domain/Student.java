package by.vsu.mmit.stud.domain;

import java.util.Map;

public class Student {
	private String name;
	private Map<String, Integer> grades;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getGrades() {
		return grades;
	}

	public void setGrades(Map<String, Integer> grades) {
		this.grades = grades;
	}
}
