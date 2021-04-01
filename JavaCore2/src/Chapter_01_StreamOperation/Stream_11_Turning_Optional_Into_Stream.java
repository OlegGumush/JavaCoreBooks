package Chapter_01_StreamOperation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import Utils.User;

public class Stream_11_Turning_Optional_Into_Stream {

	public static void main(String[] args) {
		
		// The stream method turns an Optional<T> into a Stream<T> with zero or one element.
		Stream<Double> stream = Optional.of(1D).stream();
		stream.forEach(System.out::println);		
		
		// Why would we ever want that ???
		
		// Suppose we have a stream of user IDs and a method "Optional<User> lookup(String id)"
		// How do we get a stream of users skipping those IDs that are invalid ?
		
		List<String> userIds = List.of("1","2","3","100","200","300");
		
		Stream<String> userIDs = userIds.stream();
		
		// 1. filter out the invalid IDs
		Stream<User> users = userIDs.map(x -> lookup(x))
									.filter(Optional::isPresent)
									.map(Optional::get);
		users.forEach(System.out::println);
		System.out.println();
		
		
		
		userIDs = userIds.stream();

		// 2. use Optional.stream()
		Stream<User> users1 = userIDs.map(x -> lookup(x))
									.flatMap(Optional::stream);
		users1.forEach(System.out::println);		
	}
	
	public static Optional<User> lookup(String id) {
		
		Integer userId = Integer.parseInt(id);
		
		if(userId >= 100) {
			return Optional.empty();
		}
		
		return Optional.of(new User(userId, "name"));
	}
	
	public static User classicLookup(String id) {
		
		Integer userId = Integer.parseInt(id);
		
		if(userId >= 100) {
			return null;
		}
		
		return new User(userId, "name");
	}
	
}
