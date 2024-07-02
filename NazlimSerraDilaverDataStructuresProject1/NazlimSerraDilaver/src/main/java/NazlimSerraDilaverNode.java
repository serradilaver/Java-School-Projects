/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author serra
 */
public class NazlimSerraDilaverNode<T> {

    T value;
    NazlimSerraDilaverNode<T> next;
    NazlimSerraDilaverNode<T> child;

    public NazlimSerraDilaverNode(T value) {
        this.value = value;
        this.next = null;
        this.child = null;
    }
}
