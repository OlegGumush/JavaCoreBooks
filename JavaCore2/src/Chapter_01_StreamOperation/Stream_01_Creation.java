package Chapter_01_StreamOperation;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_01_Creation { 

	public static void main(String[] args) {
		
		// Array
		Stream<String> stream = Stream.of("one-two-three".split("-")); 
		show(stream);
		
		// Varargs parameter
		Stream<String> stream1 = Stream.of("one","two","three"); 
		show(stream1);
		
		
		// Array
		Stream<String> stream2 = Arrays.stream("one-two-three".split("-"));
		show(stream2);
		
		// Part of the array
		Stream<String> stream3 = Arrays.stream("one-two-three".split("-"), 0 , 2);
		show(stream3);
		
		// Empty stream
		Stream<String> emptyStream = Stream.empty();  show(emptyStream);

		// *** Infinite Streams ***
		
		// generate() method takes a function with no arguments (Supplier<T> interface - T get()).
		// Whenever a stream value is needed that function is called to produce a value.
		
		// Generate stream with constant values.
		Stream<String> generatedStream = Stream.generate(() -> "Echo");  
		show(generatedStream);
		
		// Generate stream with random values.
		Stream<UUID> generatedStream1 = Stream.generate(UUID::randomUUID); 
		show(generatedStream1);
		
		// To produce sequence we use iterate() method.
		// Iterate function takes a "seed" value and a function (UnaryOperator<T>) a applies the function to the prev result.
		// f(seed) -> f(f(seed)) -> f(f(f(seed))) ...
		Stream<BigInteger> iterateStream = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.TEN)); 
		show(iterateStream);
		
		Stream<Integer> iterateStream1 = Stream.iterate(1, n -> n + 10); 
		show(iterateStream1);
		
		// Produce a finite stream add a predicate (PredicateT> function from T to boolean) that specifies when the iteration should finish.
		Stream<Integer> iterateStream2 = Stream.iterate(1, n -> n.compareTo(90) < 0 , n -> n + 10);   
		show(iterateStream2); // finite stream

		// A number of methods in the Java API yields Streams.
		
		// Pattren.compile(regex).splitAsStream(content).
		// Files.lines(path).
	}
	
	public static <T> void show(Stream<T> stream) {
		
		int size = 10;
		List<T> firstElements = stream.limit(size + 1).collect(Collectors.toList());
		System.out.println(firstElements.toString());
		System.out.println();
	}
}




























