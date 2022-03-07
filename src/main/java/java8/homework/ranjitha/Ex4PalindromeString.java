package java8.homework.ranjitha;

import java.util.stream.IntStream;
//check whether a given string is palindrome
public class Ex4PalindromeString {

	public static void main(String[] args) {

		String temp = "madam";//madam anita lava la tina
		String temp2  = temp.replaceAll("\\s+", "").toLowerCase();
//		System.out.println(temp2.length() / 2);
		boolean resp=IntStream.range(0, temp2.length() / 2)
	      .noneMatch(i -> temp2.charAt(i) != temp2.charAt(temp2.length() - i - 1));
		System.out.println(resp);
	      
	}

}
