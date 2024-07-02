import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author serra
 */
public class NazlimSerraDilaverMultiLinkedList<T> {

    private NazlimSerraDilaverNode<T> head;
    private int rows;
    private int cols;

    public NazlimSerraDilaverMultiLinkedList(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Satır ve sütun sayıları 1'den büyük olmalıdır.");
        }
        this.rows = rows;
        this.cols = cols;
        initialize();
    }

    private void initialize() {
        this.head = new NazlimSerraDilaverNode<>(null);
        NazlimSerraDilaverNode<T> lastRowFirstNode = this.head;

        for (int row = 0; row < this.rows; row++) {
            NazlimSerraDilaverNode<T> current = lastRowFirstNode;
            for (int col = 1; col < this.cols; col++) {
                current.next = new NazlimSerraDilaverNode<>(null);
                current = current.next;
            }
            if (row < this.rows - 1) {
                lastRowFirstNode.child = new NazlimSerraDilaverNode<>(null);
                lastRowFirstNode = lastRowFirstNode.child;
            }
        }
    }

    public void add(int row, int col, T value) {
        if (row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new IllegalArgumentException("Geçersiz satır veya sütun indexi.");
        }
        NazlimSerraDilaverNode<T> current = this.head;
        for (int i = 0; i < row; i++) {
            current = current.child;
        }
        for (int j = 0; j < col; j++) {
            current = current.next;
        }
        current.value = value;
    }

    public T poll(int col) {
        Random rand = new Random();
        int nonEmptyCells = 0;
        NazlimSerraDilaverNode<T> columnHead = getColumnHead(col);
        while (columnHead != null) {
            if (columnHead.value != null) {
                nonEmptyCells++;
            }
            columnHead = columnHead.child;
        }

        if (nonEmptyCells == 0) {
            return null;
        }
        int targetIndex = rand.nextInt(nonEmptyCells);
        NazlimSerraDilaverNode<T> targetNode = getColumnHead(col);
        while (targetIndex > 0 || targetNode.value == null) {
            if (targetNode.value != null) {
                targetIndex--;
            }
            targetNode = targetNode.child;
        }

        T value = targetNode.value;
        targetNode.value = null;
        return value;
    }

    private NazlimSerraDilaverNode<T> getColumnHead(int col) {
        NazlimSerraDilaverNode<T> temp = head;
        for (int i = 0; i < col && temp != null; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public T getNodeValueAt(int row, int col) {
        if (row >= rows || col >= cols || row < 0 || col < 0) {
            throw new IllegalArgumentException("Geçersiz satır veya sütun indexi.");
        }
        NazlimSerraDilaverNode<T> current = head;
        for (int i = 0; i < row && current != null; i++) {
            current = current.child;
        }
        for (int j = 0; j < col && current != null; j++) {
            current = current.next;
        }
        return current != null ? current.value : null;
    }

    public void printList() {
        NazlimSerraDilaverNode<T> currentRow = this.head;
        while (currentRow != null) {
            NazlimSerraDilaverNode<T> currentCol = currentRow;
            while (currentCol != null) {
                System.out.print(currentCol.value + " ");
                currentCol = currentCol.next;
            }
            System.out.println();
            currentRow = currentRow.child;
        }
    }
}
