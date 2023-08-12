import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.MergeSort;

public class MergeSortTest {

	List<Integer> inputList; 
	List<Integer> expectedList;
	
	@BeforeEach
	void setUp() {
		inputList = new ArrayList<>();
		inputList.add(3);
		inputList.add(1);
		inputList.add(2);
		inputList.add(7);
		inputList.add(4);
		
		expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(4);
		expectedList.add(7);
	}
	
	
	@Test
	void test_mergeSort() {
		Assertions.assertEquals(expectedList, MergeSort.sort(inputList));
	}
	
}
