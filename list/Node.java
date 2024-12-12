package list;

public class Node <T extends Number & Comparable <T>> implements Comparable <Node<T>>{
    private T value;
    private Node <T> next;
    private Node <T> prev;
    private Node <T> asc;
    private Node <T> desc;

    public Node(T  value) {
        this.value = value;
        this.next = null;
        this.prev = null;
        this.asc = null;
        this.desc = null;
    }
    public T getValue() {
        return this.value;
    }
    public Node <T> getPrev() {
        return this.prev;
    }
    public Node <T> getNext() {
        return this.next;
    }
    public Node <T> getAsc() {
        return this.asc;
    }
    public Node <T> getDesc() {
        return this.desc;
    }
    public void setPrev(Node <T> prev) {
        this.prev = prev;
    }
    public void setNext(Node <T> next) {
        this.next = next;
    }
    public void setAsc(Node <T> asc) {
        this.asc = asc;
    }
    public void setDesc(Node <T> desc) {
        this.desc = desc;
    }
    public String toString() {
        String res = "";
        return res += String.valueOf(value);
    }
    public int compareTo(Node <T> other) {
      return this.getValue().compareTo(other.getValue());
    }


}
