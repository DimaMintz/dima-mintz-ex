import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static double number = 5;

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr1 = {{2,3},{6,7}};
        System.out.println(q2(arr1, arr));

        //q3
        Thread threadPlus = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    number = number + 1;
                }
            }
        });

        Thread threadMinus = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    number = number - 1;
                }
            }
        });

        Thread threadMult = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    number = number * 2;
                }
            }
        });

        Thread threadDiv = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    number = number / 4;
                }
            }
        });

        threadPlus.start();
        threadMinus.start();
        threadMult.start();
        threadDiv.start();

        try {
            threadPlus.join();
            threadMinus.join();
            threadMult.join();
            threadDiv.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(number);
    }

    public static void q1() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int id = scanner.nextInt();
        int numberToAdd = id % 10;
        int position = (id/10) % 10;
        long newNumber = 0;
        long mult = 1;
        for(int i = 1; i <= 10; i++) {
            if(position == i-1) {
                newNumber = newNumber + (numberToAdd * mult);
            }
            else {
                newNumber = newNumber + ((id%10)*mult);
                id = id / 10;
            }
            mult = mult * 10;
        }
        System.out.println("the name is: " + name + " and the new id is: " + newNumber);
    }

    public static boolean q2(int[][] smallMatrix, int[][] bigMatrix) {
        //int[][] smallMatrix = new int[10][10];
        //int[][] bigMatrix = new int[40][40];
        //int[][] smallInBigMatrix = new int[40][40];
        boolean isContains = true;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                isContains = true;
                int start = i;
                int end = j;
                for(int k = i; k < 2; k++) {
                    for(int z = j; z < 2; z++) {
                        if(!(smallMatrix[k-start][z-end] == bigMatrix[k][z])) {
                            isContains = false;
                            break;
                        }
                        else {
                            isContains = true;
                        }
                    }
                    if(!isContains) {
                        break;
                    }
                }
                if(isContains) {
                    return true;
                }
            }
        }
        return false;
    }

    public static double q4(int x, int n) {
        double sum = 0;
        double mone = 0;
        double mehane = 0;
        double tempSum = 0;
        for(int i = 1; i <= n; i++) {
            mone = Math.pow(x, i * 2);
            mehane = azeret(i);
            tempSum = mone / mehane;
            if(i%2 == 0) {
                sum = sum + tempSum;
            }
            else {
                sum = sum - tempSum;
            }
            //mone = 0;
            //mehane = 0;
            //tempSum = 0;
        }
        return sum;
    }

    public static double azeret(int x) {
        double sum = 1;
        for(int i = 1; i <= x; i++) {
            sum = sum * i;
        }
        return sum;
    }
}
