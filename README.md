## FrankensteinList
  A generic doubly linked list implementation in Java that maintains both ascending and descending order representations. Supports numeric types that are comparable (T extends Number & Comparable<T>).

## Features
  Generic: Supports numeric types (Number and Comparable<T>).
  Doubly Linked List: Efficient traversal with next/prev pointers.
  Sorted Lists: Automatically maintains ascending and descending order.
  Iterators: Traverse the list in normal, reverse, ascending, or descending order.
## Node Class
  The Node class represents a node in a doubly linked list, with additional pointers for maintaining sorted order in ascending and descending directions.
## Features
  Generic Type: Works with any numeric type (T extends Number & Comparable<T>).
  Next/Prev Pointers: Standard doubly linked list pointers (next, prev).
  Ascending/Descending Pointers: Additional pointers for sorted list management (asc, desc).
  Comparable: Implements Comparable<Node<T>> to support ordering by value.
## Methods
  Getters:
    getValue(), getPrev(), getNext(), getAsc(), getDesc().
  Setters:
    setPrev(Node<T> prev), setNext(Node<T> next), setAsc(Node<T> asc), setDesc(Node<T> desc).
  toString(): Returns the string representation of the node's value.
  compareTo(Node<T> other): Compares the node's value with another node.
## FrankensteinList Class
  The FrankensteinList class is a doubly linked list that maintains an ascending and descending order of its elements, and provides methods for adding, inserting, removing, and printing nodes.
  
## Methods
  1.add(T value): Adds a node at the end of the list.
  2.insert(T value, int position): Inserts a node at a specific position.
  3.pop(): Removes the last node.
  4.remove(int position): Removes a node at the given position.
  5.print(): Prints the list in normal, ascending, and descending order.
  6.Iterators: getNIterator(), getPIterator(), getAIterator(), getDIterator().
