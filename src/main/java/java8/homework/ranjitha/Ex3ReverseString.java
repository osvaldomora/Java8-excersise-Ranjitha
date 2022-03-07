package java8.homework.ranjitha;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
//reverse the given string
public class Ex3ReverseString {

	public static void main(String[] args) {

		String input = "application";
  
		//noitaclippa
		
		String reversed2 = input.chars()
			    .mapToObj(c -> (char)c)
			    .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);//identity, accumulator,combiner
		

		
		String reversed = input.chars()
				.mapToObj(c -> (char)c) 
			    .reduce("", new BiFunction<String, Character, String>() {

					@Override
					public String apply(String t, Character u) {
//						System.out.println(u);
//						System.out.println(t);
						
						// TODO Auto-generated method stub
						return u+t;
					}
			    	
				}
			    , new BinaryOperator<String>() {

					@Override
					public String apply(String t, String u) {
						// TODO Auto-generated method stub
						System.out.println(t);
						System.out.println(u);
						return "";//t+u noitacilppa
					}
			    	
				});
		
		System.out.println(reversed2);


	

	}

}
