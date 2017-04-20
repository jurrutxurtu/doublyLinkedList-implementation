package org.jurrutxurtu.DoublyLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class EmptyDoublyLinkedListTest
{
    private static DoublyLinkedList emptyDoublyLinkedList;
    private static ListIterator iterator;
    private static Iterator descendingIterator;
    
    @Before
    public void setUp()
    {
        emptyDoublyLinkedList = new DoublyLinkedList();
        iterator = emptyDoublyLinkedList.iterator();
        descendingIterator = emptyDoublyLinkedList.descendingIterator();
    }
    
    @Test
    public void testIsEmpty()
    {
        assertTrue(emptyDoublyLinkedList.isEmpty());
    }
    
    @Test
    public void testSizeIsZero()
    {
        assertEquals(0, emptyDoublyLinkedList.size());
    }
    
    @Test
    public void testAddSingleItemFirst() 
    {
        emptyDoublyLinkedList.addFirst(1);
        assertEquals(1, emptyDoublyLinkedList.getFirst());
        assertEquals(emptyDoublyLinkedList.getFirst(), emptyDoublyLinkedList.getLast());
    }
    
    @Test
    public void testAddSingleItemLast() 
    {
        emptyDoublyLinkedList.addLast(2);
        assertEquals(2, emptyDoublyLinkedList.getLast());
        assertEquals(emptyDoublyLinkedList.getLast(), emptyDoublyLinkedList.getFirst());
    }
    
    @Test
    public void testToStringReturnsEmptyString()
    {
        assertTrue(emptyDoublyLinkedList.toString().isEmpty());
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testGetFirstThrowsNoSuchElementException() 
    {
        emptyDoublyLinkedList.getFirst();
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testGetLastThrowsNoSuchElementException() 
    {
        emptyDoublyLinkedList.getLast();
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetZeroIndexThrowsIndexOutOfBoundsException() 
    {
        emptyDoublyLinkedList.get(0);
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetZeroIndexThrowsIndexOutOfBoundsException() 
    {
        emptyDoublyLinkedList.set(0, null);
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testRemoveFirstThrowsNoSuchElementException() 
    {
        emptyDoublyLinkedList.removeFirst();
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testRemoveLastThrowsNoSuchElementException() 
    {
        emptyDoublyLinkedList.removeLast();
    }
    
    @Test
    public void testIteratorNextIndexIsZero() 
    {
        assertEquals(0, iterator.nextIndex());
    }
    
    @Test
    public void testIteratorHasNextIsFalse() 
    {
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testIteratorHasPreviousIsFalse() 
    {
        assertFalse(iterator.hasPrevious());
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testIteratorNextThrowsNoSuchElementException() 
    {
        iterator.next();
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testIteratorPreviousThrowsNoSuchElementException() 
    {
        iterator.previous();
    }
    
    public void testDescendingIteratorHasNextIsFalse() 
    {
        assertFalse(descendingIterator.hasNext());
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testDescendingIteratorNextThrowsNoSuchElementException() 
    {
        descendingIterator.next();
    }
    
    
}
