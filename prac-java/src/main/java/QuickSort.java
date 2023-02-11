import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public static List<Integer> sort(List<Integer> inputList) {
		if(inputList.size() <= 1) return inputList;
		
		final int pivot = inputList.get(0);
		final List<Integer> leftList = new ArrayList<>();
		final List<Integer> rightList = new ArrayList<>();
		
		for(int idx=1; idx<inputList.size(); idx++) {
			if(inputList.get(idx) < pivot ) {
				leftList.add(inputList.get(idx));
			}else {	
				rightList.add(inputList.get(idx));
			}
		}

		final List<Integer> sortedList = sort(leftList); 
		sortedList.add(pivot);
		sortedList.addAll(sort(rightList));
		return sortedList; 
		
	}

}
