package Chapter_01_StreamOperation;

import static Chapter_01_StreamOperation.Stream_01_Creation.show;

import java.util.stream.Stream;

public class Stream_03_Extracting_Comining {

	public static void main(String[] args) {
		
		// limit method returns a new stream that ends after n elements or when the original stream ends if it shorter.
		// This method is particularly useful for cutting infinite streams down to size.
		Stream<Double> limitedStream = Stream.generate(Math::random).limit(100); // lambda expression. 
		show(limitedStream);
		
		Stream<String> limitedStream1 = Stream.of("1","22","333", "4444").limit(2);    show(limitedStream1);

		
		// skip method discards the first n elements or when the original stream ends.
		Stream<String> skipeddStream2 = Stream.of("1","22","333", "4444").skip(2);   show(skipeddStream2);
		
		// takeWhile method gets (Predicate<T> function from T to boolean) and takes all elements from the stream while the predicate is true and then stops.
		Stream<String> takeWhileStream = Stream.of("a","aaa","asvda", "sfffs").takeWhile(s -> s.contains("a"));   show(takeWhileStream);
		
		
		// dropWhile gets (Predicate<T> function from T to boolean) and drops all element while a condition is true and returns a stream of all elements
		// starting this the first one for which the condition was false.
		Stream<String> dropWhileStream = Stream.of("a","aaa","asvda", "sfffs", "aaaaaaa").dropWhile(s -> s.contains("a"));   show(dropWhileStream);
		
		
		// Stream concatenation - static method concat of Stream class
		Stream<String> combined = Stream.concat(Stream.of("1"), Stream.of("2"));     show(combined);
	}
}
