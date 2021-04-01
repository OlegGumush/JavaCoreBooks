package Chapter_01_StreamOperation;

import java.util.List;
import java.util.Optional;

public class Stream_16_Reduction_Operations {

	public static void main(String[] args) {
		
		// The reduce method is a general mechanism for computing a value from a stream.
		// The simplest form takes a binary function and keeps applying it, starting with the first two elements.
		
		// sum
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
		Optional<Integer> sum = list.stream().reduce((x,y) -> x+y);
		sum.ifPresent( value -> System.out.println(value));
		
		// More generally given a reduction operation op, the reduction yields v0 op v1 op v2 ....
		// If you want to use reduction with parallel streams, the operation must be associative.
		
		// Often there is an identity e such s op x = x and that element can be used as the start of the computation.
		// The identity value is returned if the stream is empty and you no longer need to deal with the Optional class
		List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9);
		Integer sum1 = list1.stream().reduce(0, (x,y) -> x+y);
		System.out.println(sum1);
		
		// Note: In practice you probably won't use the reduce method a lot.
	}
}
