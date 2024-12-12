package list;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class FrankensteinList <T extends Number & Comparable <T>>{
    Node <T> head;
    Node <T> tail;
    Node <T> ascHead;
    Node <T> descHead;

    public FrankensteinList() {
        head = null;
        tail = null;
        ascHead = null;
        descHead= null;
    } 
    private void updateOrder(Node<T> newNode) {
        if (ascHead == null && descHead == null) {
            ascHead = newNode;
            descHead = newNode;
            return;
        }
    
        if (newNode.compareTo(ascHead) <= 0) {
            newNode.setAsc(ascHead);
            ascHead.setDesc(newNode);
            ascHead = newNode;
        } else if (newNode.compareTo(descHead) >= 0) {
            newNode.setDesc(descHead);
            descHead.setAsc(newNode);
            descHead = newNode;
        } else {
            Node<T> curr = ascHead;
            while (curr.getAsc() != null && curr.getAsc().compareTo(newNode) < 0) {
                curr = curr.getAsc();
            }
            newNode.setAsc(curr.getAsc());
            newNode.setDesc(curr);
            if (curr.getAsc() != null) {
                curr.getAsc().setDesc(newNode);
            }
            curr.setAsc(newNode);
        }
    }
    
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            ascHead = newNode;
            descHead = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        updateOrder(newNode);
    }
    
    public void insert (T value, int position) throws RuntimeException{
        if (position < 0) {
            throw new RuntimeException("Position can not be negative number.");
        }
        if (head == null) {
            if (position == 0) {
                Node <T> newNode = new Node <>(value);
                head = newNode; 
                tail = newNode; 
                return;
            } 
            else {
                throw new RuntimeException("Index out of bounds. Cannot insert into an empty list at position " + position);
            }
        }
        if (position == 0) {
            Node <T> newNode = new Node <>(value);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            updateOrder(newNode);
            return;
        }
        Node<T> curr = head;
        for (int i = 0; i < position - 1; ++i) {
            if(curr.getNext() == null) {
                break;
            }
            curr = curr.getNext();
        }
        if (curr.getNext() == null) {
            System.out.println("Index out of bounds.Inserting at the end.");
            Node <T> newNode = new Node <>(value);
            curr.setNext(newNode);
            newNode.setPrev(curr);
            tail = newNode;
            updateOrder(newNode);
            return;
        }
        Node<T> newNode = new Node <>(value);
        newNode.setNext(curr.getNext());
        newNode.setPrev(curr);
        curr.getNext().setPrev(newNode);
        curr.setNext(newNode);
        updateOrder(newNode);
    }
    private void updateOrder2(Node <T> removed) {
        if (this.ascHead == removed) {
            if (removed.getAsc() != null) {
                removed.getAsc().setDesc(null);
            }
            ascHead = removed.getAsc();
            return;
        }
        if (this.descHead == removed) {
            if(removed.getDesc() != null) {
                removed.getDesc().setAsc(null);
            }
            descHead = removed.getDesc();
            return;
        }
        Node<T> curr = ascHead;
        while (curr.getAsc() != removed) {
            curr = curr.getAsc();
        }
        curr.setAsc(removed.getAsc());
        removed.getAsc().setDesc(curr);
    }
    public void pop() throws RuntimeException{
        if (head == null) {
            throw new RuntimeException("Invalid command for empty list.");
        }
        Node<T> curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        if(curr.getPrev() != null) {
            tail = curr.getPrev();
            tail.setNext(null);
            updateOrder2(curr);
        }
        else{
            tail = null;
            head = null;
            ascHead = null;
            descHead = null;
        }
        curr = null;

    }
    public void remove(int position) {
        if (position < 0) {
            throw new RuntimeException("Position can not be negative number.");
        }
        if (head == null) {
            throw new RuntimeException("Head is empty");
        }
        Node <T> curr = head;
        for (int i = 0; i < position; ++i) {
            if(curr.getNext() == null) {
                System.out.println("Index out of bounds.Removing at the last element.");
                pop();
                return;
            }
            curr = curr.getNext();
        }
        if (curr.getPrev() != null) {
            curr.getPrev().setNext(curr.getNext());
        }
        else {
            head = curr.getNext();
        }
        if (curr.getNext() != null) {
            curr.getNext().setPrev(curr.getPrev());
        }
        else {
            tail = curr.getPrev();
        }
        curr.setNext(null);
        curr.setPrev(null);
        updateOrder2(curr);
        curr = null;

    }

    public void print() {
            Node <T> tmp = head;
            System.out.print("Linked list: ");
            while(tmp != null) {
                System.out.print(tmp.getValue() + " ");
                tmp = tmp.getNext();
            }
            System.out.println();
            tmp = ascHead;
            System.out.print("Linked list in ascending order: ");
            while(tmp != null) {
                System.out.print(tmp.getValue() + " ");
                tmp = tmp.getAsc();
            }
            System.out.println();
            tmp = descHead;
            System.out.print("Linked list in descending order: ");
            while(tmp != null) {
                System.out.print(tmp.getValue() + " ");
               tmp = tmp.getDesc();
            }
            System.out.println();
    }
    public Iterator <Node <T>> getNIterator() {
        return new NextIterator();
    }
    class NextIterator implements Iterator <Node <T>> {
        Node<T> nextElement = head;
        public boolean hasNext() {
            return nextElement != null;
        }
        public Node<T> next() {
            if(!this.hasNext()) {
                throw  new NoSuchElementException();
            }
            Node<T> retValue = nextElement;
            nextElement = nextElement.getNext();
            return retValue;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    public Iterator <Node <T>> getPIterator() {
        return new PrevIterator();
    }

    class PrevIterator implements Iterator <Node <T>> {
        Node<T> prevElement = tail;
        public boolean hasNext() {
            return prevElement != null;
        }
        public Node<T> next() {
            if(!this.hasNext()) {
                throw  new NoSuchElementException();
            }
            Node<T> retValue = prevElement;
            prevElement = prevElement.getPrev();
            return retValue;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    public Iterator <Node <T>> getAIterator() {
        return new AscIterator();
    }
    class AscIterator implements Iterator <Node <T>> {
        Node <T>  nextElement = ascHead;
        public boolean hasNext() {
            return nextElement  != null;
        }
        public Node<T> next() {
            if(!this.hasNext()) {
                throw  new NoSuchElementException();
            }
            Node <T> retValue = nextElement;
            nextElement = nextElement.getAsc();
            return retValue;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    public Iterator <Node <T>> getDIterator() {
        return new DescIterator();
    }
    class DescIterator implements Iterator <Node <T>> {
        Node <T> nextElement = descHead;
        public boolean hasNext() {
            return nextElement != null;
        }
        public Node <T> next() {
            if(!this.hasNext()) {
                throw  new NoSuchElementException();
            }
            Node <T> retValue = nextElement;
            nextElement = nextElement.getDesc();
            return retValue;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
