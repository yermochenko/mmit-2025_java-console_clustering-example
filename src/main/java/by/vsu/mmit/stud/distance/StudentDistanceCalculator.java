package by.vsu.mmit.stud.distance;

import by.vsu.mmit.haca.distance.DistanceCalculator;
import by.vsu.mmit.stud.domain.Student;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentDistanceCalculator implements DistanceCalculator<Student> {
	@Override
	public double distance(Student a, Student b) {
		Map<String, Integer> aGrades = a.getGrades();
		Map<String, Integer> bGrades = b.getGrades();
		Set<String> subjects = new HashSet<>();
		subjects.addAll(aGrades.keySet());
		subjects.addAll(bGrades.keySet());
		double sum = 0;
		for(String subject : subjects) {
			Integer aGrade = aGrades.get(subject);
			aGrade = aGrade != null ? aGrade : 0;
			Integer bGrade = bGrades.get(subject);
			bGrade = bGrade != null ? bGrade : 0;
			sum += (aGrade - bGrade) * (aGrade - bGrade);
		}
		return Math.sqrt(sum);
	}
}
