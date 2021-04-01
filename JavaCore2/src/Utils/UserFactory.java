package Utils;

import java.util.stream.Stream;

public class UserFactory {

	public static Stream<User> getUsersList(){

		return Stream.of(new User(1, "Oleg"), new User(2, "Katy"), new User(3, "Igor"), new User(4,"Oleg"));
	}
	
}
