package Chapter_01_StreamOperation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_12_Collecting_Results {

	public static void main(String[] args) {
		
		// When you are done with a stream, you will often want to look at the result.
		// You can call the iterator method old-fashion iterator that you can use to visit the elements.
		// Alternatively, you can call the forEach method to apply a function o each element.
		// On a parallel stream the forEach method traverses elements in arbitrary order, if you want to process them in stream order call forEachOrdered.
		
		// More often you will want to collect the result in a data structure.
		
				
		// It is not possible to create a generic array at runtime, so toArray return Object[].
		Object[] arr = getStream().toArray();
		System.out.println(Arrays.toString(arr));
		
		
		// If you want an array of the correct type, pass in the array constructor.
		arr = getStream().toArray(String[]::new);
		System.out.println(Arrays.toString(arr));

		
		// For collecting stream elements to another target, there is convenient collect() method that takes an instance of the Collector interface.
		List<String> list = getStream().collect(Collectors.toList());
		System.out.println(list);
		
		Set<String> set = getStream().collect(Collectors.toSet());
		System.out.println(set);
		
		// If you want to control which kind of set you get.
		TreeSet<String> treeSet = getStream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);
		
		// If you want to collect all string in a stream by concatenating them.
		String concate = getStream().collect(Collectors.joining());
		System.out.println(concate);
		
		// If you want a delimiter between elements
		concate = getStream().collect(Collectors.joining(", "));
		System.out.println(concate);

		// If your stream contains objects then than strings, first convert them to string.
		concate = getStream().map(Object::toString).collect(Collectors.joining(", "));
		System.out.println(concate);

		
		
		// If you want to reduce the stream results to a sum, count, average, max, min, use summarizing(Int|Long|Double).
		// These methods take a function that maps the stream objects to numbers and yields a result of type (Int|Long|Double) simultaneously computing.
		Stream<String> summary = Stream.of("Oleg","1","Cow","12345");
		
		// IntSummaryStatistics, LongSummaryStatistics, DoubleSummaryStatistics
		IntSummaryStatistics statistics = summary.collect(Collectors.summarizingInt(String::length));
		
		System.out.println("Average : " + statistics.getAverage());
		System.out.println("Max : " + statistics.getMax());
		System.out.println("Min : " + statistics.getMin());
		System.out.println("Count : " + statistics.getSum());
		System.out.println("Sum : " + statistics.getCount());
		System.out.println();
		
		// 
		statistics = getStream().collect(Collectors.summarizingInt( s -> s.length()));
		System.out.println("Average : " + statistics.getAverage());
		System.out.println("Max : " + statistics.getMax());
		System.out.println("Min : " + statistics.getMin());
		System.out.println("Count : " + statistics.getSum());
		System.out.println("Sum : " + statistics.getCount());
		System.out.println();
		
	}
	
	public static Stream<String> getStream() {
		
		return Stream.of("one","two","three");
	}
	
	
}
