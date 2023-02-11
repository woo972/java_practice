import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparableComparatorTest {

	// compartor 객체가 없는 구현체 정렬 => 타입을 자연스러운 순서로 정렬
	@Test
	void test_sortInts() {
		int[] arr = new int[] {-2, 1, 0, 2, -1};
		Arrays.sort(arr);
		
		int[] expectedArr = new int[] {-2, -1,0,1,2};
		Assertions.assertArrayEquals(expectedArr, arr);
		
	}
	
	// Comparable 인터페이스를 구현한 정렬 (String클래스가 해당 인터페이스 구현함)
	@Test
	void test_comparator() {
		String[] arr = new String[] {"abc", "abb", "ab", "aca"};
		String[] expectedArr = new String[] {"ab", "abb", "abc", "aca"};
		
		Arrays.sort(arr);
		Assertions.assertArrayEquals(expectedArr, arr);
	}
	
	// Comparable 인터페이스가 기본적으로 구현되어있지 않은 경우 
	@Test
	void test_no_comparator() {
		List<NoComparable> list = new ArrayList<>();
		list.add(new NoComparable(1, "z"));
		list.add(new NoComparable(2, "a"));
		list.add(new NoComparable(3, "k"));
		
		
		// Collections.sort는 정렬하려는 객체에 Comparable이 구현되어있지 않으면 사용 불가
		//Collections.sort(list);
		
		// Comparable 없이 정렬 불가
		Assertions.assertThrows(Exception.class, ()->{
			Arrays.sort(list.toArray());
		});
		
		Collections.sort(list, new Comparator<NoComparable>() {
			@Override
			public int compare(NoComparable o1, NoComparable o2) {
				return o1.something.compareTo(o2.something);
			}
		});
		
		
		NoComparable[] expectedArr = new NoComparable[] {
				new NoComparable(2, "a"),
				new NoComparable(3, "k"),
				new NoComparable(1, "z")
		};
		for(int i=0; i<expectedArr.length; i++) {
			Assertions.assertEquals(expectedArr[i].something, list.get(i).something);
		}
		
		
		
	}
}

class NoComparable {
	int id;
	String something;
	NoComparable(int id, String something){
		this.id = id;
		this.something = something;
	}
	
	@Override
	public String toString() {
		return this.id+" "+this.something;
	}
}

