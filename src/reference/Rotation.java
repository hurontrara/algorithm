package reference;


import java.util.Scanner;

public class Rotation {


    public static void main(String[] args) {

        int i, k;

        for (i = 2; i <= 9; i++) {

            for (k = 1; k <= 9; k++) {
                System.out.printf("%d X %d = %d\n", i, k, i * k);
            }

            System.out.printf("\n");
        }
    }

}