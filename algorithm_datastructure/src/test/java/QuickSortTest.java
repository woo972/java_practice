import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSortTest {
	
	List<Integer> inputList;
	
	List<Integer> expectedList;
	
	@BeforeEach
	void setUp() {
		inputList = new ArrayList<>();
		inputList.add(4);
		inputList.add(2);
		inputList.add(5);
		inputList.add(7);
		inputList.add(3);
		
		expectedList = new ArrayList<>();
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(4);
		expectedList.add(5);
		expectedList.add(7);
	}
	
	
	@Test
	void test_quicksort() {
		Assertions.assertEquals(expectedList, main.QuickSort.sort(inputList));
	}

}
