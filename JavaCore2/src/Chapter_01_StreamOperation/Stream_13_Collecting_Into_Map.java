package Chapter_01_StreamOperation;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Utils.User;
import Utils.UserFactory;

public class Stream_13_Collecting_Into_Map {

	public static void main(String[] args) {
		
		// If you have a Stream<User> and want to collect the elements into a map so that later you can look up users by their ID.
		
		// Collectors.toMap()/toConcurrectMap() method has to function arguments that produce the map's keys and values.
		
		// 1. key mapper, value mapper
		Map<Integer, String> usersMap = UserFactory.getUsersList().collect(Collectors.toMap(User::getId, User::getName));
		System.out.println(usersMap);
		
		// In the common case when the values should ce the actual elements, use Function.identity().
		Map<Integer, User> usersMap1 = UserFactory.getUsersList().collect(Collectors.toMap(User::getId, Function.identity()));
		System.out.println(usersMap1);		
		
		
		// If there is more than one element with the same key, there is a conflict and the collector will throw an IllegalStateException.
		// You can override that behavior by supplying a third function argument that resolves the conflict and determines the value for the key.
		// Your function could return the existing value, the new value, or a combination of them.
		
		// example : We construct a map that contains, for each language in the available locale, as key its name in you default locale "German" 
		// for example, and as value its localized name "Deutsch".
		// Note : We don't care that the same lang might occur twice (German, Switzerland) so we just keep the first.
		
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		
		Map<String, String> langNames = locales.collect(Collectors.toMap(Locale::getDisplayLanguage,
																loc -> loc.getDisplayLanguage(loc),
																(existValue, newValue) -> existValue));
		System.out.println(langNames);
		
		
		
	}
}