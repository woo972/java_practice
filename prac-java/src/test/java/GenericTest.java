import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GenericTest {
	 
	@Test
	void test_no_generic() {
		Stack s = new Stack();
		s.push("a");
		s.push(1); // 타입을 지정하지 않아 어떤 타입이든 add 됨
		
		int pop1 = (int)s.pop(); // pop시 타입 캐스팅이 필요
		String pop2 = (String)s.pop();
		Assertions.assertEquals(1, pop1);
		Assertions.assertEquals("a", pop2);
	}
	
	@Test
	void test_generic() {
		GenericStack<Integer> s1 = new GenericStack<>(); // 제너릭으로 타입 지정 가능
		s1.push(1);
		int pop1 = s1.pop();
		Assertions.assertEquals(1, pop1);
		
		GenericStack<String> s2 = new GenericStack<>();
		s2.push("a");
		String pop2 = s2.pop();
		Assertions.assertEquals("a", pop2);		
	}
	
	@Test
	void test_클래스상속() {
		GenericStack<Parent> s1 = new GenericStack<>();
		List<Parent> parents = new ArrayList<>();
		parents.add(new Parent());
		final GenericStack<Parent> parentStack = s1.pushAllParent(parents);
		Assertions.assertNotNull(parentStack.pop());
		
		GenericStack<Child> s2 = new GenericStack<>();
		List<Child> children = new ArrayList<>();
		children.add(new Child());
		
		// 컴파일불가  
		// child는 parent의 하위타입이지만 List<child>는 List<parent>의 하위타입이 아님
		// Parent의 하위 클래스에서 메서드가 실행되도록 
		// 파라미터타입을 List<? extends Parent>로 변경필요
		final GenericStack<Parent> childStack = s1.pushAllParent(children); 
		Assertions.assertNotNull(childStack .pop());
	}
}

/* without Generic */
class Stack{
	private final List values;
	
	public Stack() {
		values = new LinkedList<>();
	}
	
	public void push(final Object o) {
		values.add(o);
	}
	
	public Object pop() {
		if(values.size() == 0) {
			return null;
		}
		return values.remove(values.size()-1);
	}
}


/* with Generic */
class GenericStack<E>{
	private final List<E> values;
	
	public GenericStack() {
		values = new LinkedList<E>();
	}
	
	public void push(final E element) {
		values.add(element);
	}
	
	public E pop() {
		if(values.size() == 0) {
			return null;
		}
		return values.remove(values.size()-1);
	}
	
//	public GenericStack<Parent> pushAllParent(List<Parent> parents) {
// 하위 클래스도 받을 수 있도록 변경
	public GenericStack<Parent> pushAllParent(List<? extends Parent> parents) {
		final GenericStack<Parent> stack = new GenericStack<>();
		for(Parent p : parents) {
			stack.push(p);
		}
		return stack;
	}
}

class Parent{
	
}

class Child extends Parent{
	
}
