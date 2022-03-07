package java8.homework.one;

import java.util.Arrays;
import java.util.function.Predicate;

public class ExcersiseOne { //output: planets:Mercury,Venus,Mars

	public static void main(String[] args) {
		String[] input = { "Mercury", "Venus", "Mars"};
        Predicate<String> pr= x->x.equals("planets:");
		
		String st=  Arrays.stream(input).reduce("planets:",(s1,s2)->{
			if(pr.test(s1))
				return s1+s2;
			
            return s1+","+s2;
			
		});
		System.out.println(st);
		 

	
	
	}

}
