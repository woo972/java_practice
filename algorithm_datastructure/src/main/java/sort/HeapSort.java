package sort;

public class HeapSort {
    public void sort(int[] array){
        // build max heap
        for(int i = array.length / 2; i >= 0; i--){
            heapify(array, i, array.length);
        }
        // heap sort
        for(int i = array.length - 1; i >= 0; i--){
            System.out.print("sorted:");
            printArray(array);
            // swap max value with last index
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, 0, i);
        }
    }



    private void heapify(int[] array, int parentIndex, int limitIndex){
        System.out.print("heapify:");
        printArray(array);
        int originalParentIndex = parentIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        if(leftChildIndex < limitIndex && array[leftChildIndex] > array[parentIndex]){
            parentIndex = leftChildIndex;
        }
        if(rightChildIndex < limitIndex && array[rightChildIndex] > array[parentIndex]){
            parentIndex = rightChildIndex;
        }
        if(array[originalParentIndex] != array[parentIndex]){
            int tmp = array[originalParentIndex];
            array[originalParentIndex] = array[parentIndex];
            array[parentIndex] = tmp;

            heapify(array, parentIndex, limitIndex);
        }
    }

    private void printArray(int[] array) {
        for(int e: array){
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
