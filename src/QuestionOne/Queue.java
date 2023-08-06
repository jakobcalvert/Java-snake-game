/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class Queue<E> {

    private LinkedList<E> queue;
    private int size;

    public Queue() {
        this.queue = new LinkedList<>();
        this.size = 0;
    }

    public void enqueue(E data) {
        queue.add(data);
        this.size++;
    }

    public E dequeue() {
        if (this.getSize() != 0) {
            E data = this.queue.getData(0);
            queue.removeFromHead();
            this.size--;
            return data;

        }
        return null;
    }

    public void printQueue() {
        this.queue.printLinkedList();
    }

    public int getSize() {
        return this.size;
    }

}
