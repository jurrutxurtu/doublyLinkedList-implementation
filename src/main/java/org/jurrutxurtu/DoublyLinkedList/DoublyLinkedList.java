package org.jurrutxurtu.DoublyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Hello world!
 *
 */
public class DoublyLinkedList<T> implements Iterable<T>, Cloneable
{
    private int size;
    private Node first;
    private Node last;
    
    public DoublyLinkedList<T> clone()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for(Node currentNode = first; currentNode != null; currentNode = currentNode.next)
        {
            doublyLinkedList.addLast(currentNode.item);
        }    
        return doublyLinkedList;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Node currentNode = first; currentNode != null; currentNode = currentNode.next)
        {
            sb.append(currentNode.item);
            sb.append(" ");
        }
        return sb.toString();
    } 

    public boolean isEmpty()
    {
        return size < 1;
    }

    public int size()
    {
        return size;
    }

    public void addFirst(T item)
    {
        Node oldFirstNode = first;
        Node newFirstNode = new Node(null, item, first);
        first = newFirstNode;
        if (isEmpty())
        {
            last = newFirstNode;
        }
        else
        {
            oldFirstNode.prev = newFirstNode;
        }
        size++;
    }

    public T getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public T removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        T removedItem = first.item;
        first = first.next;
        if (first == null)
        {
            last = null;
        }
        else
        {
            first.prev = null;
        }
        size--;
        return removedItem;
    }

    public void addLast(T item)
    {
        Node oldLastNode = last;
        Node newLastNode = new Node(last, item, null);
        last = newLastNode;
        if (isEmpty())
        {
            first = newLastNode;
        }
        else
        {
            oldLastNode.next = newLastNode;
        }
        size++;
    }
    
    public T getLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    public T removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        T removedItem = last.item;
        last = last.prev;
        if (last == null)
        {
            first = null;
        }
        else
        {
            last.next = null;
        }
        size--;
        return removedItem;
    }

    public T get(int index)
    {
        checkElementIndex(index);
        return node(index).item;
    }

    public T set(int index, T item)
    {
        checkElementIndex(index);
        Node node = node(index);
        T replacedItem = node.item;
        node.item = item;
        return replacedItem;
    }

    private void checkElementIndex(int i)
    {
        if (i < 0 || i > size - 1)
        {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
    }

    private Node node(int i)
    {
        Node node;
        if (i <= size / 2)
        {
            node = first;
            for (int j = 0; j < i; j++)
            {
                node = node.next;
            }
        }
        else
        {
            node = last;
            for (int k = size - 1; k > i; k--)
            {
                node = node.prev;
            }
        }
        return node;
    }
    
    public ListIterator<T> iterator()
    {
        return new DoublyLinkedListIterator();
    }
    
    public ListIterator<T> iterator(int i)
    {
        return new DoublyLinkedListIterator(i);
    }
    
    public Iterator<T> descendingIterator()
    {
        return new DoublyLinkedListDescendingIterator();
    }
    
    class Node
    {
        private T item;
        private Node next;
        private Node prev;

        public Node(Node prev, T item, Node next)
        {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private class DoublyLinkedListDescendingIterator implements Iterator
    {

        private final DoublyLinkedListIterator doublyLinkedListIterator;

        private DoublyLinkedListDescendingIterator()
        {
            doublyLinkedListIterator = new DoublyLinkedListIterator(size);
        }
        
        public boolean hasNext()
        {
            return doublyLinkedListIterator.hasPrevious();
        }

        public Object next()
        {
            return doublyLinkedListIterator.previous();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private class DoublyLinkedListIterator implements ListIterator
    {
        private Node lastReturned;
        private Node next = node(0);
        private int nextIndex = 0;

        DoublyLinkedListIterator()
        {}
        
        DoublyLinkedListIterator(int i)
        {
            next = i != size ? node(i) : null;
            nextIndex = i;
        }
        
        public boolean hasNext()
        {
            return nextIndex < size;
        }
        
        public boolean hasPrevious()
        {
            return nextIndex > 0;
        }

        public Object next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            else
            {
                lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.item;
            }
        }

        public Object previous()
        {
            if (!hasPrevious())
            {
                throw new NoSuchElementException();
            }
            else
            {
                lastReturned = next = next != null ? next.prev : last;
                nextIndex--;
                return lastReturned.item;
            }
        }

        public void add(Object e)
        {
            throw new UnsupportedOperationException();
        }

        public int nextIndex()
        {
            return nextIndex;
        }

        public int previousIndex()
        {
            return nextIndex - 1;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public void set(Object e)
        {
            throw new UnsupportedOperationException();
            
        }
    }

}