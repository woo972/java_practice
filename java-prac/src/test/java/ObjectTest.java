import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObjectTest {

	@Test
	void test_null참조불가() {
		Assertions.assertThrows(NullPointerException.class, ()->{
			String s = null;
			s.length();
		});
	}
	
	@Test
	void test_memory주소할당() {
		int a = 1;
		int b = a;
		b = 2;
		Assertions.assertTrue(a != b, "서로 다른 메모리에 값 할당");
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = list1;
		list2.add(1);
		Assertions.assertTrue(list1.size() == list2.size(), "동일 메모리 주소 참조");
	}

	@Test
	void test_static키워드() {
		StaticTestClass s1 = new StaticTestClass();
		Assertions.assertTrue(s1.STATIC_VALUE == 1);
		StaticTestClass s2 = new StaticTestClass();
		Assertions.assertTrue(s2.STATIC_VALUE == 1);
		s1.STATIC_VALUE++;
		Assertions.assertTrue(s2.STATIC_VALUE == 2, "static 메서드, 변수는 클래스에 정의하지만 인스턴스에 종속하지 않음");
	}
	
	@Test
	void test_polymorphism_inheritance() {
		List<Rectangle> list = new ArrayList<>();
		list.add(new Rectangle(3, 2));
		list.add(new Square(3, 3));
		
		Assertions.assertTrue(list.get(0).area() == 6);
		Assertions.assertTrue(list.get(1).area() == 9, "다형성, 상속에 의해 부모클래스의 정의를 자식 클래스에서 구현할 수 있다");
	}
	
	@Test
	void test_string_object() {
		String s1 = new String("hello");  // new 키워드 생성 => 힙메모리에 등록
		String s2 = "hello"; // 리터럴 생성 => 힙메모리 string pool에 등록
		
		// == 은 레퍼런스 비교이기 때문에 
		Assertions.assertTrue(s1!=s2); 
		
		// String pool에 동일한 문자가 있으면 그것을 참조함
		String s3 = "hello";
		Assertions.assertTrue(s2==s3);
		Assertions.assertTrue(s3=="hello");
		
		// primitive type 처럼 사용
		String s4 = s2;
		Assertions.assertTrue(s2==s4);
		s4 = "world";
		Assertions.assertTrue(s2!=s4);
		String s5 = s1;
		Assertions.assertTrue(s1==s5);
		s5 = "world";
		Assertions.assertTrue(s1!=s5);
		
		// String pool을 이용하지 않으므로 서로 다른 주소에 저장됨
		String s6 = new String("hello");
		Assertions.assertTrue(s1 != s6);
		
		
		
	}
	
	@Test
	void test_string_불변성() {
		String s1 = "hello world";
		String s2 = s1.substring(5);
		Assertions.assertTrue(s1.equals("hello world"));
		Assertions.assertFalse(s1.equals(s2));
		
	}
}

/* staitc keyword test */
class StaticTestClass{
	static int STATIC_VALUE = 1;
}

/* polymorphism inheritance test */
class Rectangle{
	int width;
	int height;
	
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	int area() {
		return width * height;
	}
}

class Square extends Rectangle{
	Square(int width, int height){
		super(width, height);
	}	
}

