package Estruturas.Pilha;

import Labirinto.LP;

public class LinkedStack implements Stack {
    private static class Node{
        public Node previous;
        public LP value;
    }

    private Node top;
    private int size;

    public LinkedStack(){
        size = 0;
    }

    @Override
    public void add(LP element) {
        var node = new Node();
        node.previous = top;
        node.value = element;
        top = node;
        size++;
    }

    @Override
    public LP remove() {
        if (isEmpty()) throw new IllegalStateException("Empty stack (Underflow)");
        LP currentValue = top.value;
        top = top.previous;
        size--;
        return currentValue;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    public LP valor() {
        return top.value;
    }
}
