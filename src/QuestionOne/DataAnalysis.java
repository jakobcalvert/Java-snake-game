/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class DataAnalysis<E> {

    private E[] data;
    private Queue<E> queue;
    private Stack<E> stack;

    public DataAnalysis(E[] data) {
        this.data = data;
        this.queue = new Queue<>();
        this.stack = new Stack<>();
    }

    public boolean isSymmetrical() {

        for (int i = 0; i < data.length; i++) {
            this.queue.enqueue(this.data[i]);
            this.stack.push(this.data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            if (!(this.queue.dequeue().equals(this.stack.pop()))) {
                return false;
            }
        }
        return true;
    }

}
