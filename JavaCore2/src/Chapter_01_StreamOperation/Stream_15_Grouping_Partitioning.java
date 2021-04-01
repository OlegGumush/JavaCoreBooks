package Chapter_01_StreamOperation;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import Utils.User;
import Utils.UserFactory;

public class Stream_15_Grouping_Partitioning {

	public static void main(String[] args) {
		
		// If we want to know all users with the same name.
		// Collect into map with value list, User::getName is the classifier function of the grouping.
		
		// groupingBy() / groupingByConcarent()
		Map<String, List<User>> users = UserFactory.getUsersList().collect(Collectors.groupingBy(User::getName));
		System.out.println(users);
		
		// set instead of list
		Map<String, Set<User>> users1 = UserFactory.getUsersList().collect(Collectors.groupingBy(User::getName, Collectors.toSet()));
		System.out.println(users1);
		
		
		// When the classifier function is a predicate function returing Boolean the stream elements are partitioned into two list.
		// It is more efficient to use partitioningBy insted of groupingBy
		
		// partitioningBy()
		List<Integer> numbers = List.of(1,2,3,4,5,6);
		
        Map<Boolean, List<Integer>> m = numbers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(m.get(true));
        System.out.println(m.get(false));
        
        
        
        // Downstream Collectors
        
        // counting produces a count of the collected elements.
		Map<String, Long> users2 = UserFactory.getUsersList().collect(Collectors.groupingBy(User::getName, Collectors.counting()));
		System.out.println(users2);
		
		
        // summing(Int|Long|Double) takes a function argument, applies the function to the downstream elements and produces their sum.
		Map<String, Integer> users3 = UserFactory.getUsersList().collect(Collectors.groupingBy(User::getName, Collectors.summingInt(User::getSalary)));
		System.out.println(users3);

		
		// max salary / min salarys
		Map<String, Optional<User>> users4 = UserFactory.getUsersList().collect(Collectors
				.groupingBy(User::getName, Collectors.maxBy(Comparator.comparing(User::getSalary))));
		System.out.println(users4);
		
		// filtering
		Map<String, Set<User>> users5 = UserFactory.getUsersList()
														.collect(Collectors.groupingBy(
																 						User::getName,
																 						Collectors.filtering(u -> u.getSalary() > 6000 ,
																 											Collectors.toSet())));
		System.out.println(users5);
		
	}
}
