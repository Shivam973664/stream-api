package masterClass.interviewPractices;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

//Link : https://www.linkedin.com/posts/japneet-sachdeva_japneetsachdeva-activity-7308502660981145600-1Y4f/?utm_medium=ios_app&rcm=ACoAACQWW8oB3w0y2v8EZoti9kvKB_AITkbofYs&utm_source=social_share_video_v2&utm_campaign=whatsapp
public class LinkedInStreamAPIQuestions {

	public static void main(String[] args) {
		PersonInterview p1 = new PersonInterview();
		PersonInterview p2 = new PersonInterview();
		System.out.println(p1.equals(p2));
		System.out.println(p1==p2);
		
		Optional<Integer> res = List.of(2,4,6,8,10).stream().filter(n-> n>4).map(n-> n*2)
				.reduce((a,b)-> a-b);
		System.out.println(res.get());
	}

	
	public static void sortArrayInReverseOrder() {
		List<Student> list = StudentDataBase.getAllStudents()
				.stream().sorted(Comparator.comparing(Student::getGpa))
				.collect(Collectors.toList());
						
	}
}
