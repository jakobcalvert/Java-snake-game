/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class Node<E> {

    public E data;
    public Node next;

    public Node(E data) {
        this.data = data;
    }

    public Node() {

    }

    public String toString() {
        return this.data.toString();
    }

    public boolean equals(Node node) {
        return this.data.equals(node.data);
    }

    public int compareTo(Node node) {
        if (this.data.equals(node.data)) {
            return 0;
        }

        if (node.data.getClass().equals(this.data.getClass())) {
            if (node.data instanceof Integer) {
                return (Integer) this.data < (Integer) node.data ? -1 : 1;
            }
            if (node.data instanceof Double || node.data instanceof Float) {
                return (Double) this.data < (Double) node.data ? -1 : 1;
            }
            if (node.data instanceof Character) {
                return (char) this.data < (char) node.data ? -1 : 1;
            }
            if (node.data instanceof String) {
                String thisdata = (String) this.data;
                String nodedata = (String) node.data;
                return thisdata.compareTo(nodedata);
            }
        }

        return 1;
    }

}
