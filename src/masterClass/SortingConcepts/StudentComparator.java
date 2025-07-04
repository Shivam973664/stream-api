package masterClass.SortingConcepts;

import java.util.Comparator;

import diliptraining.entities.Student;

public class StudentComparator implements Comparator<Student>{

	public int compare(Student s1,Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
	
	
}
