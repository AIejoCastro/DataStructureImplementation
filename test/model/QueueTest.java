package model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsEmptyAfterRemove() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.remove();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testInsertInEmptyQueue() {
        Queue<String> queue = new Queue<>();
        queue.insert("A");
        Assertions.assertEquals(1, queue.size());
    }

    @Test
    public void testInsertInQueueWithInfo() {
        Queue<String> queue = new Queue<>();
        queue.insert("A");
        queue.insert("B");
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void testRemoveInOneElementQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        Assertions.assertEquals(1, (int) queue.remove());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testRemoveInMultipleElementsQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        Assertions.assertEquals(1, (int) queue.remove());
        Assertions.assertEquals(1, queue.size());
    }

    @Test
    public void testRemoveAllElements() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        Assertions.assertEquals(1, (int) queue.remove());
        Assertions.assertEquals(2, (int) queue.remove());
        Assertions.assertEquals(3, (int) queue.remove());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testHeadInEmptyQueue() {
        Queue<String> queue = new Queue<>();
        queue.insert("A");
        Assertions.assertEquals("A", queue.head());
    }

    @Test
    public void testHeadInMultipleObjectsQueue() {
        Queue<String> queue = new Queue<>();
        queue.insert("A");
        queue.insert("B");
        Assertions.assertEquals("A", queue.head());
        queue.remove();
        Assertions.assertEquals("B", queue.head());
    }

    @Test
    public void testSizeInEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    public void testSizeInMultipleObjectQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        Assertions.assertEquals(3, queue.size());

    }

    @Test
    public void testSizeInMultipleObjectQueueRemovingOneObject() {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.remove();
        Assertions.assertEquals(2, queue.size());
    }
}
