public class UndoRedo<T> {

    private class Node {
        T value;
        Node prev;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public void addState(T value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            if (current != tail) {
                current.next = null;
                tail = current;
            }

            newNode.prev = current;
            current.next = newNode;
            tail = newNode;
            current = newNode;
        }
        size++;
    }

    public T undo() {
        if (current == null || current.prev == null) {
            System.out.println("Cannot undo.");
            return null;
        }
        current = current.prev;
        return current.value;
    }

    public T redo() {
        if (current == null || current.next == null) {
            System.out.println("Cannot redo.");
            return null;
        }
        current = current.next;
        return current.value;
    }

    public T getCurrentState() {
        return current != null ? current.value : null;
    }

    public void printStates() {
        Node temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.value + "] ");
            } else {
                System.out.print(temp.value + " ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
