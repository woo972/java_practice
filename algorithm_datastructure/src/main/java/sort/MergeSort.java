package main;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static List<Integer> sort(List<Integer> inputList) {
		if(inputList.size() < 2) return inputList;
		
		int mid = inputList.size() / 2;
		List<Integer> leftList = inputList.subList(0, mid); 
		List<Integer> rightList = inputList.subList(mid, inputList.size()); 
		
		List<Integer> sortedLeftList = sort(leftList);
		List<Integer> sortedRightList = sort(rightList);
		
		return merge(sortedLeftList, sortedRightList);
	}

	private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
		int leftPtr = 0;
		int rightPtr = 0;
		
		List<Integer> sortedList = new ArrayList<Integer>(leftList.size() + rightList.size());
		
		while(leftPtr < leftList.size() && rightPtr < rightList.size()) {
			if(leftList.get(leftPtr) < rightList.get(rightPtr)) {
				sortedList.add(leftList.get(leftPtr++));
			}else {
				sortedList.add(rightList.get(rightPtr++));
			}
		}
		while(leftPtr < leftList.size()) {
			sortedList.add(leftList.get(leftPtr++));
		}
		while(rightPtr < rightList.size()) {
			sortedList.add(rightList.get(rightPtr++));
		}
		
		return sortedList;
	}

}
