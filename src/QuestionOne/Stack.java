/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class Stack<E> {

    private LinkedList<E> stack;
    private int size;

    public Stack() {
        this.stack = new LinkedList<>();
        this.size = 0;
    }

    public void push(E data) {
        this.stack.add(data);
        this.size++;
    }

    public E pop() {
        E data = this.stack.getData(this.getSize() - 1);
        this.stack.removeFromTail();
        this.size--;
        return data;
    }

    public int getSize() {
        return this.size;
    }

    public void printStack() {
        this.stack.printLinkedList();
    }

}
