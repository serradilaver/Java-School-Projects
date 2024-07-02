/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author serra
 */
public class NazlimSerraDilaverLinkedList<T> {

    NazlimSerraDilaverNode<T> head;

    public NazlimSerraDilaverLinkedList() {
        this.head = null;
    }

    public boolean contains(T value) {
        NazlimSerraDilaverNode current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void add(T value) {
        if (head == null) {
            head = new NazlimSerraDilaverNode(value);
            return;
        }

        NazlimSerraDilaverNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new NazlimSerraDilaverNode(value);
    }

    public void clear() {
        head = null;
    }
}
