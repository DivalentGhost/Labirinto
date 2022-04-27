package Estruturas.Pilha;

import Labirinto.LP;

public interface Stack {
    void add(LP element);
    LP remove();
    void clear();
    int getSize();
    boolean isEmpty();
}
