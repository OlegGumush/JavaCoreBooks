package Chapter_01_StreamOperation;

import java.util.Optional;
import java.util.stream.Stream;

public class Stream_05_Simple_Reductions {

	public static void main(String[] args) {
		
		// The method covered in this section are called reductions.
		// Reductions are terminal operations the reduce the stream to a nonstream value that can be used in your program.
		// These methods return an Optional<T> value than either wraps the answer or indicates that there is none (stream can be empty).
		// In the olden days it was common to return null, but that can lead to null pointer exception.
		
		
		long count = Stream.of("A","B","C", "D").count();
		System.out.println(count);

		// The find first returns the first value in a nonempty collection, it is often useful when combined with filter.
		Optional<String> first = Stream.of("Aaa","cad","Ccc", "Ddd").filter(s -> s.toLowerCase().startsWith("c")).findFirst();
		if( first.isPresent() ) {
			System.out.println(first.get());
		}
		
		// find first
		first = Stream.of("Aaa","cad","Ccc", "Ddd").filter(s -> s.toLowerCase().startsWith("e")).findFirst();
		// first.get() - NoSuchElementException
		if( first.isPresent() ) {
			System.out.println(first.get());
		}


		// find Any
		// If you Ok with any match not just first one.
		// This is effective when you parallelize the stream
		Optional<String> any = Stream.of("c1","c2","c3", "c4","c11","c12","c13","c14").parallel().filter(s -> s.toLowerCase().startsWith("c")).findAny();
		if( any.isPresent() ) {
			System.out.println(any.get());
		}			
		
		
		// max method gets comparator
		Optional<String> max = Stream.of("1","2","3", "4","5").max( (s1,s2) -> s1.compareTo(s2));
		if( max.isPresent()) {
			System.out.println(max.get());
		}		

		// max method gets comparator
		max = Stream.of("1","2","3","4","5").max(String::compareToIgnoreCase);
		if( max.isPresent()) {
			System.out.println(max.get());
		}
		
		
		// min method gets comparator
		Optional<String> min = Stream.of("1","2","3","4","5").min(String::compareToIgnoreCase);
		if( min.isPresent()) {
			System.out.println(min.get());
		}
		
		
		
		// anyMatch, allMatch, noneMatch - return true if all or no elements match a predicate, these methods also benefit from being run in parallel
		boolean allMatch = Stream.of(1,2,3,4,5,6,7,8,9).allMatch( num -> num < 10);
		System.out.println(allMatch);

		
		boolean anyMatch = Stream.of(11,12,13,14,5,16,17,18,19).anyMatch( num -> num < 10);
		System.out.println(anyMatch);
		
		
		boolean noneMatch = Stream.of(11,12,13,14,5,16,17,18,19).noneMatch( num -> num < 10);
		System.out.println(noneMatch);
	}
}






