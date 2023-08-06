/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class LinkedList<E> {

    public int size;

    private Node<E> head;

    public LinkedList() {

    }

    public void add(E data) {
        this.size++;
        Node<E> dataNode = new Node<E>(data);
        if (this.head == null) {
            head = dataNode;
        } else if (head.next != null) {
            add(head.next, dataNode);
        } else {
            head.next = dataNode;
        }
    }

    private void add(Node current, Node data) {
        if (current.next != null) {
            add(current.next, data);
        } else {
            current.next = data;
        }

    }

    public void addInOrder(E data) {
        this.size++;
        Node<E> dataNode = new Node<>(data);
        if (head == null) {
            this.head = dataNode;
        } else if (dataNode.compareTo(this.head) <= 0) {
            dataNode.next = head;
            head = dataNode;
        } else if (head.next == null) {
            head.next = dataNode;
        } else {
            if (addInOrder(this.head.next, dataNode)) {
                dataNode.next = head.next;
                head.next = dataNode;

            }
        }
    }

    private boolean addInOrder(Node current, Node data) {
        if (data.compareTo(current) <= 0) {

            return true;
        } else if (current.next == null) {
            current.next = data;
        } else if (addInOrder(current.next, data)) {
            data.next = current.next;
            current.next = data;
        }
        return false;

    }

    public boolean contains(Node node) {

        if (this.head.next != null) {
            return (this.head.equals(node) || Contains(node, this.head.next));
        }
        return this.head.equals(node);
    }

    private boolean Contains(Node node, Node next) {

        if (next.next != null) {
            return (next.equals(node) || Contains(node, next.next));
        }
        return next.equals(node);

    }

    public void remove(Node node) {
        if (this.head.equals(node)) {
            this.head = this.head.next;
            this.size--;
        } else if (this.head.next != null && remove(node, this.head.next)) {
            this.head.next = this.head.next.next;
            this.size--;

        }

    }

    private boolean remove(Node node, Node next) {
        if (next.equals(node)) {
            return true;
        } else if (next.next != null && remove(node, next.next)) {
            next.next = next.next.next;
            this.size--;
        }
        return false;
    }

    public void removeFromHead() {
        if (head.next != null) {
            this.head = this.head.next;
            this.size--;
        }
    }

    public void removeFromTail() {
        if (this.head.next == null) {
            this.head = null;
        } else if (removeFromTail(this.head.next)) {
            this.head.next = null;

        }

    }

    private boolean removeFromTail(Node node) {
        if (node.next == null) {
            this.size--;
            return true;

        }
        if (removeFromTail(node.next)) {
            node.next = null;
        }
        return false;

    }

    public void printLinkedList() {
        System.out.print("[ " + this.head.data + " ");
        if (this.head.next != null) {
            printLinkedList(this.head.next);
        }
        System.out.println("]");
    }

    private void printLinkedList(Node node) {
        System.out.print("," + node.data + " ");
        if (node.next != null) {
            printLinkedList(node.next);
        }
    }

    public E getData(int index) {
        if (this.size > index && index >= 0 && head != null) {
            if (index == 0) {
                return this.head.data;

            }
            index--;
            return getData(index, head.next);

        }
        return null;

    }

    private E getData(int index, Node current) {
        if (index == 0) {
            return (E) current.data;
        }
        index--;
        return getData(index, current.next);

    }

    public Node getNode(int index) {
        if (this.size > index && index >= 0) {
            if (index == 0) {
                return this.head;

            }
            index--;
            return getNode(index, head.next);

        }
        return null;

    }

    private Node getNode(int index, Node current) {
        if (index == 0) {
            return current;
        }
        index--;
        return getNode(index, current.next);

    }

    public void removeNode(int index) {

        if (index == 0) {
            this.head = this.head.next;
            this.size--;
        } else if (head.next != null && removeNode(index - 1, head.next)) {
            this.head.next = this.head.next.next;
            this.size--;
        }

    }

    private boolean removeNode(int index, Node current) {
        if (index == 0) {
            return true;
        } else if (current.next != null && removeNode(index - 1, current.next)) {
            current.next = current.next.next;
            this.size--;
        }
        return false;
    }

    public void addAtHead(Node node) {
        node.next = this.head;
        this.head = node;
        this.size++;
    }

}
