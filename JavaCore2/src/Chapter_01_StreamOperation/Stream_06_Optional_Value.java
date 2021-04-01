package Chapter_01_StreamOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream_06_Optional_Value {

	public static void main(String[] args) {
		
		// orElse
		Optional<String> op = Stream.of("1","2","3", "4","5").filter(s -> s.startsWith("6")).max(String::compareToIgnoreCase);
		String result = op.orElse("None");
		System.out.println(result);
		
		
		// orElseGet - need to provide a Supplier<T>
		op = Stream.of("1","2","3", "4","5").filter(s -> s.startsWith("6")).max(String::compareToIgnoreCase);
		String result1 = op.orElseGet( () -> getDefault());
		System.out.println(result1);
		
		
		
		// return boolean
		op.isEmpty(); 
		op.isPresent();
		

		op = Stream.of("1","2","3","4","5","55").filter(s -> s.startsWith("5")).max(String::compareToIgnoreCase);

		// if present - need to provide a consumer
		op.ifPresent( value -> print(value));
		
		List<String> results = new ArrayList<String>();
		op.ifPresent( v -> results.add(v));

		op.ifPresent(results::add);
		
		System.out.println(results);
		
		
		// If we want to take one action if the Optional has a value and another action if is doesn't use ifPresentorElse
		// If a value is present use consumer
		// otherwise use runnable
		op.ifPresentOrElse(value -> print(value), () -> System.out.println("log.ERROR(Empty value)"));
		
		
		
		// throw Exception if there is no value
		Stream.of("1","2","3", "4","5").filter(s -> s.startsWith("6")).max(String::compareToIgnoreCase).orElseThrow();
		
		Stream.of("1","2","3", "4","5").filter(s -> s.startsWith("6")).max(String::compareToIgnoreCase).orElseThrow(IllegalStateException::new);
	}
	
	
	private static void print(String value) {
		System.out.println(value);
	}


	public static String getDefault() {
		
		return "Default";
	}
}
