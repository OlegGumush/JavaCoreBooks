package Chapter_01_StreamOperation;

import java.util.Arrays;
import java.util.stream.Stream;
import static Chapter_01_StreamOperation.Stream_01_Creation.show;

public class Stream_02_Filter_Map_FlatMap {

	public static void main(String[] args) {
		
		// filter yields a new stream with those elements that match a certain condition(Predicate<T> function from T to boolean).
		Stream<String> stream = Stream.of("1","22","333", "4444").filter(s -> s.length() > 2);
		 show(stream);
		 
		
		// map method get function(Function<? super T, ? extends R> mapper) and applied it to each element.
		Stream<String> stream1 = Stream.of("A","ABA","ccSD", "SDFSFDFCCCssadh").map(String::toLowerCase); // method reference.
		show(stream1);

		 
		Stream<String> stream2 = Stream.of("A","ABA","ccSD", "SDFSFDFCCCssadh").map(s -> s.toLowerCase()); // lambda expression.
		show(stream2);
		
		
		// map vs. flatmap example
		Stream<Stream<String>> stream3 = Stream.of("a-a","b-b","c-c").map(s -> Stream.of(s.split("-"))); // lambda expression.
		stream3.forEach(arr -> System.out.print(Arrays.toString(arr.toArray()) + ""));
		System.out.println();
		
		
		Stream<String> stream4 = Stream.of("a-a","b-b","c-c").flatMap(s -> Stream.of(s.split("-"))); // lambda expression.
		stream4.forEach(arr -> System.out.print(arr + " "));
		System.out.println();
		System.out.println();

	}
}
