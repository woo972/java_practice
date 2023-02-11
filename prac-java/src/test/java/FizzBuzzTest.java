import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

	int n;
	List<String> expected;
	@BeforeEach
	public void setUp() {
		n = 15;
		expected = new ArrayList<>();
		expected.add("Buzz");
		expected.add("Fizz");
		expected.add("Buzz");
		expected.add("Buzz");
		expected.add("Fizz");
		expected.add("Buzz");
		expected.add("FizzBuzz");	
	}
	
	@Test
	public void test_simple_impl() {
		List<String> answer = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(i%15==0) answer.add("FizzBuzz");
			else if(i%5==0) answer.add("Fizz");
			else if(i%3==0) answer.add("Buzz");
		}
		
		Assertions.assertEquals(expected, answer);
	}
	
	@Test
	public void test_refactoring_impl() {
		List<String> answer = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			String s = toWord(i, 5, "Fizz")+toWord(i, 3, "Buzz");
			if(!s.isEmpty()) answer.add(s);
		}
		
		Assertions.assertEquals(expected, answer);
	}

	private String toWord(int target, int divisor, String word) {
		String s;
		if(target % divisor == 0) {
			s = word;
		}else {
			s = "";
		}
		return s;
	}
}
