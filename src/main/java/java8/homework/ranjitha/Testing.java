package java8.homework.ranjitha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testing {

	public static void main(String[] args) {
		
		List<String> soldiersList = Arrays.asList("1","2","3","4","5");
		List<Integer> soldiersListi = Arrays.asList(1,2,3);
//		soldiersList.forEach(x->System.out.println(soldiersList.indexOf(x)+1));

		Predicate<Integer> isOdd = Predicate.not(x->x.equals("10"));
//		soldiersList.stream().filter(x->isOdd.test(x)).forEach(x->System.out.println(x));
		
		Predicate<String> isEvenIndex = str -> (soldiersList.indexOf(str)+1)%2 == 0;
		List<String> soldiersList1 = new ArrayList<>();
		soldiersList1 = soldiersList.stream().filter(Predicate.not(isEvenIndex)).collect(Collectors.toList());
		soldiersList1.forEach(x->System.out.print(x));
		Collections.rotate(soldiersList1, 1);
//		soldiersList.stream().filter(isEvenIndex).forEach(x->System.out.println(x));
		System.out.println();
		soldiersList1.forEach(x->System.out.print(x));
		

	}

}
