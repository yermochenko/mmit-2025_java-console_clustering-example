package by.vsu.mmit.stud.distance;

import by.vsu.mmit.stud.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDistanceCalculatorTest {
	private List<Student> students;
	@BeforeEach
	void setUp() {
		students = List.of(
			stud("stud01", Map.ofEntries(
				Map.entry("subj1", 5),
				Map.entry("subj2", 6),
				Map.entry("subj3", 7),
				Map.entry("subj4", 6)
			)),
			stud("stud02", Map.ofEntries(
				Map.entry("subj1", 7),
				Map.entry("subj2", 8),
				Map.entry("subj3", 8),
				Map.entry("subj4", 4)
			)),
			stud("stud03", Map.ofEntries(
				Map.entry("subj2", 6),
				Map.entry("subj3", 7)
			)),
			stud("stud04", Map.ofEntries(
				Map.entry("subj1", 6),
				Map.entry("subj4", 7)
			)),
			stud("stud05", Map.ofEntries(
				Map.entry("subj1", 7),
				Map.entry("subj2", 8),
				Map.entry("subj3", 8),
				Map.entry("subj4", 4)
			)),
			stud("stud06", Map.ofEntries(
				Map.entry("subj1", 7),
				Map.entry("subj3", 8),
				Map.entry("subj4", 4)
			))
		);
	}

	@Test
	void distance12() {
		double distance = new StudentDistanceCalculator().distance(students.get(0), students.get(1));
		assertEquals(3.60555, distance,0.00001);
	}

	@Test
	void distance1221() {
		double distance1 = new StudentDistanceCalculator().distance(students.get(0), students.get(1));
		double distance2 = new StudentDistanceCalculator().distance(students.get(1), students.get(0));
		assertEquals(3.60555, distance1,0.00001);
		assertEquals(3.60555, distance2,0.00001);
	}

	@Test
	void distance16() {
		double distance = new StudentDistanceCalculator().distance(students.get(0), students.get(5));
		assertEquals(6.708204, distance,0.00001);
	}

	@Test
	void distance34() {
		double distance = new StudentDistanceCalculator().distance(students.get(2), students.get(3));
		assertEquals(13.038405, distance,0.00001);
	}

	@Test
	void distance25() {
		double distance = new StudentDistanceCalculator().distance(students.get(1), students.get(4));
		assertEquals(0.0, distance,0.00001);
	}

	private Student stud(String name, Map<String, Integer> grades) {
		Student student = new Student();
		student.setName(name);
		student.setGrades(grades);
		return student;
	}
}
