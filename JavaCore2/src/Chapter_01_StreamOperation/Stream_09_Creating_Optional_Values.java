package Chapter_01_StreamOperation;

import java.util.Optional;

public class Stream_09_Creating_Optional_Values {

	public static void main(String[] args) {
		
		// So far, we have discussed how to consume an Optional object someone else created.
		// If you want to write a method that creates an Optional object there are several static methods for that purpose.
		
		Optional<Double> inversedNum = inverse(10D);
		System.out.println(inversedNum.orElseThrow());
		
		
		Double nullable = null;
		// Optional<Double> op = Optional.of(nullable); - Null pointer exception

		
		// The ofNullable method is intended as a bridge from possibly null values to optional values.
		// Optional.ofNullable(obj) returns Optional.of(obj) if obj is not null and Optional.empty otherwise.
		Optional<Double> op1 = Optional.ofNullable(nullable);
		if(op1.isEmpty()) {
			System.out.println("success");
		}
	}
	
	public static Optional<Double> inverse(Double num) {
	
		return num == 0 ? Optional.empty() : Optional.of(1 / num);
	}
	
	
}
