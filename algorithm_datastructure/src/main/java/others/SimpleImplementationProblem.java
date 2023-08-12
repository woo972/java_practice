package others;

import java.util.*;

public class SimpleImplementationProblem {
    // when there is unsorted input numbers from 1 to N,
    // find missing number from the input numbers(only one number is missed)
    public int findMissingNumber(List<Integer> inputList) {
        int sum = 0;
        for (Integer integer : inputList) {
            sum += integer;
        }
        int n = inputList.size()+1;
        return n*(n+1)/2 - sum;
    }

    // n2의 영역은 단순 중복 루프
    // n log n의 영역은 정렬
    // n의 영역은 해쉬를 생각해볼 수 있다. (Set, Map 등등)

    // when there is unsorted input numbers,
    // check whether there are two numbers that sum of them is equal to given number
    public boolean findSumOfTwo_slowWay(List<Integer> inputList, int number) {
        // n^2
        for(int i=0; i<inputList.size()-1; i++){
            for(int j=i+1; j<inputList.size(); j++){
                if(inputList.get(i) + inputList.get(j) == number){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean findSumOfTwo_fastWay(List<Integer> inputList, int number) {
        // n * log n
        Collections.sort(inputList);
        int left =0;
        int right = inputList.size()-1;
        while(left < right){
            int a = inputList.get(left);
            int b = inputList.get(right);
            if(a+b < number){
                left++;
                continue;
            }
            if(a+b > number){
                right--;
                continue;
            }
            return true;
        }
        return false;
    }
    public boolean findSumOfTwo_fastestWay(List<Integer> inputList, int number) {
        // n
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<inputList.size(); i++){
            int n = inputList.get(i);
            if(set.contains(number - n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }

    // merge two sorted linked list into one sorted linked list
    class LinkedListNode {
        int val;
        LinkedListNode next;
    }

    public LinkedListNode mergeSortedList(LinkedListNode head1, LinkedListNode head2) {
        if(head1 == null){
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // merge head
        LinkedListNode mergedHead;
        if (head1.val <= head2.val) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        LinkedListNode trail = mergedHead;
        while (true) {
            if(head1 == null){
                trail.next = head2;
                break;
            }

            if(head2 == null){
                trail.next = head1;
                break;
            }

            int leftVal = head1.val;
            int rightVal = head2.val;

            LinkedListNode tmp;
            if (leftVal <= rightVal) {
                tmp = head1;
                head1 = head1.next;

            } else {
                tmp = head2;
                head2 = head2.next;
            }

            trail.val = tmp.val;
            trail.next = tmp;
        }
        return trail;
    }
}
