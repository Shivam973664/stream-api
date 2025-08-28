package masterClass.interviewPractices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import data.StudentDataBase;
import diliptraining.entities.Student;
import masterClass.SortingConcepts.Employee;

public class TestOne {
	static List<Integer> list = List.of(1, 3, 5,3, 1, 3, 6, 7, 2, 7, 9, 10, 9, 9, 9, 13);

	static List<Integer> list2 = Arrays.asList(1,3,54365,75,43);
	static List<String> nameList = Arrays.asList("Shivam", "Shivam", "Sujeet", "Sachin", "Krishna", "SAS",
			"Indra");
	
	static  List<String> emails = Arrays.asList("singhshivam1705@gmail.com","shiva@tcs.com","shivam.KumarSing@google.com","shivam.Singh@flipkart.com");


	//Question : 1
	public static void printKfrequentElementIntheList() {
//		Map<Integer,List<Integer>> map1 = list.stream().collect(Collectors.groupingBy(Integer:: valueOf));
//		map1.forEach((a,b)-> System.out.println(a +" " +b));
		list.stream().collect(Collectors.groupingBy(Integer::valueOf, Collectors.reducing(0, (a, b) -> a + 1)))
				.entrySet().stream().sorted((a, b) -> a.getValue() > b.getValue() ? -1 : 1).limit(3)
				.map(a -> a.getKey()).forEach(a -> System.out.println(a));
//				 ).entrySet().stream().sorted(); it will not work since stream is map
		// by standard way

		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted((a, b) -> a.getValue() > b.getValue() ? -1 : 1).limit(3).map(Map.Entry::getKey)
				.forEach(a -> System.out.println(a));

	}

	//Question 7:
	public static void groupingByMultipleFields() {
		// it will create Key String and value of map
		Map<String, Map<String, List<Student>>> map = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getGender)));
		// it will create key of ListString and value of Student
		Map<List<String>, List<Student>> map2 = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.groupingBy(a -> Arrays.asList(a.getName(), a.getGender())));
		System.out.println("First group by by different groups");
		for (Map.Entry<String, Map<String, List<Student>>> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());

		}
		System.out.println("First group by by different groups end");
		map2.forEach((a, b) -> System.out.println(a + " " + b));

	}

	public static void groupingByListOfIntegerUsingParallelstream() {
		Map<Integer, Long> map = list.parallelStream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((a, b) -> System.out.println(a + " " + b));

		System.out.println("Normal Map is over");
		// by concurrent grouping By
		// we can use Map in place of ConcurrentMap
		ConcurrentMap<Integer, Long> conCurrentMap = list.parallelStream()
				.collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
		conCurrentMap.forEach((a, b) -> System.out.println(a + " " + b));
	}

	//11
	public static void findingCommonElementsBetweenTwoListUsingStream() {
		List<Integer> list2 = List.of(1, 9, 11, 44, 66, 22, 55);
		List<Integer> result = list.stream().filter(a -> list2.contains(a)).distinct().collect(Collectors.toList());

		// pdf way
		list.stream().filter(list2::contains).distinct().collect(Collectors.toList());

		result.forEach(System.out::println);
	}

	//12
	public static void createMapFromStringKeyisStringValueisLength() {
		// here we have use grouping by
		Map<String, List<Integer>> map = nameList.stream().collect(
				Collectors.groupingBy(Function.identity(), Collectors.mapping(a -> a.length(), Collectors.toList())));
		map.forEach((a, b) -> System.out.println(a + "" + b));
		
		
//		Map<String, Long> map1 = nameList.stream().collect(
//				Collectors.groupingBy(Function.identity(), Collectors.mapping(a -> a.length(), Collectors.reducing((a,b)-> a),0)));
//		map1.forEach((a, b) -> System.out.println(a + "" + b));
		
		// but it will create list of values which is wrong
		
		

		// we use map
		Map<String, Integer> map2 = nameList.stream().collect(Collectors.toMap(Function.identity(), String::length));
		map2.forEach((a, b) -> System.out.println(a + b));
	}

	public static void findProduct() {
		System.out.println(list.stream().reduce(1, (a, b) -> a * b));
	}

	
	//14
	public static void partitionStudent() {
		StudentDataBase.getAllStudents().stream().collect(Collectors.partitioningBy(a -> a.getGpa() > 3.7))
				.forEach((a, b) -> System.out.println(a + " " + b));
		StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(a -> a.getGpa() > 3.7))
		.forEach((a, b) -> System.out.println(a + " " + b));
		
//		StudentDataBase.getAllStudents().stream().collect(Collectors.partitioningBy(Student :: getGpa));// error 
	}

	//15
	public static void sortingSequentially() {
		StudentDataBase.getAllStudents().stream().sorted(
				Comparator.comparing(Student::getGpa).thenComparing(Student::getName, Comparator.reverseOrder()))
				.forEach(a -> System.out.println(a));
		System.out.println(" ");
		StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder())).forEach(System.out :: println);

		//salary decreasing
		//departmentList.stream().sorted(Comparator.comparing(DepartMent::getdepartmentName).
//		thenComparing(Department :: getSalary,Comparator.reverseOrder())).collect(Collectors.toList());
	
	}
	
	///group books by author and then by gener
	// books.stream().collect(Collectors.groupingBy(
//	Book :: getAuthorName,Collectors.groupingBy(Book :: getGener)));

	//18
	public static void countFIlesByFilesExtension() {
		// ListfilesList.stream().collect(Collectors.groupingBy(Files::getExtension,Collectors.counting());
	}

	//19
	public static void consumerMoreThanThreePurchases() {
		// consumerList.stream().filter(a->
		// a.getPurchase()>3).collect(Collectors.toList());
		// question : purchase list : in this list we have customer object
		// now find customers more than three purchases
		// purchases.stream().collect(Collectors.groupingBy(Purchases::getCustomer,Collectors.counting))
		// .entrySet().stream().filter(a -> a.getValue()>3).map(a->
		// a.getKey()).collect(Collectors.toList());
	}
	//customerList.stream().filter(a-> a.getpurchases>3).collect(Collectors.toList());
	//orderList.Stream().collect(Collectors.groupingBy(Order:: customerId,Collectors.counting()))
	//.entrySet().stream().filter(a-> a.getValue()>3).map(a-> a.getKey()

	//20
	public static void converDateToStringInFormat() {
		/// listOFDate.stream().map(a-> {SimpleDateFormat sm = new
		/// SimpleDateFormat("dd-mm-yyyy");
//		String date = sm.format(a);
//		return date;
//		}
//		).collect(Collectors.toList());

		DateTimeFormatter dm = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDateTime currentDate = LocalDateTime.now();
		System.out.println(currentDate.format(dm));
	}

	public static boolean isPrime(Integer num) {
		int divisor = 2;
		while (divisor < num / 2) {
			if (num % divisor == 0) {
				return false;
			}
			divisor++;
		}
		return true;

	}

	//21
	public static void filterOutNonPrimeNumberS() {
		list.stream().filter(a -> isPrime(a)).forEach(System.out::println);
	}

	//22
	public static void longestStringIntheList() {
		String ans = nameList.stream().reduce("", (a, b) -> a.length() > b.length() ? a : b);

//		String ans2= nameList.stream().max((a,b)-> a.length()>b.length() ? 1 : -1).get();
		String ans2 = nameList.stream().max(Comparator.comparing(String::length)).get();
		System.out.println(ans2);
		System.out.println(ans);
	}

	
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	//24
	public static void findAllPalindromeIntheList() {
		nameList.stream().filter(a -> isPalindrome(a)).forEach(System.out::println);
		nameList.stream().filter(a -> a.equalsIgnoreCase(new StringBuilder(a).reverse().toString()))
				.forEach(System.out::println);
		;
	}

	//25
	public static void groupEmployeesByTeamANdThenTeamSize() {
		// employeeList.stream().collect(Collectors.groupingBy(Employee::
		// getTeamSize,Collectors.groupingBy(Employee :: getTeamSize));
	}

	//26
	public static void normalizeandDeduplicateEmails() {
		nameList.stream().distinct().forEach(System.out::println);
	}

	//27
	public static void getAllStudentWhoseNameStartsANdENdsWithVowels() {
		List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
		nameList.stream()
				.filter(a -> vowels.contains(Character.toLowerCase(a.charAt(0)))
						&& vowels.contains(Character.toLowerCase(a.charAt(a.length() - 1))))
				.forEach(System.out::println);
	}

	//28
	public static void sumtheListOfNestedStructure() {
		int i = 0;
		long res = StudentDataBase.getAllStudents().stream().flatMap(a -> a.getActivities().stream()).count();
		System.out.println(res);
	}

	//29
	public static void getLatestAndEarliestTransactionDate() {
		List<LocalDate> dates = List.of(LocalDate.of(2012, 12, 1), LocalDate.of(2012, 12, 1), LocalDate.of(2013, 12, 1),
				LocalDate.of(2003, 12, 1));
		LocalDate minDate = dates.stream().min((a, b) -> a.compareTo(b) > 1 ? 1 : -1).get();
		LocalDate maxDate = dates.stream().max((a, b) -> a.compareTo(b) > 1 ? 1 : -1).get();
		System.out.println("Min Date : " + minDate.toString() + " Max Date : " + maxDate.toString());
	}

	//30
	public static void convertComaseparatedField() {
		String ans = nameList.stream().collect(Collectors.joining(","));
		System.out.println(ans);
	}

	//31
	public static void generateStreamOfAllSubstringOfString() {
		String ans = "abc";

	}

	//32
	public static void digitCountOfNumber() {
		Map<Integer, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((a, b) -> System.out.println(a + " " + b));

//		Map<Integer, Long> digitCount = list.stream()
//				.flatMap(n -> String.valueOf(n).chars().mapToObj(c -> c - '0'))
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(digitCount);

		// by way

		list.stream().flatMap(a -> a.toString().chars().mapToObj(c -> c - '0'))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.forEach(System.out::println);
		;

	}
	

	//33
	public static void partitionStringByLength() {
//		Map<Boolean,Map<Boolean,List<String>>> result = nameList.stream().collect(Collectors.partitioningBy(a-> a.length()<4,Collectors.partitioningBy(a-> a.length() <6)));
		Map<String, List<String>> map = nameList.stream().collect(Collectors.groupingBy(a -> {
			if (a.length() < 4) {
				return "short";
			} else if (a.length() >= 4 && a.length() <= 5) {
				return "medium";
			} else {
				return "long";
			}
		}));

		System.out.println(map);

	}

	//34
	public static void findRepeatedCharacterInString() {
		String ex = "aabcdoebkljdlm";
		ex.chars().mapToObj(a -> Character.valueOf((char) a))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(a -> a.getValue() > 1).map(a -> a.getKey()).forEach(System.out::println);
	}

	//35
	public static void zippedTwoList() {
		List<String> list1 = Arrays.asList("a", "b", "c");
//		List<String> list1 = Arrays.asList("a", "a", "c");
		List<Integer> list2 = Arrays.asList(1, 2, 3);

		Map<String, Integer> map = IntStream.range(0, list1.size()).boxed() // so that we can access stream meathods of
																			// Object
				.collect(Collectors.toMap(a-> list1.get(a), list2::get, (existing, replacement) -> replacement));
		// By providing a merge function, you instruct the collector on how to handle
		// duplicate keys, preventing the IllegalStateException .
		map.forEach((a, b) -> System.out.println(a + b));

	}

	//36
	public static void findFirstDuplicateRecurringElement() {
//		String name = nameList.stream().findFirst().get();
//		System.out.println(name);
//		Set<String> sets ;
		
		Set<Integer> sets = new HashSet<>();
		Integer number2 = list.stream().filter(a-> !sets.add(a)).findFirst().get();
		sets.clear();
		Integer number = list.stream().filter(a -> {
//			sets= new HashSet<>(); error because we can't modify the value of the local variable
			if(sets.contains(a)) {
				return true;
			}
			sets.add(a);
			return false;
			
		}).findFirst().get();
		
		
		
		System.out.println(number + "  " + number2);
	}

	//37
	public static void findUniqueDomains() {
		emails.stream().map(a-> {
			String []arr= a.split("@");
			if(arr.length<0) {
				return "";
			}else {
				return arr[1];
			}
		}).distinct().filter(a-> !a.equals("")).forEach(System.out :: println);
		
		emails.stream().map(a-> a.substring(a.indexOf('@') +1)).distinct().forEach(System.out :: println);
	}
	
	//38
	public static void findLongestPrefixUsingStreamAPI() {
		String ans= nameList.stream().reduce((a,b)-> {
			int i =0;
			while(i<a.length()&& i<b.length() && a.charAt(i)==b.charAt(i)) {
				i++;
			}
			return a.substring(0,i);
		}).orElse("");
		System.out.println(ans);
	}
	
	//39
	public static void varianceOfAnList() {
		double avg = list.stream().mapToDouble(a-> a).average().orElse(0);
		list.stream().mapToDouble(a-> Math.pow(a-avg,2)).forEach(System.out :: println);;
	}
	
	//40
	public static void findTop3LargestStringInPara() {
		String paragraph = "Today I learned many thing but focus is not there if focus would there I might done many things";
		String []parArray= paragraph.split(" ");
		Arrays.stream(parArray).distinct().sorted((a,b)-> a.length()<b.length()? 1: -1).limit(3).forEach(System.out::println);
	}
//	public static void findThreeLongestWords() {
//		nameList.collect(Collectors.groupingBy(Function.identity(),Collectors.counting(),Collectors.
//				))
//	}
	
	/// *** Chat Gpt Top 10 Interview Questions 
	
	//1. Find the second highest number in a list
	public static void secondHighestNumber(List<Integer> list) {
		Integer ans= list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
		System.out.println(ans);
	}
	
	
//	2. Find duplicate elements in a list
	public static void duplicateElement(List<Integer> list) {
		list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(a -> a.getValue()>=2).
		forEach((c)-> System.out.println(c.getKey()));
	}
	
	
	//3. Count frequency of each character in a string
	public static void countFrequency(String str) {
		str.chars().mapToObj(c-> (char)c).
		collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().forEach(System.out :: println);
	}
	
	
	//Q4. Find the first non-repeated character in a string
	public static void findFirstNonRepeatedCharacter(String input) {
		Character just= input.chars().mapToObj(c-> (char)c).
		collect(Collectors.groupingBy(Function.identity(),LinkedHashMap:: new,Collectors.counting()))
		.entrySet().stream().filter(a-> a.getValue()==1).map(a-> a.getKey()).findFirst().orElse('A');
		System.out.println(just);
	}
	
	//Q5 : Find the maximum element in a list
	public static void findMax(List<Integer> input) {
		Integer max= input.stream().max((a,b)-> a.compareTo(b)).orElse(0);
		System.out.println(max);
	}
	
	
	//Q6 : Sort a list of strings by length
	public static void sortStringListByLength(List<String> list){
		List<String> rest = list.stream().sorted(Comparator.comparing(String :: length,Comparator.reverseOrder())).collect(Collectors.toList());
		rest.forEach(System.out :: println);
	}
	
	//Q7. Find the sum of all even numbers in a list
	public static void findSumOfEvenNumbers(List<Integer> input ){
//		int sum = input.stream().filter(a-> a%2==0).reduce(0,Integer :: sum);
//		System.out.println(sum);
		System.out.println(input.stream().mapToInt(Integer :: intValue).sum());
	}
	
	//Q8. Group employees by department
	public static void grpEmployeeByDepartment(){
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee(1, "yoo yo", null, 0, null, "Singer", 2020, 200);
		Employee emp2 = new Employee(2, "honey", null, 0, null, "Singer", 2020, 200);
		Employee emp3 = new Employee(3, "Minato", null, 0, null, "Leaf", 2020, 200);
		Employee emp4 = new Employee(4, "kakashi", null, 0, null, "Leaf", 2020, 200);
		empList.addAll(Arrays.asList(emp1,emp2,emp3,emp4));
		Map<String,List<Employee>> map =empList.stream().collect(Collectors.groupingBy(Employee ::getDepartment));
		map.forEach((a,b)-> System.out.println(a + " " + b));
	}
	
	//Q9 : Find the longest string in a list
	public static void longestStringIntheList(List<String> input){
		String res = input.stream().reduce("", (a,b)-> a.length()> b.length() ? a : b);
		System.out.println(res);
	}
	
	//Q10 : Find common elements between two lists
	public static void commonBetweenList(List<Integer> input1 , List<Integer> input2){
//		input1.stream().filter(a-> input2.contains(a)).forEach(System.out :: println);
		input1.stream().filter(input2 :: contains).forEach(System.out :: print);

	}
	
	public static void main(String[] args) {
//		printKfrequentElementIntheList();
//		groupingByMultipleFields();
//		groupingByListOfIntegerUsingParallelstream();
//		findingCommonElementsBetweenTwoListUsingStream();
//		createMapFromStringKeyisStringValueisLength();
//		findProduct();
//		partitionStudent();
//		sortingSequentially();
//		managerList.stream().filter(a-> "CSE".equals(a.getName())).collect(Collectors.toList());
//		17. Group books by author and then by genre
//		bookList.stream().collect(Collectors.groupingBy(Book::getAuthorName,
//		Collectors.groupingBy(Book::genre));

//		bookList.stream().collect(Collectors.groupingBy(a-> Arrays.asList<>(a.getAuthorName,a.getgener))

//	now new things
//		converDateToStringInFormat();
//		filterOutNonPrimeNumberS();
//		longestStringIntheList();
//		findAllPalindromeIntheList();
//		normalizeandDeduplicateEmails();
//		getAllStudentWhoseNameStartsANdENdsWithVowels();
//		sumtheListOfNestedStructure();
//		getLatestAndEarliestTransactionDate();
//		convertComaseparatedField();
//		digitCountOfNumber();
//		partitionStringByLength();
//		findRepeatedCharacterInString();
//		zippedTwoList();
//		findFirstDuplicateRecurringElement();
//		findUniqueDomains();
//		findLongestPrefixUsingStreamAPI();
//		varianceOfAnList();
//		findTop3LargestStringInPara();
//		commonBetweenList(list2, list);
//		longestStringIntheList(nameList);
//		grpEmployeeByDepartment();
//		findSumOfEvenNumbers(list);
//		sortStringListByLength(nameList);
//		findMax(list);
//		findFirstNonRepeatedCharacter("yydiksudds");
//		countFrequency("djsjd");
//		duplicateElement(list);
		secondHighestNumber(list);
		
	}
}
