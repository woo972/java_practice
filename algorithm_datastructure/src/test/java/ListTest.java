package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void test_arrayList() {
		// 내부적으로 배열로 생성
		// 삽입, 삭제 n (마지막 요소 삭제는 1)
		// 검색 1 (랜덤 액세스 가능)
		List<String> list1 = new ArrayList<>();
		
		// 내부적으로 연결리스트로 생성
		// 삽입, 삭제 1 
		// 검색 n (순차 접근만 가능)
		// 참조를 위한 추가 메모리 할당 필요 (포인터)
		List<String> list2 = new LinkedList<>(); 
	}
}
