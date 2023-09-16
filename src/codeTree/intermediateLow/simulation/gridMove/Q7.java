package codeTree.intermediateLow.simulation.gridMove;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q7 {

    private static class Grid {
        int x;
        int y;
        int dir;

        Grid(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

    public static int size;
    public static int[][] matrix;
    public static int maxCount = 0;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static List<Grid> gridList = new ArrayList<>();

    public static void main(String[] args) {

        settings();

        positionSettings();

        for (Grid grid : gridList) {
            move(grid);
        }

        System.out.println(maxCount);
    }

    private static void move(Grid grid) {

        int dir = grid.dir;
        int row = grid.x;
        int col = grid.y;
        int count = 0;
        // 움직이고
        // existCheck
        // 회전

        while (true) {

            count++;

            row += dx[dir];
            col += dy[dir];

            if (!existCheck(row, col)) {
                break;
            }

            if (matrix[row][col] == 1) {
                dir = getOneReflect(dir);
            }

            if (matrix[row][col] == 2) {
                dir = 3 - dir;
            }


        }

        if (count > maxCount) {
            maxCount = count;
        }


    }

    private static int getOneReflect(int dir) {
        switch (dir) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
        }

        return -1;

    }

    private static boolean existCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void positionSettings() {

        for (int col = 0; col < size; col++) {
            Grid grid1 = new Grid(-1, col, 3);
            Grid grid2 = new Grid(size, col, 1);
            gridList.add(grid1);
            gridList.add(grid2);

        }

        for (int row = 0; row < size; row++) {
            Grid grid1 = new Grid(row, -1, 0);
            Grid grid2 = new Grid(row, size, 2);
            gridList.add(grid1);
            gridList.add(grid2);
        }



    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }


}
