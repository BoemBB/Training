import java.util.LinkedList;
import java.util.Objects;

public class MyLinkedList<E extends Comparable <? super E>> implements MyList<E> {

    private class Node<E extends Comparable <? super E>> {
        E element;
        Node<E> previous;
        Node<E> next;

        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            if (next == null && node.next == null && previous == null && node.previous == null){
                return element.equals(node.element);
            } else if (next == null && node.next == null) {
                return element.equals(node.element) && previous.element.equals(node.previous.element);
            } else if (previous == null && node.previous == null){
                return element.equals(node.element) && next.element.equals(node.next.element);
            }  else {
                return element.equals(node.element) && next.element.equals(node.next.element) && previous.element.equals(node.previous.element);
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, previous, next);
        }
    }

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;


    @Override
    public boolean add(E e) {
        Node<E> newPenultimateNode = lastNode;
        Node<E> newNode = new Node<>(e, newPenultimateNode, null);
        lastNode = newNode;
        if (newPenultimateNode == null) {
            firstNode = newNode;
        } else {
            newPenultimateNode.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        if (e == null) {
            for (Node<E> currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.element == null) {
                    unlink(currentNode);
                    return true;
                }
            }
        } else {
            for (Node<E> currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.element.equals(e)) {
                    unlink(currentNode);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void sort() {
        quickSort(firstNode, lastNode);
    }

    private void quickSort(Node<E> firstNode, Node<E> lastNode) {
        if(lastNode != null && firstNode != lastNode && firstNode != lastNode.next){
            MyLinkedList<E>.Node<E> temp = partition(firstNode, lastNode);
            quickSort(firstNode, temp.previous);
            quickSort(temp.next, lastNode);
        }
    }

    private MyLinkedList<E>.Node<E> partition(Node<E> firstNode, Node<E> lastNode) {
        // this is a pivot
        E element = lastNode.element;

        MyLinkedList<E>.Node<E> i = firstNode.previous;

        for (MyLinkedList<E>.Node<E> j = firstNode; j != lastNode; j = j.next) {
            if (j.element.compareTo(element) < 0) {
                // Similar to i++ for array
                i = (i == null) ? firstNode : i.next;
                E temp = i.element;
                i.element = j.element;
                j.element = temp;
            }
        }
        i = (i == null) ? firstNode : i.next;  // Similar to i++
        E temp = i.element;
        i.element = lastNode.element;
        lastNode.element = temp;

        return i;
    }

    private E unlink(Node<E> e) {
        E element = e.element;
        Node<E> previousNode = e.previous;
        Node<E> nextNode = e.next;

        if (previousNode == null) {
            firstNode = nextNode;
        } else {
            previousNode.next = nextNode;
            e.previous = null;
        }

        if (nextNode == null) {
            lastNode = previousNode;
        } else {
            nextNode.previous = previousNode;
            e.next = null;
        }

        e.element = null;
        size--;

        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size && firstNode.equals(that.firstNode) && lastNode.equals(that.lastNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNode, lastNode, size);
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "firstNode=" + firstNode +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }
}

