package java8.homework.one;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class ExcersiseOne {

	public static void main(String[] args) {

		String[] input = { "Mercury", "Venus", "Mars"};
//		 Stream<String> stream1 = Arrays.stream(input);
		 
		 String joinedString = String.join(",", input);
		 System.out.println("Planets:"+joinedString);
		 System.out.println(new Date());
	
	
	}

}
