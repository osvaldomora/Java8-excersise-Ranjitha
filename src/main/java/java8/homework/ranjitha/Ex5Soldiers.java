package java8.homework.ranjitha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex5Soldiers {
	
	private static int iteration=1;
	
	public static void main(String[] args) {
	
		List<String> soldiersList = Arrays.asList("1","2","3","4","5","6");//,"3","4","5","6","7","8","9","10"
		System.out.println("Original array:"+soldiersList);
		System.out.println("if you want to survive you need to put yourself in the position: "+intStreamMethod(soldiersList).get(0));
	}
	
	private static List<String> intStreamMethod(final List<String> soldiersList) {
//		Predicate<Integer> isEven = i -> i % 2 == 0;
//		Predicate<Integer> isOdd = Predicate.not(isEven);

        /**
         * soldiersList.indexOf(str)+1) ->>> get the index of each element + 1 to start in position 1
         */
		Predicate<String> isEvenIndex = str -> (soldiersList.indexOf(str)+1)%2 == 0; //filter to get all even elements
		List<String> soldiersList1 = new ArrayList<>();
		
		if(soldiersList.size() == 2) return soldiersList; //Stop condition

		if(soldiersList.size() > 2) {
			/**
			 * Predicate.not(isEvenIndex) ->>> filter go get just the odds element 
			 * collect(Collectors.toList()) -->> convert the stream in a list, in this case the list of odd elements
			 */
		soldiersList1 = soldiersList.stream().filter(Predicate.not(isEvenIndex)).collect(Collectors.toList());
		}
		if(soldiersList.size()%2 != 0) {
			//if the list is odd the soldier in the last position is who has the sword so that´s why we need rotate
		Collections.rotate(soldiersList1, 1);
		}
		System.out.println("iteration:"+ iteration + "=" +soldiersList1);
		iteration++;
		
		soldiersList1 = intStreamMethod(soldiersList1);

		return soldiersList1;
		}

}
