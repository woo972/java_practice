import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

	/* n까지의 피보나치 수열 구하기*/
	@Test
	void test_get_fibonacci_list() {
		Assertions.assertEquals(Arrays.asList(), getFibonacciList(0));
		Assertions.assertEquals(Arrays.asList(1), getFibonacciList(1));
		Assertions.assertEquals(Arrays.asList(1,1), getFibonacciList(2));
		Assertions.assertEquals(Arrays.asList(1,1,2), getFibonacciList(3));
		Assertions.assertEquals(Arrays.asList(1,1,2,3), getFibonacciList(4));
		Assertions.assertEquals(Arrays.asList(1,1,2,3,5), getFibonacciList(5));
		Assertions.assertEquals(Arrays.asList(1,1,2,3,5,8), getFibonacciList(6));
	}

	private List<Integer> getFibonacciList(int n) {
		if(n <= 0) return new ArrayList<>();
		
		List<Integer> returnList = new ArrayList<>();
		returnList.add(1);
		n--;
		if(n <= 0) return returnList;
		returnList.add(1);
		n--;
		if(n <= 0) return returnList;
		
		while(n > 0) {
			returnList.add(returnList.get(returnList.size()-1)+ returnList.get(returnList.size()-2));
			n--;
		}
		return returnList;
	}
	
	
	
	/* n번째 피보나치 수 구하기 */
	@Test
	void test_get_fibonacci_n() {
		Assertions.assertEquals(0, getFibonacciN(0));
		Assertions.assertEquals(1, getFibonacciN(1));
		Assertions.assertEquals(1, getFibonacciN(2));
		Assertions.assertEquals(2, getFibonacciN(3));
		Assertions.assertEquals(3, getFibonacciN(4));
		Assertions.assertEquals(5, getFibonacciN(5));
	}

	// non caching
//	private int getFibonacciN(int n) {
//		if(n <= 0 ) return 0;
//		if(n == 1 ) return 1;
//		return getFibonacciN(n-1)+getFibonacciN(n-2);
//	}
	
	// with memoization (array)
//	int[] fibonacci = new int[100];
//	private int getFibonacciN(int n) {
//		if(n <= 0 ) return fibonacci[0]=0;
//		if(n == 1 ) return fibonacci[1]=1;
//		return fibonacci[n] = fibonacci[n-1]+fibonacci[n-2];
//	}
	
	// with memoization (map)
	Map<Integer,Integer> fibonacci = new HashMap<>();
	private int getFibonacciN(int n) {
		if(n <= 0 ) {
			fibonacci.put(0, 0);
			return 0;
		}
		if(n == 1 ) {
			fibonacci.put(1, 1);
			return 1;
		}
		int nFibonacci = fibonacci.get(n-1)+fibonacci.get(n-2);
		fibonacci.put(n,  nFibonacci);
		return nFibonacci;
	}
	
}
