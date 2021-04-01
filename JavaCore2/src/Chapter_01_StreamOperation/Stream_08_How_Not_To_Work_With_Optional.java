package Chapter_01_StreamOperation;

import java.util.Optional;

public class Stream_08_How_Not_To_Work_With_Optional {

	
	public static void main(String[] args) {
		
		
		// If you dont use Optional values correctly, you have no benefit over the null approach of the past.
		
		// The get() method gets the wrapped element of an Optional value if it exists, or throws a NoSuchElementException if it doesn't.
		
		String first = getOptional()
				.get()
				.toString();
		
		// is no safer than 
		String value = getString().toString();
		
		// Even if a programmer will only call get() method in cases that an Optional is not empty its better to call orElseThrow.		
		
		
		// Tips:
		// 1. A variable of type Optional should never be null.
		// 2. Dont use fields of type Optional, null more manageble.
		// 3. Dont put Optional in a set, key for a map collect the variables instead. 
	}
	
	public static Optional<String> getOptional() {
		
		return Optional.empty();
	}
	
	public static String getString() {
		
		return null;
	}
}
