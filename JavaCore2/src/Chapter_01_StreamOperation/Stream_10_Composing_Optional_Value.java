package Chapter_01_StreamOperation;

import java.util.Optional;

public class Stream_10_Composing_Optional_Value {

	public static void main(String[] args) {
		
		// Suppose you have a method f yielding an Optional<T>, and the target type T has a method g wielding an Optional<U>.
		// If the were normal methods, you could compose them by calling s.f().g().
		// But that composition doesnt work since s.f() has type Optional<T> not T.
		
		CowFactory factory = new CowFactory();
		
		// factory.getCow().getId(); - doesnt work
		Optional<Integer> op1 = factory.getCow().flatMap(cow -> cow.getId());
		Optional<Integer> op2 = factory.getCow().flatMap(Cow::getId);
		op1.ifPresent(x -> System.out.println(x));
		op2.ifPresent(x -> System.out.println(x));

		
		
		// We can repeat that process if we have more methods or lambdas that yield Optional values.
		// We can build pipeline of steps simply by chining call to flatmap.
		
		Optional<Double> op3 = Optional.of(4).flatMap(x -> inverse(x)).flatMap(x -> squareRoot(x));
		op3.ifPresent(x -> System.out.println(x));
		
		// If either the inverse method or the squareRoot returns Optional empty() the result is empty.
	}
	
	public static Optional<Double> inverse(double num) {
		
		return num == 0 ? Optional.empty() : Optional.of(1 / num);
	}
	
	public static Optional<Double> squareRoot(double num) {
		
		return num < 0 ? Optional.empty() : Optional.of(Math.sqrt(num));
	}
}

class CowFactory {
	
	private static int id = 1;
	
	public Optional<Cow> getCow(){
		
		return Optional.ofNullable(new Cow(id++));
	}
}

class Cow {
	
	Integer id = null;
	
	public Cow(Integer id) {
		
		this.id = id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Optional<Integer> getId() {
		
		return Optional.ofNullable(id);
	}
}
