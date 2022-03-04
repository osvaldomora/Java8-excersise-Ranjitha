package java8.homework.ranjitha;

import java.util.stream.IntStream;
//check whether a given string is palindrome
public class Ex4PalindromeString {

	public static void main(String[] args) {

		String temp = "madams";//madam
//		String temp  = input.replaceAll("\\s+", "").toLowerCase();
		boolean resp=IntStream.range(0, temp.length() / 2)
	      .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
		System.out.println(resp);
	

	}

}
