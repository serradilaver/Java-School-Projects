
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author serra
 */
import java.util.Random;

public class NazlimSerraDilaverTombolaUtils {

    public int[][] createFilledCard() {
        int[][] blockedCells = generateBlockedCells();
        NazlimSerraDilaverMultiLinkedList<Integer> card = new NazlimSerraDilaverMultiLinkedList<>(3, 9);
        int[][] filledArray = new int[3][9];
        Random rand = new Random();

        for (int col = 0; col < 9; col++) {
            int start = col * 10 + 1;
            int end = (col == 8) ? 91 : start + 10;

            for (int row = 0; row < 3; row++) {
                if (blockedCells[row][col] != -1) {
                    boolean unique;
                    int number;
                    do {
                        unique = true;
                        number = rand.nextInt(end - start) + start;
                        for (int checkRow = 0; checkRow <= row; checkRow++) {
                            Integer existingNumber = card.getNodeValueAt(checkRow, col);
                            if (existingNumber != null && existingNumber == number) {
                                unique = false;
                                break;
                            }
                        }
                    } while (!unique);

                    card.add(row, col, number);
                    filledArray[row][col] = number;
                } else {
                    filledArray[row][col] = -1;
                }
            }
        }

        return filledArray;
    }

    public static int[][] generateBlockedCells() {
        int[][] blockedCells = new int[3][9];
        Random rand = new Random();

        for (int row = 0; row < 3; row++) {
            int count = 0;
            while (count < 4) {
                int blockPosition = rand.nextInt(9);
                if (blockedCells[row][blockPosition] == 0) {
                    blockedCells[row][blockPosition] = -1;
                    count++;
                }
            }
        }

        return blockedCells;
    }

}
