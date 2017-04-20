package org.jurrutxurtu.DoublyLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 
 */

public class DoublyLinkedListTest
{
    private static DoublyLinkedList doublyLinkedList;
    private static DoublyLinkedList populatedDoubleLinkedList;

    @Before
    public void setUp()
    {
        doublyLinkedList = new DoublyLinkedList();
        populatedDoubleLinkedList = new DoublyLinkedList();
        populatedDoubleLinkedList.addFirst(1);
        populatedDoubleLinkedList.addLast(2);
        populatedDoubleLinkedList.addLast(3);
        populatedDoubleLinkedList.addLast(4);
    }

    @Test
    public void testIterator()
    {
        ListIterator iterator = populatedDoubleLinkedList.iterator();
        assertTrue(iterator.hasNext());
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testIteratorOnEmpty()
    {
        ListIterator iterator = doublyLinkedList.iterator();
        assertTrue(iterator.hasNext());
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testToStringPrintsAsExpected()
    {
        String printedList = populatedDoubleLinkedList.toString();
        assertTrue(printedList.contains("1") && printedList.contains("2") && printedList.contains("3") && printedList.contains("4"));
    }

    @Test
    public void testCloningListKeepsValuesButChangesReferences()
    {
        DoublyLinkedList clonedList = populatedDoubleLinkedList.clone();
        assertEquals(populatedDoubleLinkedList.toString(), clonedList.toString());
        populatedDoubleLinkedList.removeFirst();
        assertFalse(populatedDoubleLinkedList.toString().equals(clonedList.toString()));
    }

    @Test
    public void testNewDoublyLinkedList()
    {
        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
    }

    @Test
    public void testRemoveFirstItem()
    {
        assertEquals(1, populatedDoubleLinkedList.removeFirst());
        assertEquals(3, populatedDoubleLinkedList.size());
    }

    @Test
    public void testRemoveLastItem()
    {
        assertEquals(4, populatedDoubleLinkedList.removeLast());
        assertEquals(3, populatedDoubleLinkedList.size());
    }

    @Test
    public void testGetItemFromIndex()
    {
        assertEquals(2, populatedDoubleLinkedList.get(1));
    }

    @Test
    public void testSetItemAtIndex()
    {
        assertEquals(3, populatedDoubleLinkedList.set(2, 5));
        assertEquals(5, populatedDoubleLinkedList.get(2));
        assertEquals(4, populatedDoubleLinkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetItemAtOutOfBoundsIndexThrowsIndexOutOfBoundsException()
    {
        populatedDoubleLinkedList.set(7, 5);
    }

    @Test
    public void testAddSingleItemFirst()
    {
        doublyLinkedList.addFirst(1);
        assertEquals(1, doublyLinkedList.getFirst());
        assertEquals(doublyLinkedList.getFirst(), doublyLinkedList.getLast());
    }

    @Test
    public void testAddSingleItemLast()
    {
        doublyLinkedList.addLast(2);
        assertEquals(2, doublyLinkedList.getLast());
        assertEquals(doublyLinkedList.getLast(), doublyLinkedList.getFirst());
    }

    @Test
    public void testToStringOnEmptyReturnsEmptyString()
    {
        assertTrue(doublyLinkedList.toString().isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstOnEmptyThrowsNoSuchElementException()
    {
        doublyLinkedList.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastOnEmptyThrowsNoSuchElementException()
    {
        doublyLinkedList.getLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstOnEmptyThrowsNoSuchElementException()
    {
        doublyLinkedList.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastOnEmptyThrowsNoSuchElementException()
    {
        doublyLinkedList.removeLast();
    }
}
