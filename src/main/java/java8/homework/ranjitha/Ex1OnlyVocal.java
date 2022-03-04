package java8.homework.ranjitha;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;
//Given a string print every third character only if it a vowel
public class Ex1OnlyVocal {

	public static void main(String[] args) {

		String input = "asanloiplos";
		AtomicInteger count = new AtomicInteger(1);
		StringBuilder st = new StringBuilder();
		Stream<Character> characterStream = input.chars().mapToObj(c -> (char) c);

		Predicate<Character> vow= ch ->( ch.equals('a') || ch.equals('e') || ch.equals('i') || ch.equals('o') || ch.equals('u'));
//		BiPredicate<Integer,Character> vow= (inc,ch) ->(inc % 3) && ( ch.equals('a') || ch.equals('e') || ch.equals('i') || ch.equals('o') || ch.equals('u'));

		characterStream.forEach(x -> {

			if (count.get() % 3 == 0
					&& vow.test(x)) { 
//				System.out.print(x);
				st.append(x);

			}

			count.getAndIncrement();
		});

		System.out.println(st.toString());
	}

}
