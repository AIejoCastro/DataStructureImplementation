package model;

public class Stack <T> {

    private StackNode top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T element) {
        StackNode<T> newElement = new StackNode(element);
        newElement.next = top;
        top = newElement;
        size++;
    }

    public T pop() {
        T aux = (T) top.fact;
        top = top.next;
        size--;
        return aux;
    }

    public T top() {
        return (T) top.fact;
    }

    public int size() {
        return size;
    }

    public void emptyStack() {
        while (!isEmpty()) {
            pop();
        }
    }
}