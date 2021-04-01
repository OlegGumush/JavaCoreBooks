package Chapter_01_StreamOperation;

import static Chapter_01_StreamOperation.Stream_01_Creation.show;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Stream_04_Distinct_Sorted_Peek {

	public static void main(String[] args) {

		// distinct method returns 
		Stream<String> distinctStream = Stream.of("6","1","7","1","2", "1").distinct();    show(distinctStream);
		
		
		// sorted        
		Stream<Integer> sortedList = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8).stream().sorted();          show(sortedList);
        
		Stream<Integer> sortedList1 = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8).stream().sorted(Comparator.reverseOrder());           show(sortedList1);
        
		Stream<Integer> sortedList2 = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8).stream().sorted((i1, i2) -> i1.compareTo(i2));       show(sortedList2);

		Stream<String> sortedList3 = Arrays.asList("a","sdfsdf", "bbb").stream().sorted(Comparator.comparing(String::length).reversed()); show(sortedList3);
		
		
		// peek return another stream with the same elements as the original but a function is invoked every time an element is retrieved.
		Stream<Integer> peekStream = Stream.iterate(1, n -> n * 2).peek(e ->   System.out.println(e)).limit(20);   show(peekStream);
		
		// That is handy for debugging we can put break point inside a peek method like this.
		//.peek(x-> {
		//	 		return x;});
		
		 
	}
}
