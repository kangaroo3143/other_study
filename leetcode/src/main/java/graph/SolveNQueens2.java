package graph;

/**
 * @author liubo
 * @ClassName SolveNQueens2
 * @Description TODO
 * @Date 2020/5/14
 * @since JDK 1.8
 */
public class SolveNQueens2 {

    static volatile int[] result = new int[8];

    public static void call8queens(int row) {
        if (row == 8) {
            printQ(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                call8queens(row + 1);
            }
        }
    }

    public static boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftup > 0 && result[i] == leftup) {
                return false;
            }
            if (rightup < 8 && result[i] == rightup) {
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public static void printQ(int[] result) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == result[i]) {
                    System.out.print("Q");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
        }

        System.out.println("----------------------------------------");
    }


    public static void main(String[] args) {
        call8queens(0);
    }

}
