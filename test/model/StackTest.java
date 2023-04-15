package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testNonEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testEmptyAfterPoppingAllElements() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushOneElementOntoEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, (int) stack.top());
    }

    @Test
    public void testPushingMultipleElementsOntoNonEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.size());
        assertEquals(3, (int) stack.top());
    }

    @Test
    public void testPoppingOneElementFromNonEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertEquals(1, (int) stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void TestPoppingMultipleElementsFromNonEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.top());
        assertEquals(2, stack.size());
    }

    @Test
    public void testTopOfStackWithOneElement() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertEquals(1, (int) stack.top());
    }

    @Test
    public void testTopOfStackWithMultipleElements() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int) stack.top());
    }

    @Test
    public void testSizeOfEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        assertEquals(0, stack.size());
    }

    @Test
    public void testSizeOfNonEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    public void testSizeOfStackAfterPoppingElements() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    public void testEmptyStackWhenStackIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        stack.emptyStack();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testEmptyStackWhenStackIsNotEmpty() {
        Stack<String> stack = new Stack<>();
        stack.push("element1");
        stack.push("element2");
        stack.emptyStack();
        assertTrue(stack.isEmpty());
    }
}
