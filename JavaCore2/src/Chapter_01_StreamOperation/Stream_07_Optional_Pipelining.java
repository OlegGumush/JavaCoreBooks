package Chapter_01_StreamOperation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream_07_Optional_Pipelining {

	public static void main(String[] args) {
		
		// We can transform the value inside an Optional by using map, flatmap, filter, "or"
		// Simply imagine an optional value as a stream of size zero or one.
		// Result also has size zero or one.
		
		// map - If a value is present returns an Optional of value otherwise returns an empty Optional. 
		Optional<String> first = Stream.of("a","b","c", "d")
				.findFirst()
				.map(x -> x.toUpperCase());
		
		first.ifPresent(value -> System.out.println(value));
		
		
		// flat map - get a value and returns Optional
		// This method is similar to map(Function), but the mapping function
		// is one whose result is already an Optional, and if invoked, flatMap does not wrap it within an additional Optional.
		Optional<String> first1 = Stream.of("a","b","c", "d")
				.findFirst()
				.flatMap(x -> Optional.of(x));
		first1.ifPresent(value -> System.out.println(value));

		
		// filter
		first = Stream.of("a","b","c", "d")
				.findFirst()
				.filter(x -> x.toLowerCase().startsWith("a"));
		
		first.ifPresent(value -> System.out.println(value));
		
		
		List<String> alternatives = List.of("1","2","3");

		// or - If a value is present, returns an Optional describing the value,otherwise returns an Optional produced by the supplying function.
		// or gets supplier and ifPresent gets consumer.
		first = Stream.of("a","b","c", "d")
				.findFirst()
				.filter(value -> value.startsWith("e"))
				.or(() -> alternatives.stream().findFirst());
		

	
	}
}
