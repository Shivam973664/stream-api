package masterClass.Common;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class DebugStream {

	public static void main(String[] args) {
		Predicate<Student> s1 = (s) -> s.getGpa() >= 3.9;
		Predicate<Student> s2 = (s) -> s.getGradeLevel() > 3;

		Map<String, List<String>> map = StudentDataBase.getAllStudents().stream().peek(s -> {
			System.out.println("Elementstart : Initial peek");
			System.out.println(s);
			System.out.println("Elementend : Initial");
		}).filter(s1).peek(s -> {
			System.out.println("Elementstart : firstfilter");
			System.out.println(s);
			System.out.println("Elementend : firstfilter");
		}).filter(s2).peek(s -> {
			System.out.println("Elementstart : secondfilter");
			System.out.println(s);
			System.out.println("Elementend : secondfilter");
		}).collect(Collectors.toMap(Student::getName, Student::getActivities));

	}
}
