import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StreamTest {
	
	
	static List<String> strings;
	
	@BeforeAll
	public static void setUp() {
		strings = Arrays.asList("a","b","","d","", "B");
	}
	
	@Test
	public void test_filter() {
		List<String> filtered = strings.stream().filter(s->!s.isEmpty()).collect(Collectors.toList());
		
		List<String> expected = new ArrayList<String>();
		for(String s : strings) {
			if(!s.isEmpty()) expected.add(s);
		}
		Assertions.assertEquals(expected, filtered);
	}
	
	@Test
	public void test_foreach() {
		strings.forEach(System.out::println);
		strings.forEach(s -> System.out.println(s));
	}
	
	@Test
	public void test_map() {
		List<String> mapped = strings.stream().map(s->s.toUpperCase()).distinct().collect(Collectors.toList());
		
		List<String> expected = new ArrayList<String>();
		for(String s : strings) {
			String upperString = s.toUpperCase();
			if(!expected.contains(upperString)) expected.add(upperString);
		}
		
		Assertions.assertEquals(expected, mapped);
	}
	
	@Test
	public void test_sorted() {
		List<String> sorted = strings.stream().sorted((s1, s2)-> s1.compareTo(s2)).collect(Collectors.toList());
		
		Collections.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		Assertions.assertEquals(strings, sorted);
	}
}
