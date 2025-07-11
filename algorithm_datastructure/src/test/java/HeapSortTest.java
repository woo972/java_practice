import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.HeapSort;

public class HeapSortTest {
    HeapSort heapSort;
    @BeforeEach
    public void setUp(){
        heapSort = new HeapSort();
    }

    @Test
    public void testHeapSort(){
        int[] array = {5, 8, 1, 3, 2, 1, 0, 9, 10, 4};
        heapSort.sort(array);
        // add assertion
        int [] expected = {0,1,1,2,3,4,5,8,9,10};
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testHeapSort2(){
        int[] array = {7, 50, 15, 40, 30, 88};
        heapSort.sort(array);
        // add assertion
        int [] expected = {7, 15, 30, 40, 50, 88};
        Assertions.assertArrayEquals(expected, array);
    }
}
