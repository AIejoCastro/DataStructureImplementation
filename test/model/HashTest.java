package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashTest {

    private HashTable<String, Integer> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>(4);
        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);
    }

    @Test
    public void testSizeReturnsCorrectValue() {
        assertEquals(3, hashTable.size());
        hashTable.put("d", 4);
        assertEquals(4, hashTable.size());
    }

    @Test
    public void testSizeReturnsZeroForEmptyTable() {
        hashTable.remove("a");
        hashTable.remove("b");
        hashTable.remove("c");
        assertEquals(0, hashTable.size());
    }

    @Test
    public void testSizeAfterRemovingItem() {
        hashTable.remove("a");
        assertEquals(2, hashTable.size());
    }

    @Test
    public void testIsEmptyReturnsFalseForNonEmptyTable() {
        assertFalse(hashTable.isEmpty());
    }

    @Test
    public void testIsEmptyReturnsTrueForEmptyTable() {
        hashTable.remove("a");
        hashTable.remove("b");
        hashTable.remove("c");
        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testIsEmptyAfterRemovingItem() {
        hashTable.remove("a");
        assertFalse(hashTable.isEmpty());
    }

    @Test
    public void testPutAddsNewItem() {
        hashTable.put("d", 4);
        assertEquals(Integer.valueOf(4), hashTable.get("d"));
    }

    @Test
    public void testPutUpdatesExistingItem() {
        hashTable.put("a", 5);
        assertEquals(Integer.valueOf(5), hashTable.get("a"));
    }

    @Test
    public void testPutDoesNotAddNullValues() {
        hashTable.put("d", null);
        assertNull(hashTable.get("d"));
    }

    @Test
    public void testGetReturnsCorrectValueForExistingKey() {
        assertEquals(Integer.valueOf(1), hashTable.get("a"));
    }

    @Test
    public void testGetReturnsNullForNonexistentKey() {
        assertNull(hashTable.get("d"));
    }

    @Test
    public void testGetAfterRemovingItem() {
        hashTable.remove("a");
        assertNull(hashTable.get("a"));
    }

    @Test
    public void testRemoveReturnsRemovedValue() {
        assertEquals(Integer.valueOf(1), hashTable.remove("a"));
    }

    @Test
    public void testRemoveRemovesItemFromTable() {
        hashTable.remove("a");
        assertNull(hashTable.get("a"));
    }

    @Test
    public void testRemoveReturnsNullForNonexistentKey() {
        assertNull(hashTable.remove("d"));
    }
}
