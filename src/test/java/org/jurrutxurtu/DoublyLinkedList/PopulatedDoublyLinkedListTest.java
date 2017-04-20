package org.jurrutxurtu.DoublyLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class PopulatedDoublyLinkedListTest
{
    private static DoublyLinkedList populatedDoubleLinkedList;
    private static ListIterator iterator;
    private static ListIterator lastPositionIterator;
    private static Iterator descendingIterator;
    
    @Before
    public void setUp()
    {
        populatedDoubleLinkedList = new DoublyLinkedList();
        populatedDoubleLinkedList.addFirst(1);
        populatedDoubleLinkedList.addLast(2);
        populatedDoubleLinkedList.addLast(3);
        populatedDoubleLinkedList.addLast(4);
        
        iterator = populatedDoubleLinkedList.iterator();
        lastPositionIterator = populatedDoubleLinkedList.iterator(populatedDoubleLinkedList.size());
        descendingIterator = populatedDoubleLinkedList.descendingIterator();
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
    public void testAddItemFirst() 
    {
        populatedDoubleLinkedList.addFirst(0);
        assertEquals(0, populatedDoubleLinkedList.get(0));
    }
    
    @Test
    public void testAddItemLast() 
    {
        populatedDoubleLinkedList.addLast(5);
        assertEquals(5, populatedDoubleLinkedList.get(4));
    }
    
    @Test
    public void testGetFirstItem() 
    {
        assertEquals(1, populatedDoubleLinkedList.getFirst());
    }
    
    @Test
    public void testGetLastItem() 
    {
        assertEquals(4, populatedDoubleLinkedList.getLast());
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
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetItemAtInvalidIndexThrowsIndexOutOfBoundsException() 
    {
        populatedDoubleLinkedList.set(7, 5);
    }
    
    @Test
    public void testIteratorNextIndexIsZero() 
    {
        assertEquals(0, iterator.nextIndex());
    }
    
    @Test
    public void testIteratorHasNextIsTrueSeveralTimes() 
    {
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
    }
    
    @Test
    public void testIteratorHasPreviousIsFalse() 
    {
        assertFalse(iterator.hasPrevious());
    }
    
    @Test
    public void testLastPositionIteratorHasPreviousIsTrue() 
    {
        assertTrue(lastPositionIterator.hasPrevious());
    }
    
    @Test
    public void testLastPositionIteratorHasNextIsFalse() 
    {
        assertFalse(lastPositionIterator.hasNext());
    }
    
    @Test
    public void testIteratorNextLogicIsCorrect() 
    {
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testIteratorPreviousLogicIsCorrect() 
    {
        assertEquals(4, lastPositionIterator.previous());
        assertEquals(3, lastPositionIterator.previous());
        assertEquals(2, lastPositionIterator.previous());
        assertEquals(1, lastPositionIterator.previous());
        assertFalse(lastPositionIterator.hasPrevious());
    }
    
    @Test
    public void testIteratorNextAndPreviousCombinedLogicIsCorrect() 
    {
        assertEquals(1, iterator.next());
        assertEquals(1, iterator.previous());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(3, iterator.previous());
    }
    
    @Test
    public void testDescendingIteratorHasNextIsTrue() 
    {
        assertTrue(descendingIterator.hasNext());
    }
    
    @Test
    public void testDescendingIteratorNextLogicIsCorrect() 
    {
        assertEquals(4, descendingIterator.next());
        assertEquals(3, descendingIterator.next());
        assertEquals(2, descendingIterator.next());
        assertEquals(1, descendingIterator.next());
        assertFalse(descendingIterator.hasNext());
    }
}
