package abc.test;



import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SyncheronRound1 {

	public static void main(String[] args) {
		helper();
	}

	private static void helper() {
		
		String name="sujeet";
		Character c=name.chars(). ///Intstream(char)
				mapToObj(a-> (char)a). // Stream<Character>
				collect(Collectors.groupingBy(Function.identity(),LinkedHashMap:: new,Collectors.counting()))
				//Map<Character,Long>
		.entrySet().stream()//Stream<Map.Entry<Character,Long>
		.filter(a-> a.getValue()==1).// duplicate characters
		map(a-> a.getKey()). // Stream<Map.Entry<Character,Long> to Stream<Character>
		findFirst(). //finding first element
		orElseThrow(); //throwing error
		System.out.println(c);
	}
}
