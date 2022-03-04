package java8.homework.ranjitha;

import java.util.function.BiFunction;
//rotate string
public class Ex2RoutString {

	public static void main(String[] args) {

		String input = "application";

		int displacement = 3;
		BiFunction<String, String, String> biF = (st1, st2) -> st1 + st2;
		String s1 = input.substring(displacement);
		String s2 = input.substring(0, displacement);

		System.out.println(biF.apply(s1, s2));

	}

}
