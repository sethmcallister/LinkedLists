import java.util.Iterator;
import java.util.NoSuchElementException;

public final class LinkedList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int place;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.place = 0;
    }

    public void add(T item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if(!isEmpty()) {
            Node previous = this.last;
            this.last = new Node(item, null);
            previous.setNext(this.last);
        }
        else {
            this.last = new Node(item, null);
            this.first = last;
        }
        place++;
    }

    public boolean remove(T item) throws IllegalAccessException
    {
        if(isEmpty()) {
            throw new IllegalAccessException();
        }

        boolean result = false;
        Node previous = this.first;
        Node current = this.first;

        while(current.getNext() != null || current == last) {
            if(current.getData().equals(item)) {
                if(this.place == 1) {
                    this.first = null;
                    this.last = null;
                } else if(current.equals(first)) {
                    this.first = current.getNext();
                } else if(current.equals(last)) {
                    this.last = previous;
                    this.last.setNext(null);
                } else {
                    previous.setNext(current.getNext());
                }
                place--;
                result = true;
                break;
            }
            previous = current;
            current = previous.getNext();
        }
        return result;
    }

    public int size() {
        return place;
    }

    public boolean isEmpty() {
        return place == 0;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(T item : this) {
            stringBuilder.append(item).append(" ");
        }
        return stringBuilder.toString();
    }

    private final class LinkedListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.getData();
            current = current.getNext();
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private final class Node {
        private final T data;
        private Node next;

        public Node(final T data, final Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(final Node next) {
            this.next = next;
        }
    }
}
