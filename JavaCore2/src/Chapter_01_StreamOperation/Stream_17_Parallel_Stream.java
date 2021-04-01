package Chapter_01_StreamOperation;

import java.util.List;
import java.util.stream.Stream;

public class Stream_17_Parallel_Stream {

	public static void main(String[] args) {
		
		// Create from list
		List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9);
		Stream<Integer> parallelStream = list1.parallelStream();
		
		
		// Create from stream
		Stream<Integer> stream = List.of(1,2,3,4,5,6,7,8,9).stream();
		Stream<Integer> parallelStream1 = stream.parallel();
		
		  
		// As long as the stream is in parallel mode when the terminal method executes all intermediate stream operations will be parallelized.
		// It is important that the operations are stateless and can be executed in an arbitrary order.
		
		
		// Here is an example of something you cannot do!
		int shortWords[] = new int[12];
		
		Stream.of("a","b","cssssssssssssss", "dasd").parallel().forEach(
				
					s -> {
							if (s.length() < 12) shortWords[s.length()]++;
							// ERROR race condition
						}
				);
		
		
		
		
	}
	
	
}
