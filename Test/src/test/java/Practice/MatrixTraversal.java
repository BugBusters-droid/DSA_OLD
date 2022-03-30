package Practice;

import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class MatrixTraversal {

    static int MAX = 10000;
    static int[][] arr = new int[MAX][MAX];

    static void rowMajor() {
        int i, j;
        for (i = 0; i < MAX; i++) {
            for (j = 0; j < MAX; j++) {
                arr[i][j]++;
            }
        }
    }
    static void colMajor() {
        int i, j;
        for (i = 0; i < MAX; i++) {
            for (j = 0; j < MAX; j++) {
                arr[j][i]++;
            }
        }
    }
    @Test
    public void test(){
        // Time taken by row major order
        Instant start = Instant.now();
        rowMajor();
        Instant end = Instant.now();
        System.out.println("Row major access time : "+ Duration.between(start, end));

        // Time taken by column major order
        start = Instant.now();
        colMajor();
        end = Instant.now();
        System.out.printf("Column major access time : "+ Duration.between(start, end));
    }

    public static void diagonalOrder(int[][] arr, int n, int m) {

        // we will use a 2D vector to store the diagonals of our array the 2D vector will have (n+m-1)
        // rows that is equal to the number of diagonals
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(n + m - 1);
        for (int i = 0; i < n + m - 1; i++) {
            ans.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                (ans.get(i + j)).add(arr[i][j]);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            for (int j = ans.get(i).size() - 1; j >= 0; j--) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void diagonalTraversal(){
        int n = 5, m = 4;
        int[][] arr={
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 }};
        diagonalOrder(arr, n, m);
    }

    @Test
    public void printMatrixInDiagonal() {
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};

        int n = 4, mode = 0, it = 0, lower = 0;

        // 2n will be the number of iterations
        for (int t = 0; t < (2 * n - 1); t++) {
            int t1 = t;
            if (t1 >= n) {
                mode++;
                t1 = n - 1;
                it--;
                lower++;
            } else {
                lower = 0;
                it++;
            }
            for (int i = t1; i >= lower; i--) {
                if ((t1 + mode) % 2 == 0) {
                    System.out.println(mat[i][t1 + lower - i]);
                } else {
                    System.out.println(mat[t1 + lower - i][i]);
                }
            }
        }
    }
}
