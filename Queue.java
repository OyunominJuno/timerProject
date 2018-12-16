/**
 * Queue generic class that helps maintain references to nodes
 *
 * @author Oyunomin Munkhkhurel
 * @version 2018/03/11
 */
public class Queue<E> {
    private Node<E> front;
    private Node<E> end;
    
    /**
     * Full constructor for this class
     */
    public Queue() {
        front = null;
        end = null;
    }
    
    /**
     * Appends the specified element to the end of this list.
     *
     * @param  E element desired element to be added
     */
    public void add(E element) {
        ensure(element);
        Node<E> newNode = new Node<E>(element);
        if (front == null && end == null) {
            front = newNode;
            end = newNode;
        } else {
            Node<E> current = front;
            while(current.next != null) {
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = current.next;
            current.next = newNode;
            end = newNode;
        } 
    }
    
    /**
     * Returns the first element in this list.
     *
     * @return   first element in this list
     */
    public E peek() {
        E tempo = null;
        if (front == null && end == null) {
            //do nothing, list is empty
        } else {
            Node<E> current = front;
            tempo = current.data;
        }
        return tempo;
    }
    
    /**
     * Returns the last element in this list.
     *
     * @return   last element in this list
     */
    private E getLast() {
        E tempo = null;
        if (front == null && end == null) {
            //do nothing, list is empty
        } else {
            Node<E> current = end;
            tempo = current.data;
        }
        return tempo;
    }
    
    /**
     * Retrieves the element by desired index
     * 
     * @param int index desired element's index
     * @return element on that index
     */
    public E get(int index) {
        E tempo = null;
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("invalid index, must be smaller than size");
        }
        
        if (front == null && end == null) {
            //do nothing, list is empty
        } else if (index == 0) {
            tempo = peek();
        } else if (index == size() - 1) {
            tempo = getLast();
        } else {
            int count = 0;
            Node<E> current = front;
            while(current != null) {
                current = current.next;
                count++;
                if (count == index) {
                    tempo = current.data;
                }
            }   
        }
        return tempo;
    }
    
    /**
     * Returns the number of elements in this list.
     *
     * @return   the number of elements in this list.
     */
    public int size() {
        int count = 0;
        Node<E> current = front;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
    
    /**
     * Removes the desired element from the list 
     *
     * @param  E element desired element to be removed
     * @return true if successfully removed, if not, false
     */
    public void remove() {
        front = front.next;
    }
    
    /**
     * Sets null to the list
     */
    public void clear() {
        front = null;
    }
    
    /**
     * Ensures coming element is not null
     * 
     * @param E element that is being checked
     */
    public void ensure(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }
    }
    
    @Override
    /**
     * Retrieves verbal states of the list
     * 
     * @return verbal states of the list
     */
    public String toString() {
        String info = "";
        Node<E> current = front;
        while(current != null) {
            info += current.data + "\n";
            current = current.next;
        }
        return info;
    }
    
    /**
     * Internal private class that holds the object and reference
     */
    private class Node<E> {
        public Node<E> next; 
        public Node<E> prev;
        public E data;
        
        /**
         * Full constructor for this class
         */
        public Node(E data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
}
